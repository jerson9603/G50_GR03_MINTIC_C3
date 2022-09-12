package com.misiontic2022.inventario.service;

import java.util.List;

import com.misiontic2022.inventario.domain.Detalle;

public interface DetalleService {
    public List<Detalle> findAll();

    public void save(Detalle entrada);

    public void delete(Detalle entrada);

    public Detalle getById(Long id);

    // public void update(Detalle cupon);

}
