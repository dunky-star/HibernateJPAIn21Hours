package com.dunky.in21hours.repository;

import com.dunky.in21hours.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path="courses")
public interface CourseJPaRepository extends JpaRepository<Course, Long> {
    List<Course> findByNameAndId(String name, Long id);
    List<Course> findByNameOrderByIdDesc(String name);

    @Query("Select  c  From Course c where name like '%100 Steps'")
    List<Course> courseWith100StepsInName();

    @Query(value = "Select  *  From Course c where name like '%100 Steps'", nativeQuery = true)
    List<Course> courseWith100StepsNativeQuery();
}
