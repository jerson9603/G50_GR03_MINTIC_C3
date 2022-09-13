package com.misiontic2022.inventario.service;

import java.util.List;
import com.misiontic2022.inventario.domain.Salida;

public interface SalidaService {

    public List<Salida> findAll();

    public void save(Salida entrada);

    public void delete(Long id);

    public void delete(Salida salida);

    public Salida getById(Long id);

    public void update(Salida salida);
}
