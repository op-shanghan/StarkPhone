package com.stark.app.tools.controller;

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

    @CrossOrigin(origins = "*",maxAge = 3600)
    @RequestMapping("/generator")
    @ResponseBody
    public ResultO<?> generator(String pwd,String key){



        return null;
    }

}
