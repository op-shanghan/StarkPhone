package com.stark.utils.result;

import com.alibaba.fastjson.JSON;

import java.util.List;

public class ResultO<T> {

    /**编号**/
    private Integer code;
    /**消息**/
    private String msg;
    /**内容对象**/
    private T o;
    /**内容对象集合**/
    private List<T> os;
    /**错误内容**/
    private String error;



    /**
     * 成功
     * @param msg 消息
     * @param o 返回对象
     * @param os 返回对象集合
     * @param <T> 对象类型
     * @return
     */
    public static <T> ResultO success(String msg,T o,List<T> os){
        ResultO<T> resultO = new ResultO<>();
        resultO.code=20000;
        resultO.msg=msg;
        resultO.o=o;
        resultO.os=os;
        return resultO;
    }

    /**
     * 失败
     * @param code 失败编号
     * @param msg 失败消息
     * @param error 错误内容
     * @param <T> 对象类型
     * @return
     */
    public static <T> ResultO lose(Integer code,String msg,String error){
        ResultO<T> resultO = new ResultO<>();
        resultO.code=code;
        resultO.msg=msg;
        resultO.error=error;
        return resultO;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getO() {
        return o;
    }

    public void setO(T o) {
        this.o = o;
    }

    public List<T> getOs() {
        return os;
    }

    public void setOs(List<T> os) {
        this.os = os;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
