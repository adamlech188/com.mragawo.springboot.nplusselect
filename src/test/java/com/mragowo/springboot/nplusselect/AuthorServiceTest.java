package com.mragowo.springboot.nplusselect;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.assertj.core.api.Condition;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mragowo.springboot.nplusselect.entities.Author;
import com.mragowo.springboot.nplusselect.service.AuthorService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthorServiceTest {

	private AuthorService authorService;

	@Autowired
	public void setAuthorService(AuthorService authorService) {
		this.authorService = authorService;
	}

	@Test
	public void testAuthorService() {

		List<Author> authors = authorService.findAuthorByLastName("Oaks");

		Condition<List<?>> condition = new Condition<>(l -> l.size() > 0, "List of author is not empty", "authors");
		assertThat(authors).is(condition);

	}

}
