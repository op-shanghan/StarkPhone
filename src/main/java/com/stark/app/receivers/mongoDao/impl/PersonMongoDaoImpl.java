package com.stark.app.receivers.mongoDao.impl;

import com.stark.app.receivers.model.Person;
import com.stark.app.receivers.mongoDao.PersonMongoDao;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("personMongoDao")
public class PersonMongoDaoImpl implements PersonMongoDao {

    @Resource
    private MongoTemplate mongoTemplate;

    @Override
    public List<Person> findAll() {
        return mongoTemplate.findAll(Person.class, "person");
    }

    @Override
    public void insertPerson(Person user) {
        mongoTemplate.insert(user, "person");
    }

    @Override
    public void insertPersons(List<Person> users) {
        for (Person p :
                users) {
            insertPerson(p);
        }
    }

    @Override
    public void removePerson(String userName) {
        mongoTemplate.remove(Query.query(Criteria.where("name").is(userName)), "person");
    }

    @Override
    public void updatePerson() {
        mongoTemplate.updateMulti(Query.query(Criteria.where("age").gt(3).lte(5)), Update.update("age", 3), "person");
    }

    @Override
    public List<Person> findForRequery(String userName) {
        return mongoTemplate.find(Query.query(Criteria.where("name").is(userName)), Person.class);
    }
}
