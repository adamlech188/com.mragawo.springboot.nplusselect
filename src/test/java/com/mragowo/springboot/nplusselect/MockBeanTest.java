package com.mragowo.springboot.nplusselect;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Condition;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.mragowo.springboot.nplusselect.entities.Author;
import com.mragowo.springboot.nplusselect.repositories.AuthorRepository;
import com.mragowo.springboot.nplusselect.service.AuthorService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MockBeanTest {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@MockBean
	private AuthorRepository authorRepository;

	@Autowired
	private AuthorService authorService;
	
	@Before
	public void setUp() {
		Author author = new Author();
		author.setFirstName("John");
		author.setLastName("Oaks");
		List<Author> authors = new ArrayList<>();
		authors.add(author);
		Mockito.when(authorRepository.findAuthorByLastName("Oaks")).thenReturn(authors);
		Mockito.when(authorRepository.count()).thenReturn(1l); 
		
	}

	@Test
	public void initialTest() {
		List<Author> authors = authorService.findAuthorByLastName("Oaks");

		Condition<List<?>> condition = new Condition<>(l -> l.size() > 0, "List of author is not empty", "authors");
		assertThat(authors).is(condition);
	}

	@Test
	public void testAuthorRepository() {
		logger.info("Author repository size is: {}", authorRepository.count());
		assertThat(authorRepository.count()).isGreaterThan(0);

	}

}
