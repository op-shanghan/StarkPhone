package com.stark.app.tools.controller;

import com.stark.app.tools.logic.CipherEcology;
import com.stark.utils.result.ResultO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 密码控制器
 */
@Controller
@RequestMapping("/tools/cipher")
public class CipherController {

    /**
     * AES 加密
     * @param pwd
     * @param key
     * @return
     */
    @CrossOrigin(origins = "*",maxAge = 3600)
    @RequestMapping("/aesGenerator")
    @ResponseBody
    public ResultO<?> aesGenerator(String pwd,String key){
        if(key.length() == 16){
            return ResultO.success("加密成功!!!",CipherEcology.aesEncrypt(pwd,key),null);
        }
        return ResultO.lose(50000,"加密失败，密钥需为16位字符串!!!",null);
    }

    /**
     * AES 解密
     * @param pwd
     * @param key
     * @return
     */
    @CrossOrigin(origins = "*",maxAge = 3600)
    @RequestMapping("/aesParser")
    @ResponseBody
    public ResultO<?> aesParser(String pwd,String key){
        if(key.length() == 16){
            return ResultO.success("解密成功!!!",CipherEcology.aesDecrypt(pwd,key),null);
        }
        return ResultO.lose(50000,"解密失败，密钥需为16位字符串!!!",null);
    }

    /**
     * SHA 加密
     * @param pwd
     * @return
     */
    @CrossOrigin(origins = "*",maxAge = 3600)
    @RequestMapping("/shaEncrypt")
    @ResponseBody
    public ResultO<?> shaEncrypt(String pwd){
        String sha = CipherEcology.shaEncrypt(pwd);
        if(null != sha){
            return ResultO.success("解密成功!!!",sha,null);
        }
        return ResultO.lose(50000,"加密失败!!!",null);
    }


}
