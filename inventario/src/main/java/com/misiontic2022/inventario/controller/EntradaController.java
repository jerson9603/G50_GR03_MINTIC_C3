package com.misiontic2022.inventario.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
        List<Entrada> entradasFinal = new ArrayList<>();

        for (Entrada entradaAct : entradas) {
            Detalle detalle = this.detalleService.getById(entradaAct.getRefProducto());

            entradaAct.setDetalleCompleto(detalle);
            entradasFinal.add(entradaAct);
        }

        model.addAttribute("ENTRADAS",entradasFinal);

        return "entradas";
    }

    @RequestMapping("/delete")
    public String delete (
        @RequestParam(value="indexId",required=true)
        Long indexId
    ) {
        this.entradaService.delete(indexId);

        return "redirect:/entrada/list";
    }

    @RequestMapping("/edit/{id}")
    public String edit (
        @PathVariable(name="id")
        Long indexId,
        Model model) {
            Entrada entrada = this.entradaService.getById(indexId);
            Detalle detalle = this.detalleService.getById(entrada.getRefProducto());

            model.addAttribute("ENTRADA", entrada);
            model.addAttribute("DETALLE", detalle);

            return "edit";
    }
    
    @RequestMapping(value="/update", method=RequestMethod.POST)
    public String update (
        @ModelAttribute("ENTRADA")
        Entrada entrada,
        @ModelAttribute("DETALLE")
        Detalle detalle
    ) {
        detalle.setIndexId(entrada.getRefProducto());
        this.entradaService.update(entrada);
        this.detalleService.update(detalle);

        return "redirect:/entrada/list";
    }
    
    @RequestMapping("/new")
    public ModelAndView newUser() {
        Entrada entrada = new Entrada();
        Detalle detalle = new Detalle();

        ModelAndView modelAndView = new ModelAndView("nuevaEntrada");
        modelAndView.addObject("ENTRADA",entrada);
        modelAndView.addObject("DETALLE",detalle);


        return modelAndView;
    }

    @RequestMapping(value="/save", method=RequestMethod.POST)
    public String save(
        @ModelAttribute(name="ENTRADA")
        Entrada entrada,
        @ModelAttribute(name="DETALLE")
        Detalle detalle,
        BindingResult result 
    ){
        if (result.hasErrors()) {
            return "nuevaEntrada";
        }

        Date date = new Date();
        entrada.setFechaEntrada(date);
        
        this.entradaService.save(entrada);
        this.detalleService.save(detalle);
        return "redirect:/entrada/list";
    }

    @InitBinder
    public void initBinder(WebDataBinder WebDataBinder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        WebDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
        
    
}
