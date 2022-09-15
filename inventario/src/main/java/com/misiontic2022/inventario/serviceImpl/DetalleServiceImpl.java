package com.misiontic2022.inventario.serviceImpl;

import java.util.List;

import com.misiontic2022.inventario.domain.Detalle;
import com.misiontic2022.inventario.repository.DetallesRepository;
import com.misiontic2022.inventario.service.DetalleService;

public class DetalleServiceImpl implements DetalleService {
    // public List<Entrada> findAll();
    private DetallesRepository repositorio;

    public List<Detalle> findAll() {
        return this.repositorio.findAll();
    }

    public void save(Detalle detalle) {
        this.repositorio.save(detalle);
    }

    public void delete(Long id) {
        this.repositorio.deleteById(id);
    }

    public void delete(Detalle detalle) {
        this.repositorio.delete(detalle);
    }

    public Detalle getById(Long id) {
        return this.repositorio.getReferenceById(id);
    }

    public void update(Detalle detalle) {
        this.repositorio.save(detalle);
    }
}




