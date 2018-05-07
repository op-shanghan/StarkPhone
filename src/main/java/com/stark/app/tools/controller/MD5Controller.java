package com.stark.app.tools.controller;

import com.stark.app.tools.logic.MD5;
import com.stark.app.tools.model.MD5Model;
import com.stark.app.tools.mongoDao.MD5MongoDao;
import com.stark.utils.result.ResultO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * MD5 控制器<br//>
 * 负责转换MD5
 */
@Controller
@RequestMapping("/tools/md5")
public class MD5Controller {

    @Resource
    private MD5MongoDao md5MongoDao;

    @CrossOrigin(origins = "*",maxAge = 3600)
    @RequestMapping("/toMD5")
    @ResponseBody
    public ResultO<MD5Model> toMD5(String psd){
        ResultO<MD5Model> resultO;
        try{
            MD5Model md5Model = md5MongoDao.findByPSD(psd);
            if(md5Model != null){
                resultO = ResultO.success("加密成功!!!",md5Model,null);
            }else{
                md5Model = new MD5Model();
                md5Model.setMd5(MD5.toMD5(psd));
                md5Model.setMd516(md5Model.getMd5().substring(8,24));
                md5Model.setOldPsd(psd);
                resultO = ResultO.success("加密成功!!!",md5Model,null);
                md5MongoDao.insertMD5Model(md5Model);
            }
        }catch (Exception e){
            resultO = ResultO.lose(50000,"加密失败!!!",e.getMessage());
        }
        return resultO;
    }

}
