package com.stark.app.user.service.impl

import com.stark.app.user.bean.CityInfoBean
import com.stark.app.user.dao.AreaInfoDao
import com.stark.app.user.model.CityModel
import com.stark.app.user.mongoDao.CityInfoMongoDao
import com.stark.app.user.service.AreaInfoService
import org.springframework.stereotype.Service

import javax.annotation.Resource

@Service("areaInfoService")
class AreaInfoServiceImpl implements AreaInfoService{

    @Resource
    private AreaInfoDao areaInfoDao
    @Resource
    private CityInfoMongoDao cityInfoMongoDao

    @Override
    List<CityModel> selectCitys() {
        return cityInfoMongoDao.selectCitys()
    }

    @Override
    List<CityModel> getTheCity(String cityId) {
        return cityInfoMongoDao.getTheCity(cityId)
    }
/*
    @Override
    void toAllCitys(){
        List<CityInfoBean> allCitysBeanList = areaInfoDao.selectAll()
        List<CityModel> cityModelList = new ArrayList<>()
        allCitysBeanList.each {cityBean->
            areaInfoDao.insertAllCity(cityBean)
            CityModel cityModel = cityBean.toCityModel()
            cityModelList.add(cityModel)
        }
        cityInfoMongoDao.insertCitys(cityModelList)
    }*/

}
