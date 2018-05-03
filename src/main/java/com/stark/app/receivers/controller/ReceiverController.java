package com.stark.app.receivers.controller;

import com.stark.app.receivers.bean.ChatReceiverBean;
import com.stark.app.receivers.model.Address;
import com.stark.app.receivers.model.Person;
import com.stark.app.receivers.mongoDao.PersonMongoDao;
import com.stark.app.receivers.service.ReceiverService;
import com.stark.utils.result.ResultO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/receiver")
public class ReceiverController {

    @Resource
    private ReceiverService receiverService;

    @Resource
    private PersonMongoDao personMongoDao;

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

    @RequestMapping("/testJpaDao")
    @ResponseBody
    private ResultO<Person> testJpaDaos(){
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            persons.add(new Person("name" + i, i, new Address("广州市", "天河区", i)));

        }
        personMongoDao.insertPersons(persons);
        return ResultO.success("测试成功!!!",null,persons);
    }

}
