package com.stark.fmss.users.controller

import com.stark.fmss.users.service.IndexService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

import javax.annotation.Resource

@Controller
@RequestMapping("/fmss/users")
class IndexController {




    @Resource
    IndexService indexService

    @RequestMapping("/index")
    @ResponseBody
    String index(){
        return indexService.Index()
    }

}
