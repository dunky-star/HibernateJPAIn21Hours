package com.dunky.in21hours;

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

	@Override
	public void run(String... args) throws Exception {

		studentRepo.saveStudentWithPassport();

//		// Query all persons
//		logger.info("All user -> {}", jPaRepo.findAll());
	}
}
