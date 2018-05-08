package com.stark.app.backstage.mongoDao.impl

import com.stark.app.backstage.model.BackUserModel
import com.stark.app.backstage.mongoDao.UserMongoDao
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Repository

import javax.annotation.Resource

@Repository("userMongoDao")
class UserMongoDaoImpl implements UserMongoDao{
    @Resource
    MongoTemplate mongoTemplate

    @Override
    void insertUser(BackUserModel backUserModel) {
        mongoTemplate.insert(backUserModel,"backUserModel")
    }

    @Override
    BackUserModel findByAccount(String account) {
        List<BackUserModel> backUserModels = mongoTemplate.find(Query.query(Criteria.where("account").is(account)), BackUserModel.class)
        if (null != backUserModels && backUserModels.size()>0){
            return backUserModels.get(0)
        }
        return null
    }

    @Override
    BackUserModel findByLogin(BackUserModel backUserModel) {
        List<BackUserModel> backUserModels = mongoTemplate.find(Query.query(Criteria.where("account").is(backUserModel.getAccount()).and("pwd").is(backUserModel.getPwd())), BackUserModel.class)
        if (null != backUserModels && backUserModels.size()>0){
            return backUserModels.get(0)
        }
        return null
    }
}
