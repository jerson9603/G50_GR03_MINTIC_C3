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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.misiontic2022.inventario.domain.Detalle;
import com.misiontic2022.inventario.domain.Entrada;
import com.misiontic2022.inventario.service.DetalleService;
import com.misiontic2022.inventario.service.EntradaService;

@Controller
// all the following paths will be in reference to /entrada!, 
// e.g. @GetMapping("/list") in line 42 = @GetMapping("/entrada/list")
@RequestMapping("/entrada")
public class EntradaController {
    
    // You can use @Autowired annotation on properties to get rid of the setter methods
    @Autowired
    private EntradaService entradaService;
    @Autowired
    private DetalleService detalleService;

    // e.g. @GetMapping("/list") in line 40 = @GetMapping("/entrada/list")
    @GetMapping("/list")
    // no retorna una lista, es un String con el nombre del html
    public String list (Model model) {

        // obtenemos array de todas las entradas ya existente
        List<Entrada> entradas = this.entradaService.findAll();
        // creamos nuevo array de entradas vacio
        List<Entrada> entradasFinal = new ArrayList<>();

        // iteramos en las entradas existentes
        for (Entrada entradaAct : entradas) {
            // obtenemos el de detalle de cada entrada a traves de detalleService
            // toDo: QUE ES "this" en este caso?? EntradaController?
            Detalle detalle = this.detalleService.getById(entradaAct.getRefProducto());

            // a la entrada iterada le ponemos el detalle recien obtenido
            entradaAct.setDetalleCompleto(detalle);
            // agrego entradasAct a list EntradasFinal
            entradasFinal.add(entradaAct);
        }
        // agregamos entradasFinal como atributo "ENTRADAS" al  modelo
        // toDo: POR QUE el atributo del modelo "ENTRADAS" en mayuscula????   
        model.addAttribute("ENTRADAS",entradasFinal);
        
        // vamos a templates/entradas.html
        return "entradas";
    }

    @RequestMapping("/delete")
    // atributo es Long indexId
    public String delete (
        @RequestParam(value="indexId",required=true)
        Long indexId
    ) {
        // obtenemos el id de detalle despues de buscarlo en la entrada
        long idDetalle = this.entradaService.getById(indexId).getRefProducto();
        // borramos la entrada con el indexId
        this.entradaService.delete(indexId);
        // borramos el detalle con el idDetalle
        this.detalleService.delete(idDetalle);

        // toDo: POR QUE redirect?
        return "redirect:/entrada/list";// this is linked to the name of the html file in
        // resources/templates/entrada.html/list
    }

    // toDo: Cual es la diferencia entre este edit y el update abajo?
    // toDo: POR QUE a veces el atributo es el modelo y a veces no?
    @RequestMapping("/edit/{id}")
    public String edit (
        @PathVariable(name="id")
        Long indexId,
        Model model) {
            // obtenemos entrada con el id indexId
            
            Entrada entrada = this.entradaService.getById(indexId);
            // obtenemos el detalle de la entrada con el id indexId
            Detalle detalle = this.detalleService.getById(entrada.getRefProducto());



            model.addAttribute("ENTRADA", entrada);
            model.addAttribute("DETALLE", detalle);

            return "edit";
    }
    

    @PostMapping(value="/update")
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
    

    // toDo: Que hace el objeto ModelAndView?
    @RequestMapping("/new")
    public ModelAndView newUser() {
        Entrada entrada = new Entrada();
        Detalle detalle = new Detalle();

        

        // creamos objeto ModelAndView
        ModelAndView modelAndView = new ModelAndView("nuevaEntrada");
        // agregamos entrada y detalle al objeto modelAndView
        modelAndView.addObject("ENTRADA",entrada);

        // toDo: Esto debe ser "false" en salidas!!
        // toDO: Por que esto NO FUNCIONA??
        detalle.setEnt_Sal(true);
        
        modelAndView.addObject("DETALLE",detalle);
        
        
        //detalleService.update(detalle);
        

        // retorna el objeto modelAndView
        return modelAndView;
    }

    // RequestMapping with method RequesMethod.POST equals PostMapping WITHOUT attribute method
    // toDo: Que es el objeto BindingResult
    @PostMapping(value="/save")
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
        // new Date() pone la fecha de hoy
        Date date = new Date();
        entrada.setFechaEntrada(date);
        
        // guardar newDetalle con la info del atributo detalle
        Detalle newDetalle = this.detalleService.save(detalle);
        // poner como refProducto de la entrada al id de newDetalle
        entrada.setRefProducto(newDetalle.getIndexId());
        // guardar la entrada
        this.entradaService.save(entrada);
        
        return "redirect:/entrada/list";
    }

    // toDo: Que hace InitBinder?
    // cambiar formato de fecha, antes tenia tambien hora, ahora solo tendra fecha en formato yyyy-MM-dd
    @InitBinder
    public void initBinder(WebDataBinder WebDataBinder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        WebDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
        
    
}
