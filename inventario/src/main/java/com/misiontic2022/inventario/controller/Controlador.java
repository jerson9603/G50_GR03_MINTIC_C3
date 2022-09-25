package com.misiontic2022.inventario.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.misiontic2022.inventario.interfaceService.IusuarioService;
import com.misiontic2022.inventario.modelo.Usuario;



@Controller
@RequestMapping
public class Controlador {

    @Autowired
    private IusuarioService service;

    @GetMapping("/listar")
    public String listar(Model model){
        List<Usuario>usuarios=service.listar();
        model.addAttribute("usuarios", usuarios);
        return "index";
    }

    @GetMapping("/new")
    public String agregar(Model model){
        model.addAttribute("usuario", new Usuario());
        return "form";
    }

    @PostMapping("/save")
    public String save(@Valid Usuario u, Model model){
        service.save(u);
        return "redirect:/listar";
    }

    @GetMapping("/editar/{index_id}") //reconoce
    public String editar(@PathVariable int index_id, Model model){
        Optional<Usuario>usuario=service.listarId(index_id);
        model.addAttribute("usuario", usuario);
        return "form";
    }

    @GetMapping("/eliminar/{index_id}")
    public String delete(Model model, @PathVariable int index_id){
        service.delete(index_id);
        return "redirect:/listar";
    }

    @GetMapping({"/","/login"})
    public String index(){
        return "index";
    }

    @GetMapping({"/menu"})
    public String menu(){
        return "menu";
    }

}
