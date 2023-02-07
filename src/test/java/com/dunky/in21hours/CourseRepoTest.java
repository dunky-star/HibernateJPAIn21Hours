package com.dunky.in21hours;

import com.dunky.in21hours.entity.Course;
import com.dunky.in21hours.repository.CourseRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = In21hoursApplication.class)
public class CourseRepoTest {
    @Autowired
    CourseRepository courseRepo;

    @Autowired
    EntityManager em;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Test
    void contextLoads() {
        logger.info("Test is running...");
    }

    @Test
    @Transactional
    public void findById_course() {
        Course course = courseRepo.findById(10001L);
        assertEquals("JPA in 50 Steps", course.getName());
    }

}
