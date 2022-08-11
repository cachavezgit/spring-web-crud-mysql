package com.wilsondevelopment.springwebcrudmysql.controllers;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wilsondevelopment.springwebcrudmysql.dtos.MensajeDTO;
import com.wilsondevelopment.springwebcrudmysql.dtos.TorreDTO;
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
			return new ResponseEntity(new MensajeDTO("No existe la torre"), HttpStatus.NOT_FOUND);
		
		Torre torre = torreService.getTorre(idTorre).get();
		return new ResponseEntity<Torre>(torre,HttpStatus.OK);
		
	}
	
	@GetMapping("/detalleNombre/{nombreTorre}")
	public ResponseEntity<Torre> torreByNombre(@PathVariable("nombreTorre")String nombreTorre) {
		if (!torreService.existsByNombreTorre(nombreTorre))
			return new ResponseEntity(new MensajeDTO("No existe la torre"), HttpStatus.NOT_FOUND);
		
		Torre torre = torreService.getByNombreTorre(nombreTorre).get();
		return new ResponseEntity<Torre>(torre,HttpStatus.OK);
		
	}
	
	@PostMapping("/crearTorre")
	public ResponseEntity<?> creaTorre(@RequestBody TorreDTO torreDTO) {
		if (StringUtils.isBlank(torreDTO.getNombreTorre()))
			return new ResponseEntity(new MensajeDTO("El nombre de la torre es obligatorio"), HttpStatus.BAD_REQUEST);
		
		if (torreDTO.getCantidadAptos() < 1 || (Integer) torreDTO.getCantidadAptos() == null)
			return new ResponseEntity(new MensajeDTO("La cantidad departamentos debe ser mayor o igual a 1"), HttpStatus.BAD_REQUEST);
		
		if (torreService.existsByNombreTorre(torreDTO.getNombreTorre()))
			return new ResponseEntity(new MensajeDTO("Ese nombre ya esta utilizado"), HttpStatus.BAD_REQUEST);
		
		Torre torre = new Torre(torreDTO.getNombreTorre(), torreDTO.getCantidadAptos());
		torreService.saveTorre(torre);
		return new ResponseEntity(new MensajeDTO("Torre dada de alta exitosamente"), HttpStatus.OK);
	}
	
	@PutMapping("/actualizarTorre/{idTorre}")
	public ResponseEntity<?> actualizaTorre(@PathVariable("idTorre")int idTorre, @RequestBody TorreDTO torreDTO) { 
		if (!torreService.existsByIdTorre(idTorre))
			return new ResponseEntity(new MensajeDTO("No existe la torre"), HttpStatus.NOT_FOUND);
		
		if (StringUtils.isBlank(torreDTO.getNombreTorre()))
			return new ResponseEntity(new MensajeDTO("El nombre de la torre es obligatorio"), HttpStatus.BAD_REQUEST);
		
		if (torreService.existsByNombreTorre(torreDTO.getNombreTorre()))
			return new ResponseEntity(new MensajeDTO("Ese nombre ya esta utilizado"), HttpStatus.BAD_REQUEST);
		
		if (torreDTO.getCantidadAptos() < 1 || (Integer) torreDTO.getCantidadAptos() == null)
			return new ResponseEntity(new MensajeDTO("La cantidad departamentos debe ser mayor o igual a 1"), HttpStatus.BAD_REQUEST);
		
		Torre torre = torreService.getTorre(idTorre).get();
		torre.setNombreTorre(torreDTO.getNombreTorre());
		torre.setCantidadAptos(torreDTO.getCantidadAptos());
		torreService.saveTorre(torre);
		return new ResponseEntity(new MensajeDTO("Torre actualizada exitosamente"), HttpStatus.OK);
	}
	
	
	@DeleteMapping("/borrarTorre/{idTorre}")
	public ResponseEntity<?> borraTorre(@PathVariable("idTorre")int idTorre) {
		if (!torreService.existsByIdTorre(idTorre))
			return new ResponseEntity(new MensajeDTO("No existe la torre"), HttpStatus.NOT_FOUND);
		torreService.deleteTorre(idTorre);
		return new ResponseEntity(new MensajeDTO("Torre borrada exitosamente"), HttpStatus.OK);
	}
	
}
