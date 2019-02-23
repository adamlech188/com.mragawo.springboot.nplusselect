package com.mragowo.springboot.nplusselect;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mragowo.springboot.nplusselect.entities.Author;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EntityManagerTest {

	private EntityManagerFactory entityManagerFactory;

	private EntityManager em;
	
	@Autowired
	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}
	
	@Before
	public void setUp() {
		 em = this.entityManagerFactory.createEntityManager(); 
		
	}
	
	@After
	public void close() {
		em.close();
	}
	@Test
	public void testEntityManager() {

		em.getTransaction().begin();
		Author author = em.find(Author.class, 1l);
		long id = author.getId();
		assertEquals(1l, id);
		
	}
}
