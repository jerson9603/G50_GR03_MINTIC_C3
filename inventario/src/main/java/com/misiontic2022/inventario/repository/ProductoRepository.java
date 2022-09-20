package com.misiontic2022.inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.misiontic2022.inventario.domain.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
