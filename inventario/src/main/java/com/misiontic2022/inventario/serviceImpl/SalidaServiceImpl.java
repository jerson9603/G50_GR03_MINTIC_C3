package com.misiontic2022.inventario.serviceImpl;

import com.misiontic2022.inventario.repository.SalidaRepository;
import com.misiontic2022.inventario.service.SalidaService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.misiontic2022.inventario.domain.Salida;

@Service
public class SalidaServiceImpl implements SalidaService{
    
    @Autowired
    private SalidaRepository repository;

    public List<Salida> findAll() {
        return this.repository.findAll();
    }

    public void save(Salida salida) {
        this.repository.save(salida);
    }

    public void delete(Long id) {
        this.repository.deleteById(id);
    }

    public void delete(Salida salida) {
        this.repository.delete(salida);
    }
    
    public Salida getById(Long id) {
        return this.repository.getReferenceById(id);
        //return this.repository.findById(id).get();
    }

    public void update(Salida salida) {
        this.repository.save(salida);
    }
}
