/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.misiontic2022.inventario.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
//import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author judit
 */
@Entity
@Table(name = "existencias")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Existencia.findAll", query = "SELECT e FROM Existencia e"),
        @NamedQuery(name = "Existencia.findByIndexId", query = "SELECT e FROM Existencia e WHERE e.indexId = :indexId"),
        @NamedQuery(name = "Existencia.findByCantidad", query = "SELECT e FROM Existencia e WHERE e.cantidad = :cantidad") })
public class Existencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "index_id")
    private Integer indexId;
    @Basic(optional = false)
    // @NotNull
    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "nombreProd")
    private String nombreProd;
    @Column(name = "laboratorio")
    private String laboratorio;
    @Column(name = "fecha_ven")
    @Temporal(TemporalType.DATE)
    private Date fechaVen;



    public Existencia() {
    }

    public Existencia(Integer indexId) {
        this.indexId = indexId;
    }

    public Existencia(Integer indexId, int cantidad) {
        this.indexId = indexId;
        this.cantidad = cantidad;
    }

    public Integer getIndexId() {
        return indexId;
    }

    public void setIndexId(Integer indexId) {
        this.indexId = indexId;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombreProd() {
        return nombreProd;
    }

    public void setNombre(String nombreProd) {
        this.nombreProd = nombreProd;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public Date getFechaVen() {
        return fechaVen;
    }

    public void setFechaVen(Date fechaVen) {
        this.fechaVen = fechaVen;
    }


    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (indexId != null ? indexId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
      
        if (!(object instanceof Existencia)) {
            return false;
        }
        Existencia other = (Existencia) object;
        if ((this.indexId == null && other.indexId != null)
                || (this.indexId != null && !this.indexId.equals(other.indexId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clases.Existencia[ indexId=" + indexId + " ]";
    }

}
