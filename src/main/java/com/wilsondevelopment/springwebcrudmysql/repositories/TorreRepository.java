package com.wilsondevelopment.springwebcrudmysql.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wilsondevelopment.springwebcrudmysql.entities.Torre;

@Repository
public interface TorreRepository extends CrudRepository<Torre, Integer> {
	Optional<Torre> findByNombreTorre(String nombreTorre);
	
	boolean existsByNombreTorre(String nombreTorre);
}
