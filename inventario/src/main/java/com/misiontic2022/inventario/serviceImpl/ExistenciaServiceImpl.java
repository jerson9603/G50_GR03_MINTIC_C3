package com.misiontic2022.inventario.serviceImpl;

import java.util.List;

import javax.websocket.server.ServerEndpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.misiontic2022.inventario.domain.Existencia;
import com.misiontic2022.inventario.repository.ExistenciaRepository;
import com.misiontic2022.inventario.service.ExistenciaService;

@Service
public class ExistenciaServiceImpl implements ExistenciaService {
    @Autowired
    private ExistenciaRepository repositorio;

    public void save(Existencia existencia) {
        this.repositorio.save(existencia);
    }

    public List<Existencia> findAll() {
        return this.repositorio.findAll();
    }

    public Existencia getById(Long id) {
        return this.repositorio.getReferenceById(id);
    }
    
}

