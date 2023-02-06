package com.dunky.in21hours.repository;

import com.dunky.in21hours.entity.Student;
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
public class StudentJpaRepository {

    //Connect to the database
    @PersistenceContext
    EntityManager entityManager;

    // Method to find a person by Id
    public Student findById(long id){
        return entityManager.find(Student.class, id);
    }

    // Method to insert/update a person

    public Student save (Student student) {
        entityManager.merge(student);
        return student;
    }

    // Method to delete a person
    public void deleteById(long id){
        Student student = findById(id);
        entityManager.remove(student);
    }

    // Query all persons from the database
    public List<Student> findAll(){
        TypedQuery<Student> namedQuery = entityManager.createNamedQuery("find_all_students", Student.class);
        return namedQuery.getResultList();
    }

}
