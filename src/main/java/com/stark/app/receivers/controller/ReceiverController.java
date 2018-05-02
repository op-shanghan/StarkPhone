package com.stark.app.receivers.controller;

import com.stark.app.receivers.bean.ChatReceiverBean;
import com.stark.app.receivers.service.ReceiverService;
import com.stark.utils.result.ResultO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import java.util.Date;



@Controller
@RequestMapping("/receiver")
public class ReceiverController {

    @Resource
    private ReceiverService receiverService;

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping("/chatCrossDomain")
    @ResponseBody
    public ResultO<ChatReceiverBean> chatCrossDomain(ChatReceiverBean chatReceiverBean){
        chatReceiverBean.setWriteTime(new Date());
        receiverService.chatReceiver(chatReceiverBean);
        if(chatReceiverBean.getId()>0){
            return ResultO.success("存储成功",chatReceiverBean,null);
        }
        return ResultO.lose(500000,"数据库存储失败",null);
    }

    @RequestMapping("/chat")
    @ResponseBody
    public ResultO<ChatReceiverBean> chatReceiver(ChatReceiverBean chatReceiverBean){
        chatReceiverBean.setWriteTime(new Date());
        receiverService.chatReceiver(chatReceiverBean);
        if(chatReceiverBean.getId()>0){
            return ResultO.success("存储成功",chatReceiverBean,null);
        }
        return ResultO.lose(500000,"数据库存储失败",null);
    }

}
