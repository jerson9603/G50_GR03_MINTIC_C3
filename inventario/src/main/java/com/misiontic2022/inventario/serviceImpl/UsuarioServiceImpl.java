package com.misiontic2022.inventario.serviceImpl;

import java.util.List;

import com.misiontic2022.inventario.domain.Usuario;
import com.misiontic2022.inventario.repository.UsuarioRepository;

public class UsuarioServiceImpl {
    
    private UsuarioRepository repository;

    public List<Usuario> findAll() {
        return this.repository.findAll();
    }

    public void save(Usuario usuario) {
        this.repository.save(usuario);
    }

    public void delete(Long id) {
        this.repository.deleteById(id);
    }

    public void delete(Usuario usuario) {
        this.repository.delete(usuario);
    }
    
    public Usuario getById(Long id) {
        return this.repository.getReferenceById(id);
        //return this.repository.findById(id).get();
    }

    public void update(Usuario usuario) {
        this.repository.save(usuario);
    }
}
