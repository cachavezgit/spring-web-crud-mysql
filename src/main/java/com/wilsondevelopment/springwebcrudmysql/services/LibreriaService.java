package com.wilsondevelopment.springwebcrudmysql.services;

import java.util.List;

import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wilsondevelopment.springwebcrudmysql.entities.Library;
import com.wilsondevelopment.springwebcrudmysql.repositories.LibraryRepository;

@Service
public class LibreriaService {
	@Autowired  //Implicitamente haga el new del objeto
	LibraryRepository libraryRepository;
	
	public List<Library> listaLibrerias() {
		Iterable<Library> resultado = libraryRepository.findAll();
		List<Library> librerias = IterableUtils.toList(resultado);
		return librerias;
	}
}
