package com.stark.app.receivers.service.impl

import com.stark.app.receivers.bean.ChatReceiverBean
import com.stark.app.receivers.dao.ChatLogsDao
import com.stark.app.receivers.service.ReceiverService
import org.springframework.stereotype.Service

import javax.annotation.Resource

@Service("receiverService")
class ReceiverServiceImpl implements ReceiverService{
    @Resource
    private ChatLogsDao receiverDao

    @Override
    ChatReceiverBean chatReceiver(ChatReceiverBean chatReceiverBean) {
        receiverDao.insertChatLog(chatReceiverBean)
        return chatReceiverBean
    }
}
