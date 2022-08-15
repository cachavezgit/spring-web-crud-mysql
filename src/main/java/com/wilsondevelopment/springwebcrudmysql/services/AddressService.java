package com.wilsondevelopment.springwebcrudmysql.services;

import java.util.List;

import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wilsondevelopment.springwebcrudmysql.entities.Address;
import com.wilsondevelopment.springwebcrudmysql.entities.Library;
import com.wilsondevelopment.springwebcrudmysql.repositories.AddressRepository;
import com.wilsondevelopment.springwebcrudmysql.repositories.LibraryRepository;

@Service
public class AddressService {
	@Autowired  //Implicitamente haga el new del objeto
	AddressRepository addressRepository;
	
	public List<Address> listaDirecciones() {
		Iterable<Address> resultado = addressRepository.findAll();
		List<Address> direcciones = IterableUtils.toList(resultado);
		return direcciones;
	}
}
