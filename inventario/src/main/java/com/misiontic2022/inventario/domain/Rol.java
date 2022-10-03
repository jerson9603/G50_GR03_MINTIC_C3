package com.misiontic2022.inventario.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "rol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int index_id;
    private String nombre;

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

	public Rol(int index_id, String nombre) {
		super();
		this.index_id = index_id;
		this.nombre = nombre;
	}

	public Rol() {
		
	}

	public Rol(String nombre) {
		super();
		this.nombre = nombre;
	}

	
}


