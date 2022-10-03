package com.misiontic2022.inventario.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.misiontic2022.inventario.service.DetalleService;
import com.misiontic2022.inventario.service.ExistenciaService;
import com.misiontic2022.inventario.domain.Detalle;
import com.misiontic2022.inventario.domain.Existencia;

import org.springframework.ui.Model;

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
        Model model
    ) {

        // obtenemos array de todas las entradas ya existente
        List<Detalle> detalles = this.detalleService.findAll();

        List<Existencia> existencias = new ArrayList<Existencia>();

        for (Detalle detallei : detalles) {
            Integer indexExistencia = getIndexExistencia(existencias, detallei);
            // si correspondiente existencia a detallei, no existe en existencia, crear su respectiva existencia
            if (indexExistencia == -1){
                existencias.add(detalleToExistencia(detallei));        
            }
            // si la existencia ya existe, actualizar existencia con nueva cantidad
            else{
                Existencia updatedExistencia = getExistenciaByNameLab(existencias, detallei);
                // borrar existencia si la cantidad es 0
                if (updatedExistencia.getCantidad() == 0){
                    System.out.println("AQUI" + indexExistencia.toString());
                    // int es diferente a Integer, el metodo remove necesita int!
                    int b = Integer.parseInt(indexExistencia.toString());
                    existencias.remove(b);
                }
                // actualizar existencia
                else{
                    existencias.set(indexExistencia, updatedExistencia);
                }
                
                
                
            }           
        }

        this.existenciaService.deleteAll();

        // Guardamos todas las existencias para el servicio en la db
        for (Existencia existencia : existencias){
            this.existenciaService.save(existencia);

        }

        model.addAttribute("EXISTENCIAS", existencias);      

        // return "redirect:/existencia";
        return "existencia";
    }

    // Retorna el index de la lista de existencias asociada a cierto detalle,
    // si la existencia no existe, retorna -1
    private Integer getIndexExistencia(List<Existencia> existencias, Detalle detalle){
        Integer index = -1;
        for (int i = 0; i < existencias.size(); i++){
            if ((existencias.get(i).getNombreProd().equals(detalle.getNombre())) &&
             (existencias.get(i).getLaboratorio().equals(detalle.getLaboratorio()))){
                index = i;    
            }  

        }
        return index;    
    
    }

    // Crea nueva existencia de un detalle
    private Existencia detalleToExistencia (Detalle detalle) {
        Existencia existencia = new Existencia();
        existencia.setCantidad(detalle.getCantidad());
        existencia.setFechaVen(detalle.getFechaVen());
        existencia.setNombreProd(detalle.getNombre());
        existencia.setLaboratorio(detalle.getLaboratorio());

        return existencia;
    }

    private Existencia getExistenciaByNameLab(List<Existencia> existencias, Detalle detalle){
        for (Existencia existencia : existencias){
            if ((existencia.getNombreProd().equals(detalle.getNombre())) &&
             (existencia.getLaboratorio().equals(detalle.getLaboratorio()))){
                // si es entrada
                if (detalle.getEnt_Sal()){
                    existencia.setCantidad(existencia.getCantidad() + detalle.getCantidad());
                }
                // si es salida
                else{
                    existencia.setCantidad(existencia.getCantidad() - detalle.getCantidad());
                }
                return existencia;  
            } 
        }
        return null;
    }



}


