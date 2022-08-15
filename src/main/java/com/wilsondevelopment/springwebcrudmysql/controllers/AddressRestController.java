package com.wilsondevelopment.springwebcrudmysql.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wilsondevelopment.springwebcrudmysql.entities.Address;
import com.wilsondevelopment.springwebcrudmysql.services.AddressService;

@RestController
@RequestMapping("/direcciones")
public class AddressRestController {
	@Autowired
	AddressService addressService;
	
	@GetMapping("/listaDirecciones")
	public ResponseEntity<List<Address>> listaDirecciones() {
		List<Address> direcciones = addressService.listaDirecciones();
		return new ResponseEntity<List<Address>>(direcciones, HttpStatus.OK);
	}
}