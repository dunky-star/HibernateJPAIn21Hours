package com.dunky.in21hours;

import com.dunky.in21hours.repository.CourseJPaRepository;
import com.dunky.in21hours.repository.CourseRepository;
import com.dunky.in21hours.repository.EmployeeRepository;
import com.dunky.in21hours.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class In21hoursApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(In21hoursApplication.class, args);
	}

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	StudentRepository studentRepo;

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	private CourseJPaRepository courseRepo;

	@Autowired
	private EmployeeRepository employeeRepo;

	@Override
	public void run(String... args) throws Exception {

		// studentRepo.insertStudentAndCourse(new Student("Jack", "Nairobi",new Date()),
				// new Course("Microservices in 100 Steps"));

		// studentRepo.saveStudentAndPassport();

		// List<Review> reviews = new ArrayList<>();
		// reviews.add(new Review(ReviewRating.FIVE, "An excellent course right there."));
		// reviews.add(new Review(ReviewRating.THREE, "Amazing. I love the course."));

		// courseRepository.addReviewsForCourse(10005L, reviews );

		// Query all persons
        // logger.info("All user -> {}", jPaRepo.findAll());

		// employeeRepo.insert(new PartTimeEmployee("Duncan", new BigDecimal("50")));
		// employeeRepo.insert(new FullTimeEmployee("Sheena", new BigDecimal("10000")));

		// logger.info("Full Time Employees -> {}",
				// employeeRepo.retrieveAllFullTimeEmployees());

		// logger.info("Part Time Employees -> {}",
				// employeeRepo.retrieveAllPartTimeEmployees());
	}
}
