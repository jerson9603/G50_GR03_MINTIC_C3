package com.misiontic2022.inventario.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller

public class ExistenciaController {

    @RequestMapping("/existencia") // path to renderize. "/":root of my project
    public String abrirLogin() {
        return "existencia"; // this is linked to the name of the html file in
                        // resources/templates/listado.html
                        //,
    }
    
}
