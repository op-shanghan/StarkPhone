package com.stark.app.tools.mongoDao.impl;

import com.stark.app.tools.model.CityModel;
import com.stark.app.tools.mongoDao.CityMongoDao;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("cityMongoDao")
public class CityMongoDaoImpl implements CityMongoDao {

    @Resource
    private MongoTemplate mongoTemplate;

    @Override
    public List<CityModel> find() {
        return mongoTemplate.find(Query.query(Criteria.where("fCityId").is(null)),CityModel.class);
    }

    @Override
    public List<CityModel> findByFCityId(String cityId) {
        return mongoTemplate.find(Query.query(Criteria.where("fCityId").is(cityId)),CityModel.class);
    }
}
