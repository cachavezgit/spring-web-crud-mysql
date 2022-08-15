package com.wilsondevelopment.springwebcrudmysql.services;

import java.util.List;

import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wilsondevelopment.springwebcrudmysql.entities.Book;
import com.wilsondevelopment.springwebcrudmysql.entities.Library;
import com.wilsondevelopment.springwebcrudmysql.repositories.BookRepository;
import com.wilsondevelopment.springwebcrudmysql.repositories.LibraryRepository;

@Service
public class BookService {
	@Autowired  //Implicitamente haga el new del objeto
	BookRepository bookRepository;
	
	public List<Book> listaLibros() {
		Iterable<Book> resultado = bookRepository.findAll();
		List<Book> libros = IterableUtils.toList(resultado);
		return libros;
	}
}
