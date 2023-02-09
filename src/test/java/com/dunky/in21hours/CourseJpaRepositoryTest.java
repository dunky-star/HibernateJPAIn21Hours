package com.dunky.in21hours;

import com.dunky.in21hours.entity.Course;
import com.dunky.in21hours.repository.CourseJPaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = In21hoursApplication.class)
public class CourseJpaRepositoryTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseJPaRepository repository;

    @Test
    public void findById_CoursePresent() {
        Optional<Course> courseOptional = repository.findById(10001L);
        assertTrue(courseOptional.isPresent());
    }

    @Test
    public void findById_CourseNotPresent() {
        Optional<Course> courseOptional = repository.findById(20001L);
        assertFalse(courseOptional.isPresent());
    }

    @Test
    public void sort() {
        List<Course> courses = repository.findAll(Sort.by(Sort.Direction.DESC, "name"));
        logger.info("Sorted Courses -> {} ", courses);
    }
}
