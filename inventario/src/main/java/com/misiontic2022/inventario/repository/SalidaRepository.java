package com.misiontic2022.inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.misiontic2022.inventario.domain.Salida;

public interface SalidaRepository extends JpaRepository<Salida, Long> {
    
}
