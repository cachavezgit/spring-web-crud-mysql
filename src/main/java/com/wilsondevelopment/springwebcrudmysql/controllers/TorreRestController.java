package com.wilsondevelopment.springwebcrudmysql.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wilsondevelopment.springwebcrudmysql.entities.Torre;
import com.wilsondevelopment.springwebcrudmysql.services.TorreService;

@RestController
@RequestMapping("/torre")
public class TorreRestController {
	@Autowired
	TorreService torreService;
	
	@GetMapping("/listaTorres")
	public ResponseEntity<List<Torre>> listaTorres() {
		List<Torre> torres = torreService.listaTorres();
		return new ResponseEntity<List<Torre>>(torres, HttpStatus.OK);
	}
	
	@GetMapping("/detalleTorre/{idTorre}")
	public ResponseEntity<Torre> torreById(@PathVariable("idTorre")int idTorre) {
		if (!torreService.existsByIdTorre(idTorre))
			return new ResponseEntity("No existe la torre", HttpStatus.NOT_FOUND);
		
		Torre torre = torreService.getTorre(idTorre).get();
		return new ResponseEntity<Torre>(torre,HttpStatus.OK);
		
	}
}
