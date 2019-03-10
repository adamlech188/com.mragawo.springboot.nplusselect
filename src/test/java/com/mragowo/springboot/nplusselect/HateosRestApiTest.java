package com.mragowo.springboot.nplusselect;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.data.rest.webmvc.RepositoryController;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.rest.webmvc.support.RepositoryEntityLinks;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(RepositoryRestController.class)
public class HateosRestApiTest {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private MockMvc mvc;
	
	@Autowired
	public void setMvc(MockMvc mvc) {
		this.mvc = mvc;
	} 
	
	@Test
	public void initialTest() throws Exception {
		mvc.perform(get("/profile").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}
}
