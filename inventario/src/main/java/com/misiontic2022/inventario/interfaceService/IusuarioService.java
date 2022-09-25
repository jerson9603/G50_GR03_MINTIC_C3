package com.misiontic2022.inventario.interfaceService;

import java.util.List;
import java.util.Optional;

import com.misiontic2022.inventario.modelo.Usuario;

public interface IusuarioService {
    public List<Usuario>listar();
    public Optional<Usuario>listarId(int index_id);
    public int save(Usuario u);
    public void delete(int index_id);
}
