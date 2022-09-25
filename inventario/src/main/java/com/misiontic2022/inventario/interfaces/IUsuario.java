package com.misiontic2022.inventario.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.misiontic2022.inventario.modelo.Usuario;

@Repository
public interface IUsuario extends CrudRepository<Usuario, Integer>{
    
}
