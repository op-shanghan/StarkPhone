package com.stark.app.user.service

import com.stark.app.user.model.CityModel

interface AreaInfoService {

    /*void toAllCitys()*/

    List<CityModel> selectCitys()

    List<CityModel> getTheCity(String cityId)
}