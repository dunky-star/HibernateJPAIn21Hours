package com.dunky.in21hours;

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
    public void queryStudentPlusDetails() {
        Student student = em.find(Student.class,  10007L);
        logger.info("student -> {}", student);
        logger.info("passport -> {}", student.getPassport());
    }

    @Test
    @DirtiesContext
    public void persistenceContextTest() {
        studentRepo.operationsPersistenceContext();
    }
}

