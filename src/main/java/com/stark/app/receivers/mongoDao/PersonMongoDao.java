package com.stark.app.receivers.mongoDao;


import com.stark.app.receivers.model.Person;

import java.util.List;

public interface PersonMongoDao {

    List<Person> findAll();
    void insertPerson(Person user);

    void insertPersons(List<Person> users);

    void removePerson(String userName);
    void updatePerson();
    List<Person> findForRequery(String userName);

}
