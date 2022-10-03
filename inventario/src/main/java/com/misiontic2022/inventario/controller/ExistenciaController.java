package com.misiontic2022.inventario.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.misiontic2022.inventario.service.DetalleService;
import com.misiontic2022.inventario.service.ExistenciaService;
import com.misiontic2022.inventario.domain.Detalle;
import com.misiontic2022.inventario.domain.Existencia;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

@Controller
public class ExistenciaController {
    @Autowired
    private DetalleService detalleService;

    @Autowired
    private ExistenciaService existenciaService;

    //@RequestMapping("/existencia") // path to renderize. "/":root of my project
    //public String abrirLogin() {
    //    return "existencia"; // this is linked to the name of the html file in
                        // resources/templates/listado.html
                        //,
    //}

    //@PostMapping(value="/existencia")
    @GetMapping("/existencia")
    public String update (
        Model model,
        @ModelAttribute("DETALLE")Detalle detalle
    ) {

        // obtenemos array de todas las entradas ya existente
        List<Detalle> detalles = this.detalleService.findAll();

        List<Existencia> existencias = new ArrayList<Existencia>();

        for (Detalle detallei : detalles) {
                Existencia existencia = new Existencia();
                existencia.setCantidad(detallei.getCantidad());
                existencia.setFechaVen(detallei.getFechaVen());
                existencia.setNombreProd(detallei.getNombre());
                existencia.setLaboratorio(detallei.getLaboratorio());

                existencias.add(existencia);
        }

        for (Existencia existenciai : existencias){
            this.existenciaService.save(existenciai);

        }

        model.addAttribute("EXISTENCIAS", existencias);

        

        // return "redirect:/existencia";
        return "existencia";
    }
    
}
