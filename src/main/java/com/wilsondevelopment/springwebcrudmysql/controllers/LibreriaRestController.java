package com.wilsondevelopment.springwebcrudmysql.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wilsondevelopment.springwebcrudmysql.entities.Library;
import com.wilsondevelopment.springwebcrudmysql.services.LibreriaService;

@RestController
@RequestMapping("/librerias")
public class LibreriaRestController {
	@Autowired
	LibreriaService libreriaService;
	
	@GetMapping("/listaLibrerias")
	public ResponseEntity<List<Library>> listaLibrerias() {
		List<Library> librerias = libreriaService.listaLibrerias();
		return new ResponseEntity<List<Library>>(librerias, HttpStatus.OK);
	}
}
