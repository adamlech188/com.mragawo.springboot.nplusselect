package com.mragowo.springboot.nplusselect.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mragowo.springboot.nplusselect.entities.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

	public List<Author> findAuthorByLastName(@Param("lastName") String lastName); 
}