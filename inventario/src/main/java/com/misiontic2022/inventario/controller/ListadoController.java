package com.misiontic2022.inventario.controller;

import org.springframework.stereotype.Controller; // necessary for all controllers!  
import org.springframework.web.bind.annotation.RequestMapping; // automatically generated by Visual Studio

@Controller // necessary for all controllers!
public class ListadoController {
    @RequestMapping("/") // path to renderize. "/":root of my project
    public String abrirLogin() {
        return "disponibilidad"; // this is linked to the name of the html file in
                        // resources/templates/listado.html
    }
}
