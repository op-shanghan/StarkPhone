package com.stark.files.res.controller;

import com.stark.files.res.bean.ResBean;
import com.stark.files.res.logic.CataLogic;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class ResController {


    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping("/resources")
    @ResponseBody
    public ResBean resources(HttpServletRequest request){
        String path = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
        return CataLogic.getCats(basePath,"resources");
    }
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping("/resources/css")
    @ResponseBody
    public ResBean css(HttpServletRequest request){
        String path = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
        return CataLogic.getCats(basePath,"resources/css");
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping("/resources/css/fonts")
    @ResponseBody
    public ResBean fonts(HttpServletRequest request){
        String path = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
        return CataLogic.getCats(basePath,"resources/css/fonts");
    }


    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping("/resources/img")
    @ResponseBody
    public ResBean img(HttpServletRequest request){
        String path = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
        return CataLogic.getCats(basePath,"resources/img");
    }
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping("/resources/js")
    @ResponseBody
    public ResBean js(HttpServletRequest request){
        String path = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
        return CataLogic.getCats(basePath,"resources/js");
    }
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping("/resources/mp4")
    @ResponseBody
    public ResBean mp4(HttpServletRequest request){
        String path = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
        return CataLogic.getCats(basePath,"resources/mp4");
    }

    @RequestMapping("/res")
    public String res() {
        return "res/index";
    }
}
