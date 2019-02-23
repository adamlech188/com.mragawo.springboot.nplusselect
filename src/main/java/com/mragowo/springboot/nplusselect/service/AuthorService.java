package com.mragowo.springboot.nplusselect.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mragowo.springboot.nplusselect.entities.Author;
import com.mragowo.springboot.nplusselect.repositories.AuthorRepository;

@Service
public class AuthorService {

	private AuthorRepository authorRepository; 

	@Autowired
	public void setAuthorRepository(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}


	public List<Author> findAuthorByLastName(String lastName) {
		return authorRepository.findAuthorByLastName(lastName);
	}
}
