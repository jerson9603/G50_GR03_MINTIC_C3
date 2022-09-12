package com.misiontic2022.inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.misiontic2022.inventario.domain.Detalle;

public interface DetallesRepository extends JpaRepository<Detalle, Long> {

    // void update(Detalle entrada);

}