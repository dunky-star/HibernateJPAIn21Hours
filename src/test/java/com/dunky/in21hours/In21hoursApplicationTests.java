package com.dunky.in21hours;

import com.dunky.in21hours.entity.Person;
import com.dunky.in21hours.repository.PersonJpaRepository;
import org.hibernate.query.Query;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest
class In21hoursApplicationTests {

	@Autowired
	PersonJpaRepository jPaRepo;

	@Autowired
	EntityManager em;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Test
	void contextLoads() {
		logger.info("Test is running...");
	}

	@Test
	public void findById_basic(){

		Person person = jPaRepo.findById(10001);
		assertEquals("Opiyo Kaligs", person.getName());
	}
	@Test
	@DirtiesContext
	public void deleteById_basic(){

		// Deleting
		jPaRepo.deleteById(10008L);
		assertNull(jPaRepo.findById(10008L));

	}

	@Test
	@DirtiesContext
	public void save_basic(){
		// Get a person
		Person person = jPaRepo.findById(10001L);
		assertEquals("Lamaro Arma", person.getName());
		// Update the details
		person.setName("Lamaro Arma");
		jPaRepo.save(person);

		// Check the value
		Person person1 = jPaRepo.findById(10001L);
		assertEquals("Lamaro Arma", person.getName());
		assertNull(jPaRepo.findById(10002L));

	}

	@Test
	public void native_queries_sql(){
		Query query = (Query) em.createNativeQuery("SELECT * FROM person WHERE id=:id", Person.class);
		query.setParameter("id", 10001L);
		List resultList = query.getResultList();
		logger.info("SELECT * FROM Person -> {}", resultList);
	}

}
