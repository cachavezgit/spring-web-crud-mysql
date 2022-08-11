package com.wilsondevelopment.springwebcrudmysql.dtos;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class TorreDTO {
	@NotBlank
	private String nombreTorre;
	
	@Min(1)
	private int cantidadAptos;
	
	public TorreDTO() {
		
	}
	
	public TorreDTO(String nombreTorre, int cantidadAptos) {
		super();
		this.nombreTorre = nombreTorre;
		this.cantidadAptos = cantidadAptos;
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
	
	

}
