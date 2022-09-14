package com.misiontic2022.inventario.service;

import java.util.List;

import com.misiontic2022.inventario.domain.Entrada;

public interface EntradaService {
    public List<Entrada> findAll();

    public void save(Entrada entrada);

    public void delete(Long id);

    public void delete(Entrada entrada);

    public Entrada getById(Long id);

    public void update(Entrada entrada);

}
