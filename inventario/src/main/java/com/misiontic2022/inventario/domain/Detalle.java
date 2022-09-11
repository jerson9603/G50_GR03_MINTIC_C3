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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author judit
 */
@Entity
@Table(name = "detalles")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Detalle.findAll", query = "SELECT d FROM Detalle d"),
        @NamedQuery(name = "Detalle.findByIndexId", query = "SELECT d FROM Detalle d WHERE d.indexId = :indexId"),
        @NamedQuery(name = "Detalle.findByCantidad", query = "SELECT d FROM Detalle d WHERE d.cantidad = :cantidad"),
        @NamedQuery(name = "Detalle.findByRefProducto", query = "SELECT d FROM Detalle d WHERE d.refProducto = :refProducto"),
        @NamedQuery(name = "Detalle.findByPrecioUni", query = "SELECT d FROM Detalle d WHERE d.precioUni = :precioUni"),
        @NamedQuery(name = "Detalle.findBySubtotal", query = "SELECT d FROM Detalle d WHERE d.subtotal = :subtotal"),
        @NamedQuery(name = "Detalle.findByFechaIngreso", query = "SELECT d FROM Detalle d WHERE d.fechaIngreso = :fechaIngreso"),
        @NamedQuery(name = "Detalle.findByFechaSalida", query = "SELECT d FROM Detalle d WHERE d.fechaSalida = :fechaSalida") })
public class Detalle implements Serializable {

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
    @Basic(optional = false)
    // @NotNull
    // @Size(min = 1, max = 30)
    @Column(name = "ref_producto")
    private String refProducto;
    @Basic(optional = false)
    // @NotNull
    @Column(name = "precio_uni")
    private float precioUni;
    @Basic(optional = false)
    // @NotNull
    @Column(name = "subtotal")
    private float subtotal;
    @Basic(optional = false)
    // @NotNull
    @Column(name = "fecha_ingreso")
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @Basic(optional = false)
    // @NotNull
    @Column(name = "fecha_salida")
    @Temporal(TemporalType.DATE)
    private Date fechaSalida;

    public Detalle() {
    }

    public Detalle(Integer indexId) {
        this.indexId = indexId;
    }

    public Detalle(Integer indexId, int cantidad, String refProducto, float precioUni, float subtotal,
            Date fechaIngreso, Date fechaSalida) {
        this.indexId = indexId;
        this.cantidad = cantidad;
        this.refProducto = refProducto;
        this.precioUni = precioUni;
        this.subtotal = subtotal;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
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

    public String getRefProducto() {
        return refProducto;
    }

    public void setRefProducto(String refProducto) {
        this.refProducto = refProducto;
    }

    public float getPrecioUni() {
        return precioUni;
    }

    public void setPrecioUni(float precioUni) {
        this.precioUni = precioUni;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (indexId != null ? indexId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detalle)) {
            return false;
        }
        Detalle other = (Detalle) object;
        if ((this.indexId == null && other.indexId != null)
                || (this.indexId != null && !this.indexId.equals(other.indexId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clases.Detalle[ indexId=" + indexId + " ]";
    }

}
