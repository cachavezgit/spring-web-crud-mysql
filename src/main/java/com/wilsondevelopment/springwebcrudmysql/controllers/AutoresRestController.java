package com.wilsondevelopment.springwebcrudmysql.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wilsondevelopment.springwebcrudmysql.entities.Author;
import com.wilsondevelopment.springwebcrudmysql.entities.Library;
import com.wilsondevelopment.springwebcrudmysql.services.AuthorService;
import com.wilsondevelopment.springwebcrudmysql.services.LibreriaService;

@RestController
@RequestMapping("/autores")
public class AutoresRestController {
	@Autowired
	AuthorService authorService;
	
	@GetMapping("/listaAutores")
	public ResponseEntity<List<Author>> listaLibrerias() {
		List<Author> autores = authorService.ListaAutores();
		return new ResponseEntity<List<Author>>(autores, HttpStatus.OK);
	}

}
