package com.misiontic2022.inventario.service;

import java.util.List;

import com.misiontic2022.inventario.domain.Producto;

public interface ProductoService {

    public List<Producto> findAll();

    public void save(Producto producto);

    public void delete(Producto producto);

    public Producto getById(Long id);
    
    
}
