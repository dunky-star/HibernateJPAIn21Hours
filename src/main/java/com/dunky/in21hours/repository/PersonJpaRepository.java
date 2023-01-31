package com.dunky.in21hours.repository;

import com.dunky.in21hours.entity.Person;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Using Spring JPA for database access.
 */

@Repository
@Transactional
public class PersonJpaRepository {

    //Connect to the database
    @PersistenceContext
    EntityManager entityManager;

    public Person findById(long id){
        return entityManager.find(Person.class, id);
    }

}
