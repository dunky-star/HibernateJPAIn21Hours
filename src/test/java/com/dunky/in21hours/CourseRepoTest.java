package com.dunky.in21hours;

import com.dunky.in21hours.entity.Course;
import com.dunky.in21hours.repository.CourseRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.Subgraph;
import java.util.List;

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
    public void findById_Course() {
        Course course = courseRepo.findById(10001L);
        assertEquals("JPA in 50 Steps", course.getName());
    }


    @Test
    @DirtiesContext
    public void deleteById_Course() {
        courseRepo.deleteById(10007L);
        Assertions.assertNull(courseRepo.findById(10007L));
    }

    @Test
    @Transactional
    public void nPlusOneProblem() {
        List<Course> courses = em
                .createNamedQuery("query_get_all_courses", Course.class)
                .getResultList();
        for(Course course:courses){
            logger.info("Course -> {} Students -> {}",course, course.getStudents());
        }
    }

    @Test
    @Transactional
    public void solvingNPlusOneProblem() {
        EntityGraph<Course> entityGraph = em.createEntityGraph(Course.class);
        Subgraph<Object> subGraph = entityGraph.addSubgraph("students");
        List<Course> courses = em
                .createNamedQuery("query_get_all_courses", Course.class)
                .setHint("javax.persistnce.loadgraph", entityGraph)
                .getResultList();
        for(Course course:courses){
            logger.info("Course -> {} Students -> {}",course, course.getStudents());
        }
    }

    @Test
    @Transactional
    public void solvingNPlusOneProblem_JoinFetch() {
        List<Course> courses = em
                .createNamedQuery("query_get_all_courses_join_fetch", Course.class)
                .getResultList();
        for(Course course:courses){
            logger.info("Course -> {} Students -> {}",course, course.getStudents());
        }
    }

}
