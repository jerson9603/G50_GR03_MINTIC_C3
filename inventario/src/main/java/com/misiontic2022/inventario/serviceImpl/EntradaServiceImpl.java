package com.misiontic2022.inventario.serviceImpl;

import java.util.List;

import com.misiontic2022.inventario.domain.Entrada;
import com.misiontic2022.inventario.repository.EntradasRepository;
import com.misiontic2022.inventario.service.EntradaService;

public class EntradaServiceImpl implements EntradaService {
    // public List<Entrada> findAll();
    private EntradasRepository repositorio;

    public List<Entrada> findAll() {
        return this.repositorio.findAll();
    }

    public void save(Entrada entrada) {
        this.repositorio.save(entrada);
    }

    public void delete(Long id) {
        this.repositorio.deleteById(id);
    }

    public void delete(Entrada entrada) {
        this.repositorio.delete(entrada);
    }

    public Entrada getById(Long id) {
        return this.repositorio.getReferenceById(id);
    }

    public void update(Entrada entrada) {
        this.repositorio.save(entrada);
    }
}




