package com.misiontic2022.inventario.serviceImpl;

import java.util.List;

import com.misiontic2022.inventario.domain.Existencia;
import com.misiontic2022.inventario.repository.ExistenciaRepository;
import com.misiontic2022.inventario.service.ExistenciaService;

public class ExistenciaServiceImpl implements ExistenciaService {
    
    private ExistenciaRepository repositorio;

    public List<Existencia> findAll() {
        return this.repositorio.findAll();
    }

    public Existencia getById(Long id) {
        return this.repositorio.getReferenceById(id);
    }
    
}

