package com.dunky.in21hours;

import com.dunky.in21hours.entity.Course;
import com.dunky.in21hours.entity.Student;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = In21hoursApplication.class)
public class JPQLTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    @Test
    public void jpqlAllCourses() {
        Query query = em.createNamedQuery("query_get_all_courses");
        List resultList = query.getResultList();
        logger.info("Select  c  From Course c -> {}", resultList);
    }

    @Test
    public void jpql_courses_without_students() {
        TypedQuery<Course> query = em.createQuery("Select c from Course c where c.students is empty", Course.class);
        List<Course> resultList = query.getResultList();
        logger.info("Results -> {}", resultList);
        // [Course[Spring in 50 Steps]]
    }

    @Test
    public void jpql_courses_ordered_by_students() {
        TypedQuery<Course> query = em.createQuery("Select c from Course c order by size(c.students) desc", Course.class);
        List<Course> resultList = query.getResultList();
        logger.info("Results -> {}", resultList);
    }

    @Test
    public void jpql_students_passports_pattern() {
        TypedQuery<Student> query = em.createQuery("Select s from Student s where s.passport.number like '%1234%'", Student.class);
        List<Student> resultList = query.getResultList();
        logger.info("Results -> {}", resultList);
    }

    @Test
    public void join(){
        Query query = em.createQuery("Select c, s from Course c JOIN c.students s");
        List<Object[]> resultList = query.getResultList();
        logger.info("Results Size -> {}", resultList.size());
        for(Object[] result:resultList){
            logger.info("Course{} Student{}", result[0], result[1]);
        }
    }

    @Test
    public void left_join(){
        Query query = em.createQuery("Select c, s from Course c LEFT JOIN c.students s");
        List<Object[]> resultList = query.getResultList();
        logger.info("Results Size -> {}", resultList.size());
        for(Object[] result:resultList){
            logger.info("Course{} Student{}", result[0], result[1]);
        }
    }

    @Test
    public void cross_join(){
        Query query = em.createQuery("Select c, s from Course c, Student s");
        List<Object[]> resultList = query.getResultList();
        logger.info("Results Size -> {}", resultList.size());
        for(Object[] result:resultList){
            logger.info("Course{} Student{}", result[0], result[1]);
        }
    }


}
