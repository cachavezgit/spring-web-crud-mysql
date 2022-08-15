package com.wilsondevelopment.springwebcrudmysql.services;

import java.util.List;

import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wilsondevelopment.springwebcrudmysql.entities.Author;
import com.wilsondevelopment.springwebcrudmysql.entities.Library;
import com.wilsondevelopment.springwebcrudmysql.repositories.AuthorRepository;
import com.wilsondevelopment.springwebcrudmysql.repositories.LibraryRepository;

@Service
public class AuthorService {
	@Autowired  //Implicitamente haga el new del objeto
	AuthorRepository authorRepository;
	
	public List<Author> ListaAutores() {
		Iterable<Author> resultado = authorRepository.findAll();
		List<Author> autores = IterableUtils.toList(resultado);
		return autores;
	}
}
