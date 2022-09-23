package com.misiontic2022.inventario.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.misiontic2022.inventario.domain.Detalle;
import com.misiontic2022.inventario.domain.Entrada;
import com.misiontic2022.inventario.service.DetalleService;
import com.misiontic2022.inventario.service.EntradaService;

@Controller
@RequestMapping("/entrada")
public class EntradaController {
    
    @Autowired
    private EntradaService entradaService;
    @Autowired
    private DetalleService detalleService;

    @GetMapping("/list")
    public String list (Model model) {

        List<Entrada> entradas = this.entradaService.findAll();
        List<Detalle> detalles = this.detalleService.findAll();
        List<Entrada> entradasFinal = new ArrayList<>();

        for (Entrada entradaAct : entradas) {
            List<Detalle> detallesActual = new ArrayList<>();
            
            detallesActual = detalles.stream()
                .filter(detalle -> detalle.getIndexId() == entradaAct.getRefProducto())
                .collect(Collectors.toList());

            entradaAct.setDetalleCompleto(detallesActual.get(0));
            entradasFinal.add(entradaAct);
        }

        model.addAttribute("ENTRADAS",entradasFinal);

        return "entradas";
    }
    
}
