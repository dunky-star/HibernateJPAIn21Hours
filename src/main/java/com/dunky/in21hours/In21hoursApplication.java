package com.dunky.in21hours;

import com.dunky.in21hours.entity.Review;
import com.dunky.in21hours.repository.CourseRepository;
import com.dunky.in21hours.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class In21hoursApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(In21hoursApplication.class, args);
	}

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	StudentRepository studentRepo;

	@Autowired
	private CourseRepository courseRepo;

	@Override
	public void run(String... args) throws Exception {

		studentRepo.saveStudentAndPassport();

		List<Review> reviews = new ArrayList<>();
		reviews.add(new Review("5", "Great Hands-on Stuff."));
		reviews.add(new Review("5", "Hatsoff."));

		courseRepo.addReviewsForCourse(10003L, reviews );

//		// Query all persons
//		logger.info("All user -> {}", jPaRepo.findAll());
	}
}
