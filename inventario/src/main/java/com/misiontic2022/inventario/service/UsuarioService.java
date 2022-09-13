package com.misiontic2022.inventario.service;

import java.util.List;
import com.misiontic2022.inventario.domain.Usuario;

public interface UsuarioService {

    public List<Usuario> findAll();

    public void save(Usuario entrada);

    public void delete(Long id);

    public void delete(Usuario salida);

    public Usuario getById(Long id);

    public void update(Usuario salida);
}
