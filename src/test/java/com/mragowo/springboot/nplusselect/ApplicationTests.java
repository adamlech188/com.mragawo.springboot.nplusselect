package com.mragowo.springboot.nplusselect;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mragowo.springboot.nplusselect.entities.Author;
import com.mragowo.springboot.nplusselect.repositories.AuthorRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	Logger logger = LoggerFactory.getLogger(this.getClass()); 
	
	private AuthorRepository authorRepository; 

	
	@Autowired
	public void setAuthorRepository(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}

	@Test
	public void contextLoads() {
		Iterable<Author> authors = authorRepository.findAll();

		assert(authors.iterator().hasNext()); 
		
	}

}
