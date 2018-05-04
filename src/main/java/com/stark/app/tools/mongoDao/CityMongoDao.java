package com.stark.app.tools.mongoDao;


import com.stark.app.tools.model.CityModel;

import java.util.List;

public interface CityMongoDao {

    List<CityModel> find();

    List<CityModel> findByFCityId(String cityId);


}
