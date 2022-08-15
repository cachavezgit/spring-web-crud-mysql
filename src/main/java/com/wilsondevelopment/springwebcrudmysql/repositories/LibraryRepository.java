package com.wilsondevelopment.springwebcrudmysql.repositories;

import org.springframework.data.repository.CrudRepository;

import com.wilsondevelopment.springwebcrudmysql.entities.Library;

public interface LibraryRepository extends CrudRepository<Library, Long> {

}
