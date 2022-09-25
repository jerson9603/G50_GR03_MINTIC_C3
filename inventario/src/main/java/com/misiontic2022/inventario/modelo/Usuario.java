
package com.misiontic2022.inventario.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
    public class Usuario{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY) /*hacemos referencia a que va aser el id de la tabla usuario */
        private int index_id;
        private String nombre;
        private String nombre_usuario;
        private String clave;
    
    
        public Usuario() {
        }
    
        public Usuario(int index_id,String nombre,String nombre_usuario,String clave) {
            super();
            this.index_id = index_id;
            this.nombre = nombre;
            this.nombre_usuario = nombre_usuario;
            this.clave = clave;
        }
    
        public Usuario(int index_id) {
            this.index_id = index_id; 
        }
    
        public Integer getIndex_id() {
            return index_id;
        }
    
        public void setIndex_id(int index_id) {
            this.index_id = index_id;
        }
    
        public String getNombre() {
            return nombre;
        }
    
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
    
        public String getNombre_usuario() {
            return nombre_usuario;
        }
    
        public void setNombre_usuario(String nombre_usuario) {
            this.nombre_usuario = nombre_usuario;
        }
    
        public String getClave() {
            return clave;
        }
    
        public void setClave(String clave) {
            this.clave = clave;
        }
}

   

