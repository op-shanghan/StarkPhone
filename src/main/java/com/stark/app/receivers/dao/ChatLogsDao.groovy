package com.stark.app.receivers.dao

import com.stark.app.receivers.bean.ChatReceiverBean

interface ChatLogsDao {

    Integer insertChatLog(ChatReceiverBean chatReceiverBean)
}