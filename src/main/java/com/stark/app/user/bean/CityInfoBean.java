package com.stark.app.user.bean;

import com.stark.app.user.model.CityModel;

public class CityInfoBean extends AreaInfoBean {

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public CityModel toCityModel(){
        CityModel cityModel = new CityModel();
        cityModel.setCityId(this.getCityId());
        cityModel.setCityName(this.getCityName());
        cityModel.setfCityId(this.getfCityId());
        return cityModel;
    }
}
