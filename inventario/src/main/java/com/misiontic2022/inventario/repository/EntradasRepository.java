package com.misiontic2022.inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.misiontic2022.inventario.domain.Entrada;

public interface EntradasRepository extends JpaRepository<Entrada, Long> {

    // void update(Entrada entrada);

}