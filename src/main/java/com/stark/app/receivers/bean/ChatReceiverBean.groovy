package com.stark.app.receivers.bean

class ChatReceiverBean {

    private Long id

    private String sendTime

    private String sendId

    private String receiverId

    private String phoneType

    private Integer sendStruts = 0

    private Date writeTime

    Long getId() {
        return id
    }

    void setId(Long id) {
        this.id = id
    }

    String getSendTime() {
        return sendTime
    }

    void setSendTime(String sendTime) {
        this.sendTime = sendTime
    }

    String getSendId() {
        return sendId
    }

    void setSendId(String sendId) {
        this.sendId = sendId
    }

    String getReceiverId() {
        return receiverId
    }

    void setReceiverId(String receiverId) {
        this.receiverId = receiverId
    }

    String getPhoneType() {
        return phoneType
    }

    void setPhoneType(String phoneType) {
        this.phoneType = phoneType
    }

    Integer getSendStruts() {
        return sendStruts
    }

    void setSendStruts(Integer sendStruts) {
        this.sendStruts = sendStruts
    }

    Date getWriteTime() {
        return writeTime
    }

    void setWriteTime(Date writeTime) {
        this.writeTime = writeTime
    }
}
