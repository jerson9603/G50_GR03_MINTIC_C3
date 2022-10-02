package com.misiontic2022.inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.misiontic2022.inventario.domain.Entrada;


// los repository persisten contra la base de datos
// MVC en SpringBoot: Vista a Controlador, Controlador a Servicio, Servicio a Repository
// Repository debe tener CRUD y entonces persiste a la base de datos
// Y de forma contraria DB-Repository-Servicio-Controlador-Vista tambien
public interface EntradasRepository extends JpaRepository<Entrada, Long> {


}