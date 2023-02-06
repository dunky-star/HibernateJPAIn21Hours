package com.dunky.in21hours.repository;

import com.dunky.in21hours.entity.Person;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Using Spring JPA for database access.
 */

@Repository
@Transactional
public class PersonJpaRepository {

    //Connect to the database
    @PersistenceContext
    EntityManager entityManager;

    // Method to find a person by Id
    public Person findById(long id){
        return entityManager.find(Person.class, id);
    }

    // Method to insert/update a person

    public Person save (Person person) {
        entityManager.merge(person);
        return person;
    }

    // Method to delete a person
    public void deleteById(long id){
        Person person = findById(id);
        entityManager.remove(person);
    }

    // Query all persons from the database
    public List<Person> findAll(){
        TypedQuery<Person> namedQuery = entityManager.createNamedQuery("find_all_persons", Person.class);
        return namedQuery.getResultList();
    }

}
