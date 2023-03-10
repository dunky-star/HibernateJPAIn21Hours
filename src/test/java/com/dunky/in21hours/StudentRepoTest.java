package com.dunky.in21hours;

import com.dunky.in21hours.entity.Address;
import com.dunky.in21hours.entity.Student;
import com.dunky.in21hours.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@RunWith(SpringRunner.class)
@SpringBootTest
class StudentRepoTest {
    @Autowired
    StudentRepository studentRepo;
    @Autowired
    EntityManager em;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Test
    void contextLoads() {
        logger.info("Test is running...");
    }

    @Test
    @Transactional
    public void queryStudentPlusPassport() {
        Student student = em.find(Student.class,  10007L);
        logger.info("student -> {}", student);
        logger.info("passport -> {}", student.getPassport());
    }

    @Test
    @Transactional
    public void queryStudentAndCourses() {
        Student student = em.find(Student.class, 20001L);

        logger.info("student -> {}", student);
        logger.info("courses -> {}", student.getCourses());
    }

    @Test
    @DirtiesContext
    public void persistenceContextTest() {
        studentRepo.operationsPersistenceContext();
    }

    @Test
    @Transactional
    public void setAddressDetails() {
        Student student = em.find(Student.class, 20001L);
        student.setAddress(new Address("No 101", "Some Street", "Queensland"));
        em.flush();
    }
}

