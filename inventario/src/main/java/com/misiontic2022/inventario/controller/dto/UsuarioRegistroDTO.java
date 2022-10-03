package com.misiontic2022.inventario.controller.dto;

public class UsuarioRegistroDTO {
    private int index_id;
	private String nombre;
	private String apellido;
	private String email;
	private String password;

	public int getIndex_id() {
		return index_id;
	}

	public void setId(int index_id) {
		this.index_id = index_id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public UsuarioRegistroDTO(String nombre, String apellido, String email, String password) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
	}

	public UsuarioRegistroDTO() {

	}

}
