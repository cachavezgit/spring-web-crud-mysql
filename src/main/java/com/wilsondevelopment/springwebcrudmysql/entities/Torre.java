package com.wilsondevelopment.springwebcrudmysql.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="torres")
public class Torre {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTorre;
	private String nombreTorre;
	private int cantidadAptos;
	
	public int getIdTorre() {
		return idTorre;
	}
	public void setIdTorre(int idTorre) {
		this.idTorre = idTorre;
	}
	
	public String getNombreTorre() {
		return nombreTorre;
	}
	public void setNombreTorre(String nombreTorre) {
		this.nombreTorre = nombreTorre;
	}
	
	public int getCantidadAptos() {
		return cantidadAptos;
	}
	public void setCantidadAptos(int cantidadAptos) {
		this.cantidadAptos = cantidadAptos;
	}
	
	public Torre() {
		
	}
	
	public Torre(String nombreTorre, int cantidadAptos) {
		super();
		this.nombreTorre = nombreTorre;
		this.cantidadAptos = cantidadAptos;
	}
	
	
	
	
}
