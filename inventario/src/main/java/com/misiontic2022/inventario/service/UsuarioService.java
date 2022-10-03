package com.misiontic2022.inventario.service;

import java.util.List;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.misiontic2022.inventario.controller.dto.UsuarioRegistroDTO;
import com.misiontic2022.inventario.domain.Usuario;
import com.misiontic2022.inventario.seguridad.SecurityConfiguration;

public interface UsuarioService extends UserDetailsService {

    public Usuario guardar(UsuarioRegistroDTO registroDTO);
    public List<Usuario> listarUsuarios();
    default void configure(SecurityConfiguration securityConfiguration, AuthenticationManagerBuilder auth) throws Exception {
    	auth.authenticationProvider(securityConfiguration.authenticationProvider());
    }

}
