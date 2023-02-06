package com.dunky.in21hours;

import com.dunky.in21hours.entity.Passport;
import com.dunky.in21hours.entity.Student;
import com.dunky.in21hours.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
class StudentRepoTests {
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
    public void saveStudentWithPassport() {
        Passport passport = new Passport("Z123456");
        em.persist(passport);

        Student student = new Student("Mike", "Kampala", new Date());

        student.setPassport(passport);
        em.persist(student);
    }

    @Test
    @Transactional
    public void retrieveStudentAndPassportDetails() {
        Student student = em.find(Student.class, 10001L);
        logger.info("student -> {}", student);
        logger.info("passport -> {}", student.getPassport());
    }



}

