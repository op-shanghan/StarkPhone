package com.stark.utils.code

/**
 * 创建订单编号的方法
 */
class CreateOrderNumber {

    /**开始时间戳**/
    private final long twepoch = 1420041600000L
    /**机器id所占的位数**/
    private final long workerIdBits = 5L
    /**数据标识id所占的位数**/
    private final long datacenterIdBits = 5L

    /**支持的最大机器id,结果是31**/
    private final long maxWorkerId = -1L ^ (-1L << workerIdBits)
    /**支持的最大标识id，结果是31**/
    private final long maxDatacenterId = -1L ^ (-1L << datacenterIdBits)
    /**序列在id中占的位数**/
    private final long sequenceBits = 12L
    /**机器ID向做移12位**/
    private final long workerIdShift = sequenceBits
    /**数据标识id向左移17位(12+5)**/
    private final long datacenterIdShift = sequenceBits + workerIdShift
    /** 时间截向左移22位(5+5+12) **/
    private final long timestampLeftShift = sequenceBits + workerIdBits + datacenterIdBits
    /** 生成序列的掩码，这里为4095 (0b111111111111=0xfff=4095) */
    private final long sequenceMask = -1L ^ (-1L << sequenceBits)
    /** 工作机器ID(0~31) */
    private long workerId
    /** 数据中心ID(0~31) */
    private long datacenterId
    /** 毫秒内序列(0~4095) */
    private long sequence = 0L
    /** 上次生成ID的时间截 */
    private long lastTimestamp = -1L
    /**
     * 构造函数
     * @param workerId 工作ID (0~31)
     * @param datacenterId 数据中心ID (0~31)
     */
    CreateOrderNumber(long workerId, long datacenterId){
        if(workerId > maxWorkerId || workerId < 0){
            throw new IllegalArgumentException(String.format("worker Id can't be greater than %d or less than 0",maxWorkerId))
        }
        if(datacenterId > maxDatacenterId || datacenterId < 0){
            throw new IllegalArgumentException(String.format("datacenter Id can't be greater than %d or less than 0", maxDatacenterId))
        }
        this.workerId = workerId
        this.datacenterId = datacenterId
    }

    /**
     * 返回当前时间(毫秒级)
     * @return 当前时间
     */
    long timeGen(){
        return System.currentTimeMillis()
    }

    /**
     * 阻塞到下一个毫秒，直到获取到新的时间戳
     * @param lastTimestamp 上一次生成id的时间戳
     * @return 当前时间戳
     */
    long timeNextMillis(long lastTimestamp){
        long timestamp = timeGen()

        while (timestamp <= lastTimestamp){
            timestamp = timeGen()
        }

        return timestamp
    }

    /**
     * 获取下一个ID (线程安全)
     * @return
     */
    synchronized long nextId(){
        long timestamp = timeGen()
        //如果当前时间小于上一次ID生成的时间戳，说明系统时间回退过
        if(timestamp < lastTimestamp){
            throw  new RuntimeException(String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds",lastTimestamp - timestamp))
        }
        //如果是同意时间生成的，以毫秒内序号进行计算
        if(lastTimestamp == timestamp){
            sequence = (sequence + 1) & sequenceMask
            //毫秒内序列溢出
            if(sequence == 0){
                //阻塞到下一个毫秒获取到新的时间错
                timestamp = timeNextMillis(lastTimestamp)
            }
        }
        //时间戳改变，毫秒内序列重置
        else{
            sequence = 0L
        }
        //上一次生成ID的时间戳
        lastTimestamp = timestamp
        //移位并通过或运算拼接到一起组成64位ID
        return ((timestamp - twepoch) << timestampLeftShift) | (datacenterId << datacenterIdShift) | (workerId << workerIdShift) | sequence
    }

    /*static void main(String[] args) {
        CreateOrderNumber createOrderNumber = new CreateOrderNumber(0,0)
        for(int i = 0;i< 1000;i++){
            long id = createOrderNumber.nextId()
            println Long.toBinaryString(id)
            println id
        }
    }*/

}