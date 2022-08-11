package com.wilsondevelopment.springwebcrudmysql.dtos;

public class MensajeDTO {
	private String mensaje;
	
	public MensajeDTO(String mensaje) {
		super();
		this.mensaje = mensaje;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
}
