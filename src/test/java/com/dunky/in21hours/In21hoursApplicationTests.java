package com.dunky.in21hours;

import com.dunky.in21hours.entity.Student;
import com.dunky.in21hours.repository.StudentJpaRepository;
import org.hibernate.query.Query;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class In21hoursApplicationTests {

	@Autowired
	StudentJpaRepository jPaRepo;

	@Autowired
	EntityManager em;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Test
	void contextLoads() {
		logger.info("Test is running...");
	}
//
//	@Test
//	public void findById_basic(){
//
//		Student student = jPaRepo.findById(10001);
//		assertEquals("Lamaro Arma", student.getName());
//	}
//	@Test
//	@DirtiesContext
//	public void deleteById_basic(){
//
//		// Deleting
//		jPaRepo.deleteById(10008L);
//		assertNull(jPaRepo.findById(10008L));
//
//	}
//
//	@Test
//	@DirtiesContext
//	public void save_basic(){
//		// Get a student
//		Student student = jPaRepo.findById(10001L);
//		assertEquals("Lamaro Arma", student.getName());
//		// Update the details
//		student.setName("Lamaro Arma");
//		jPaRepo.save(student);
//
//		// Check the value
//		Student student1 = jPaRepo.findById(10001L);
//		assertEquals("Lamaro Arma", student.getName());
//		assertNull(jPaRepo.findById(10002L));
//
//	}

	@Test
	public void native_queries_sql(){
		Query query = (Query) em.createNativeQuery("SELECT * FROM student WHERE id=:id", Student.class);
		query.setParameter("id", 10001L);
		List resultList = query.getResultList();
		logger.info("SELECT * FROM Student -> {}", resultList);
	}

}
