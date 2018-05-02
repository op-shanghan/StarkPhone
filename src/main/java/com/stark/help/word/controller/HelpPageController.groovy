package com.stark.help.word.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@Controller
@RequestMapping("/help/page")
class HelpPageController {

    @RequestMapping(value = "/{name}/word",method = RequestMethod.GET)
    String word(@PathVariable("name") String name){
        return "/appDesign/"+name
    }

}
