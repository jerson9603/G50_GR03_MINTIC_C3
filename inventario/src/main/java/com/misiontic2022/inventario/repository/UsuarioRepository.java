package com.misiontic2022.inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.misiontic2022.inventario.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
}
