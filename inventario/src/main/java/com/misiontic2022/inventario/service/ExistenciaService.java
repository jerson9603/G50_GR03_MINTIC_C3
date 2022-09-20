package com.misiontic2022.inventario.service;

import java.util.List;

import com.misiontic2022.inventario.domain.Existencia;

public interface ExistenciaService {

    public List<Existencia> findAll();

    public Existencia getById(Long id);
    
}
