package com.stark.app.tools.mongoDao.impl

import com.stark.app.tools.model.MD5Model
import com.stark.app.tools.mongoDao.MD5MongoDao
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Repository

import javax.annotation.Resource

@Repository("md5MongoDao")
class MD5MongoDaoImpl implements MD5MongoDao{

    @Resource
    private MongoTemplate mongoTemplate

    @Override
    MD5Model findByPSD(String psd){
        List<MD5Model> md5Models = mongoTemplate.find(Query.query(Criteria.where("oldPsd").is(psd)),MD5Model.class)
        if (md5Models.size() > 0){
            return md5Models.get(0)
        }
        return null
    }

    @Override
    void insertMD5Model(MD5Model md5Model) {
        mongoTemplate.insert(md5Model, "md5Model")
    }
}
