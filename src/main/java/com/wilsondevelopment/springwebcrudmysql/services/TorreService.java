package com.wilsondevelopment.springwebcrudmysql.services;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import com.wilsondevelopment.springwebcrudmysql.entities.Torre;
import com.wilsondevelopment.springwebcrudmysql.repositories.TorreRepository;

@Transactional   //Manejo ácido de transacciones
				//ACID Atomicas Consistency Isolation Durable
@Service
public class TorreService {
	@Autowired  //Implicitamente haga el new del objeto
	TorreRepository torreRepository;
	
	public List<Torre> listaTorres() {
		Iterable<Torre> resultado = torreRepository.findAll();
		List<Torre> torres = IterableUtils.toList(resultado);
		return torres;
	}
	
	public Optional<Torre> getTorre(int idTorre) {
		return torreRepository.findById(idTorre);
	}
	
	public Optional<Torre> getByNombreTorre(String nombre) {
		return torreRepository.findByNombreTorre(nombre);
	} 
	
	public void saveTorre(Torre torre) {
		torreRepository.save(torre);
	}
	
	public void deleteTorre(int idTorre) {
		torreRepository.deleteById(idTorre);
	}
	
	public boolean existsByIdTorre(int idTorre) {
		return torreRepository.existsById(idTorre);
	}
	
	public boolean existsByNombreTorre(String nombre) {
		return torreRepository.existsByNombreTorre(nombre);
	}
	
}
