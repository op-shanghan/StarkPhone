package com.stark.app.user.controller;

import com.stark.app.user.bean.UserBean;
import com.stark.app.user.service.AreaInfoService;
import com.stark.utils.result.ResultO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("app/user/login")
public class LoginController {
    @Resource
    private AreaInfoService areaInfoService;

    @CrossOrigin(origins = "*",maxAge = 3600)
    @RequestMapping("/registerPC")
    @ResponseBody
    public ResultO<?> registerPC(UserBean userBean){
        return null;
    }

    /*@RequestMapping("/toTable")
    @ResponseBody
    public ResultO<?> toTable(){
        areaInfoService.toAllCitys();

        return ResultO.success("转移成功",null,null);
    }*/

    /*@CrossOrigin(origins = "*",maxAge = 3600)
    @RequestMapping("/getCity")
    @ResponseBody
    public ResultO<CityModel> getCity(){
        List<CityModel> cityModelList = areaInfoService.selectCitys();
        return ResultO.success("查询成功",null,cityModelList);
    }

    @CrossOrigin(origins = "*",maxAge = 3600)
    @RequestMapping("/getTheCity")
    @ResponseBody
    public ResultO<CityModel> getTheCity(String cityId){
        List<CityModel> cityModelList = areaInfoService.getTheCity(cityId);
        return ResultO.success("查询成功",null,cityModelList);
    }*/
}
