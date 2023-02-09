package com.dunky.in21hours.repository;

import com.dunky.in21hours.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseJPaRepository extends JpaRepository<Course, Long> {

}
