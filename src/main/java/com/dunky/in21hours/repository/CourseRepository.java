package com.dunky.in21hours.repository;

import com.dunky.in21hours.entity.Course;
import com.dunky.in21hours.entity.Review;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
public class CourseRepository {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    public Course findById(Long id) {
        Course course = em.find(Course.class, id);
        logger.info("Course -> {}", course);
        return course;
    }

    public Course save(Course course) {

        if (course.getId() == null) {
            em.persist(course);
        } else {
            em.merge(course);
        }

        return course;
    }

    public void deleteById(Long id) {
        Course course = findById(id);
        em.remove(course);
    }

    public void withEntityManager() {
        Course course1 = new Course("Web Services in 100 Steps");
        em.persist(course1);

        Course course2 = findById(10001L);

        course2.setName("JPA in 50 Steps - Updated");

    }

    public void addReviewsForCourse(Long courseId, List<Review> reviews) {
        Course course = findById(courseId);
        logger.info("course.getReviews() -> {}", course.getReviews());
        for(Review review:reviews)
        {
            //setting the relationship
            course.addReview(review);
            review.setCourse(course);
            em.persist(review);
        }
    }


}
