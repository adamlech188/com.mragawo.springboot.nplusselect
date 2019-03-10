package com.mragowo.springboot.nplusselect;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mragowo.springboot.nplusselect.entities.Author;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestHibernateSession {

	private SessionFactory sessionFactory; 

	@Autowired
	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
	     
	}

	@Before
	public void setUp() {
		
	}
	
	@Test
	public void testHibernateSession() {
		Session session = this.sessionFactory.getCurrentSession(); 
	    session.getTransaction().begin();
	    Author author = session.get(Author.class, 1l); 
	    assertEquals(1l,author.getId().longValue());
	    session.close();
	    
	}
	
}
