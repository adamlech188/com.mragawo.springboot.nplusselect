package com.mragowo.springboot.nplusselect;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.mragowo.springboot.nplusselect.model.AuthorModel;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestBeanConfiguration {

	@TestConfiguration
	static class AuthorModelConfiguration {
		
		@Bean
		public AuthorModel authorModel() {
			return new AuthorModel(); 
		}
	}
	
	@Autowired
	private AuthorModel authorModel;
	
	@Test
	public void testBeanConfiguration() {
		
		authorModel.setFirstName("Adam");
		assertThat(authorModel).matches( am -> am.getFirstName().equals("Adam"));
	}
	
	
}
