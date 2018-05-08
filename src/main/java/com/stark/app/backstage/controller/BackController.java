package com.stark.app.backstage.controller;

import com.stark.app.backstage.model.BackUserModel;
import com.stark.app.backstage.mongoDao.UserMongoDao;
import com.stark.app.tools.logic.MD5;
import com.stark.utils.result.ResultO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/backstage/back")
public class BackController {
    @Resource
    private UserMongoDao userMongoDao;

    @RequestMapping("/register")
    @ResponseBody
    public ResultO<BackUserModel> register(BackUserModel backUserModel){
        BackUserModel oldUserModel = userMongoDao.findByAccount(backUserModel.getAccount());
        if(null == oldUserModel){
            String psdMD5 = MD5.toMD5(backUserModel.getPwd());
            backUserModel.setPwd(psdMD5);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String registerTime = simpleDateFormat.format(new Date());
            backUserModel.setCreateTime(registerTime);
            userMongoDao.insertUser(backUserModel);

            return ResultO.success("注册成功!!!",backUserModel,null);
        }
        return ResultO.lose(50000,"该用户已被注册!!!",null);
    }

    @RequestMapping("/login")
    @ResponseBody
    public ResultO<BackUserModel> login(BackUserModel backUserModel){
        String psdMD5 = MD5.toMD5(backUserModel.getPwd());
        backUserModel.setPwd(psdMD5);
        BackUserModel oldUserModel = userMongoDao.findByLogin(backUserModel);
        if(null != oldUserModel){
            oldUserModel.setPwd(null);
            return ResultO.success("登录成功!!!",oldUserModel,null);
        }
        return ResultO.lose(50000,"登录失败!!!",null);
    }

}
