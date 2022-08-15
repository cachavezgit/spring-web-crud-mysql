package com.wilsondevelopment.springwebcrudmysql.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wilsondevelopment.springwebcrudmysql.entities.Book;
import com.wilsondevelopment.springwebcrudmysql.services.BookService;

@RestController
@RequestMapping("/libros")
public class BookRestController {
	@Autowired
	BookService bookService;
	
	@GetMapping("/listaLibros")
	public ResponseEntity<List<Book>> listaLibros() {
		List<Book> libros = bookService.listaLibros();
		return new ResponseEntity<List<Book>>(libros, HttpStatus.OK);
	}
}
