package com.stark.app.user.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/download")
public class DownloadController {

    @RequestMapping("/mp4/{fileName}")
    public String downloadMp4(@PathVariable("fileName") String fileName){
        if (fileName.split(".").length>0){
            fileName = fileName.split(".")[0];
        }
        return "redirect:/resources/mp4/"+fileName+".mp4";
    }





}
