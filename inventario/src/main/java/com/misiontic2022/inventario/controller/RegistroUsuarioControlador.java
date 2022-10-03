package com.misiontic2022.inventario.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.misiontic2022.inventario.controller.dto.UsuarioRegistroDTO;
import com.misiontic2022.inventario.service.UsuarioService;

@Controller
@RequestMapping("/registro")
public class RegistroUsuarioControlador {

    private UsuarioService usuarioservice;

    public RegistroUsuarioControlador(UsuarioService usuarioservice){
       super();
       this.usuarioservice = usuarioservice; 
    }
    
    @ModelAttribute("usuario")
    public UsuarioRegistroDTO retornarNuevoUsuarioRegistroDTO(){
        return new UsuarioRegistroDTO();
    }

    @GetMapping
    public String mostrarFormularioDeRegistro(){
        return "registro";
    }

    @PostMapping
    public String registrarCuentaDeUsuario(@ModelAttribute("usuario") UsuarioRegistroDTO registroDTO){
        usuarioservice.guardar(registroDTO);
        return "redirect:/registro?exito";
    }
}