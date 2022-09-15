package com.misiontic2022.inventario.service;

import java.util.List;

import com.misiontic2022.inventario.domain.Detalle;

public interface DetalleService {
    public List<Detalle> findAll();

    public void save(Detalle detalle);

    public void delete(Long id);

    public void delete(Detalle detalle);

    public Detalle getById(Long id);

    public void update(Detalle detalle);

}
