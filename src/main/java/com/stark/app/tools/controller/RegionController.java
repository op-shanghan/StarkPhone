package com.stark.app.tools.controller;

import com.stark.app.tools.model.CityModel;
import com.stark.app.tools.mongoDao.CityMongoDao;
import com.stark.utils.result.ResultO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import java.util.List;

/**
 * 地区控制器<br/>
 * 负责地区处理
 * 获取省市区-通过省市区获取对应id
 */
@Controller
@RequestMapping("/tools/region")
public class RegionController {
    @Resource
    private CityMongoDao cityMongoDao;

    @CrossOrigin(origins = "*",maxAge = 3600)
    @RequestMapping("/getRegions/{cityId}")
    @ResponseBody
    public ResultO<?> getRegions(@PathVariable("cityId") String cityId){
        ResultO<CityModel> resultO = null;
        if(cityId.equals("null")){
            resultO = ResultO.success("查询成功",null,cityMongoDao.find());
        }else{
            List<CityModel> models = cityMongoDao.findByFCityId(cityId);
            if(models.size()>0){
                resultO = ResultO.success("查询成功",null,models);
            }
        }
        if (resultO == null){
            resultO = ResultO.lose(40000,"没有获取到数据!!!",null);
        }
        return resultO;
    }

    @CrossOrigin(origins = "*",maxAge = 3600)
    @RequestMapping("/getRegions")
    @ResponseBody
    public ResultO<?> getRegions(){
        ResultO<CityModel> resultO = null;
        List<CityModel> models = cityMongoDao.find();
        if(models.size()>0){
            resultO = ResultO.success("查询成功",null,models);
        }
        if (resultO == null){
            resultO = ResultO.lose(40000,"没有获取到数据!!!",null);
        }
        return resultO;
    }

    @CrossOrigin(origins = "*",maxAge = 3600)
    @RequestMapping("/toCityId")
    @ResponseBody
    public ResultO<?> toCityId(){



        return null;

    }


}
