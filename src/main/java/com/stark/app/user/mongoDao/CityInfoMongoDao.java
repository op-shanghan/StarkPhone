package com.stark.app.user.mongoDao;

import com.stark.app.user.model.CityModel;

import java.util.List;

public interface CityInfoMongoDao {

    List<CityModel> findAll();

    void insertCity(CityModel cityModel);

    void insertCitys(List<CityModel> cityModels);

    void removeCityModel(String cityName);

    void updateCityModel(CityModel cityModel);

    List<CityModel> findForRequery(String cityName);

    List<CityModel> selectCitys();

    List<CityModel> getTheCity(String cityId);
}
