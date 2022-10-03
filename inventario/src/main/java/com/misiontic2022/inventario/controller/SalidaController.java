package com.misiontic2022.inventario.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
//import java.util.stream.Collectors;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.misiontic2022.inventario.domain.Detalle;
import com.misiontic2022.inventario.domain.Salida;
import com.misiontic2022.inventario.service.DetalleService;
import com.misiontic2022.inventario.service.SalidaService;


@Controller
public class SalidaController {
    
    // You can use @Autowired annotation on properties to get rid of the setter methods
    @Autowired
    private SalidaService salidaService;
    @Autowired
    private DetalleService detalleService;

    @GetMapping("/salida/list")
    public String list (Model model) {

        List<Salida> salidas = this.salidaService.findAll();
        List<Salida> salidasFinal = new ArrayList<>();

        for (Salida salidaAct : salidas) {

            Detalle detalle = this.detalleService.getById(salidaAct.getRefProducto());

            salidaAct.setDetalleCompleto(detalle);
            salidasFinal.add(salidaAct);
        }
    
        model.addAttribute("SALIDAS",salidasFinal);
        
        // vamos a templates/entradas.html
        return "salidas";
    }

    @RequestMapping("/salida/delete")
    public String delete (
        @RequestParam(value="indexId",required=true)
        Long indexId
    ) {
        long idDetalle = this.salidaService.getById(indexId).getRefProducto();
       
        this.salidaService.delete(indexId);
        this.detalleService.delete(idDetalle);

        return "redirect:/salida/list";
    }


    
    @RequestMapping("/salida/edit/{id}")
    public String edit (
        @PathVariable(name="id")
        Long indexId,
        Model model) {
            // obtenemos entrada con el id indexId
            
            Salida salida = this.salidaService.getById(indexId);
            // obtenemos el detalle de la entrada con el id indexId
            Detalle detalle = this.detalleService.getById(salida.getRefProducto());



            model.addAttribute("SALIDAS", salida);
            model.addAttribute("DETALLE", detalle);

            return "editsalida";
    }
    

    @PostMapping(value="/salida/update")
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
    

    // toDo: Que hace el objeto ModelAndView?
    @RequestMapping("/salida/new")
    public ModelAndView newUser() {
        Salida salida = new Salida();
        Detalle detalle = new Detalle();

        
        ModelAndView modelAndView = new ModelAndView("nuevaSalida");
        modelAndView.addObject("SALIDAS",salida);

        modelAndView.addObject("DETALLE",detalle);
        
        
        //detalleService.update(detalle);
        

        // retorna el objeto modelAndView
        return modelAndView;
    }

    
    @PostMapping(value="/salida/save")
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
        // new Date() pone la fecha de hoy
        Date date = new Date();
        salida.setFechaSal(date);

        // toDo: Esto debe ser "false" en salidas!!
        // toDO: Por que esto NO FUNCIONA??
        detalle.setEnt_Sal(false);
        
        
        Detalle newDetalle = this.detalleService.save(detalle);
        
        salida.setRefProducto(newDetalle.getIndexId());
        
        this.salidaService.save(salida);
        
        return "redirect:/salida/list";
    }


    @InitBinder
    public void initBinder(WebDataBinder WebDataBinder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        WebDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
        
    
}