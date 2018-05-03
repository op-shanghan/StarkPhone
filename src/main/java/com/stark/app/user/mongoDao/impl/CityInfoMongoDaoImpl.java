package com.stark.app.user.mongoDao.impl;

import com.stark.app.user.model.CityModel;
import com.stark.app.user.mongoDao.CityInfoMongoDao;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("cityInfoMongoDao")
public class CityInfoMongoDaoImpl implements CityInfoMongoDao{

    @Resource
    private MongoTemplate mongoTemplate;

    @Override
    public List<CityModel> findAll() {
        return mongoTemplate.findAll(CityModel.class, "cityModel");
    }

    @Override
    public void insertCity(CityModel cityModel) {
        mongoTemplate.insert(cityModel, "cityModel");
    }

    @Override
    public void insertCitys(List<CityModel> cityModels) {
        for (CityModel p :
                cityModels) {
            insertCity(p);
        }
    }

    @Override
    public void removeCityModel(String cityName) {
        mongoTemplate.remove(Query.query(Criteria.where("cityName").is(cityName)), "cityModel");
    }

    @Override
    public void updateCityModel(CityModel cityModel) {
        //mongoTemplate.updateMulti(Query.query(Criteria.where("age").gt(3).lte(5)), Update.update("age", 3), "person");
    }

    @Override
    public List<CityModel> findForRequery(String cityName) {
        return mongoTemplate.find(Query.query(Criteria.where("cityName").is(cityName)), CityModel.class);
    }

    @Override
    public List<CityModel> selectCitys() {
        return mongoTemplate.find(Query.query(Criteria.where("fCityId").is(null)),CityModel.class);
    }

    @Override
    public List<CityModel> getTheCity(String cityId) {
        return mongoTemplate.find(Query.query(Criteria.where("fCityId").is(cityId)),CityModel.class);
    }
}
