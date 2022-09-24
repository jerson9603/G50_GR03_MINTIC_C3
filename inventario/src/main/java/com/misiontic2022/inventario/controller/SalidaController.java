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
import com.misiontic2022.inventario.domain.Salida;
import com.misiontic2022.inventario.service.DetalleService;
import com.misiontic2022.inventario.service.SalidaService;


@Controller
@RequestMapping("/salida")
public class SalidaController {

    @Autowired
    private SalidaService salidaService;
    @Autowired
    private DetalleService detalleService;

    @GetMapping("/list")
    public String list (Model model) {
        List<Salida> salida = this.salidaService.findAll();
        List<Detalle> detalles = this.detalleService.findAll();
        List<Salida> salidasFinal = new ArrayList<>();

        for (Salida salidaAct : salida) {
            List<Detalle> detallesActual = new ArrayList<>();

            detallesActual = detalles.stream()
                .filter(detalle -> detalle.getIndexId() == salidaAct.getRefProducto())
                .collect(Collectors.toList());

            salidaAct.setDetalle(detallesActual.get(0));
            salidasFinal.add(salidaAct);

        }
       
        model.addAttribute("SALIDAS", salidasFinal);
    
        return "salidas";
    }
}
