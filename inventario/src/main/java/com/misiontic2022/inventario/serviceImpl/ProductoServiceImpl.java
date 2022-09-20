package com.misiontic2022.inventario.serviceImpl;

import java.util.List;

import com.misiontic2022.inventario.domain.Producto;
import com.misiontic2022.inventario.repository.ProductoRepository;
import com.misiontic2022.inventario.service.ProductoService;

public class ProductoServiceImpl implements ProductoService  {
    
    private ProductoRepository repositorio;

    public List<Producto> findAll() {
        return this.repositorio.findAll();
    }

    public void save(Producto producto) {
        this.repositorio.save(producto);
    }

    public void delete(Producto producto) {
        this.repositorio.delete(producto);
    }

    public Producto getById(Long id) {
        return this.repositorio.getReferenceById(id);
    }

}
