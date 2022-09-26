package com.misiontic2022.inventario.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
            //Detalle detalle = this.detalleService.getById(salidaAct.getRefProducto());
            List<Detalle> detallesActual = new ArrayList<>();

            detallesActual = detalles.stream()
               .filter(detalle -> detalle.getIndexId() == salidaAct.getRefProducto())
               .collect(Collectors.toList());

            //salidaAct.setDetalle(detalle);
            //salidasFinal.add(salidaAct);

            salidaAct.setDetalle(detallesActual.get(0));
            salidasFinal.add(salidaAct);

        }
       
        model.addAttribute("SALIDAS", salidasFinal);
    
        return "salidas";
    }

    @RequestMapping("/delete")
    public String delete (
        @RequestParam(value="indexId",required=true)
        Long indexId
    ) {
        this.salidaService.delete(indexId);

        return "redirect:/salida/list";
    }

    @RequestMapping("/edit/{id}")
    public String edit (
        @PathVariable(name="id")
        Long indexId,
        Model model) {
            Salida salida = this.salidaService.getById(indexId);
            Detalle detalle = this.detalleService.getById(salida.getRefProducto());

            model.addAttribute("SALIDAS", salida);
            model.addAttribute("DETALLE", detalle);


            return "editsalida";

    }

    @RequestMapping(value="/update", method=RequestMethod.POST)
    public String update (
        @ModelAttribute("SALIDAS")
        Salida salida,
        @ModelAttribute("DETALLE")
        Detalle detalle
    ) {
        detalle.setIndexId(salida.getRefProducto());
        this.salidaService.update(salida);
        this.detalleService.update(detalle);

        return "redirect:/salida/list";
    }

    @RequestMapping("/new")
    public ModelAndView newUser() {
        Salida salida = new Salida();
        Detalle detalle = new Detalle();

        ModelAndView modelAndView = new ModelAndView("nuevaSalida");
        modelAndView.addObject("SALIDAS",salida);
        modelAndView.addObject("DETALLE",detalle);


        return modelAndView;
    }

    @RequestMapping(value="/save", method=RequestMethod.POST)
    public String save(
        @ModelAttribute(name="SALIDAS")
        Salida salida,
        @ModelAttribute(name="DETALLE")
        Detalle detalle,
        BindingResult result 
    ){
        if (result.hasErrors()) {
            return "nuevaSalida";
        }

        Date date = new Date();
        salida.setFechaSal(date);
        
        this.salidaService.save(salida);
        this.detalleService.save(detalle);
        return "redirect:/salida/list";
    }

    @InitBinder
    public void initBinder(WebDataBinder WebDataBinder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        WebDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
       
}

