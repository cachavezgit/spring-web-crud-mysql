package com.wilsondevelopment.springwebcrudmysql.repositories;

import org.springframework.data.repository.CrudRepository;

import com.wilsondevelopment.springwebcrudmysql.entities.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
