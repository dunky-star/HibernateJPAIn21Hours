package com.dunky.in21hours;

import com.dunky.in21hours.entity.Person;
import com.dunky.in21hours.repository.PersonJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class In21hoursApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(In21hoursApplication.class, args);
	}

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJpaRepository jPaRepo;
	@Override
	public void run(String... args) throws Exception {
		// Finding
		logger.info("User id: 10001 -> {}", jPaRepo.findById(10001));

		// Inserting
		logger.info("Inserting: 10004 -> {}",
				jPaRepo.save(new Person(10004, "Tara", "New York", new Date())));
		logger.info("Inserting: -> {}",
				jPaRepo.save(new Person("Arma lamaro", "Vancouver", new Date())));

		// Updating
		logger.info("Updating: 10003 -> {}",
				jPaRepo.save(new Person(10003L, "Dede Pal", "Dubai", new Date())));


		// Query all persons
		logger.info("All user -> {}", jPaRepo.findAll());
	}
}
