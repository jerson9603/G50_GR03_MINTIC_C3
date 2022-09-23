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
@Table(name = "entradas")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Entrada.findAll", query = "SELECT e FROM Entrada e"),
        @NamedQuery(name = "Entrada.findByIndexId", query = "SELECT e FROM Entrada e WHERE e.indexId = :indexId"),
        @NamedQuery(name = "Entrada.findByFechaEntrada", query = "SELECT e FROM Entrada e WHERE e.fechaEntrada = :fechaEntrada"),
        @NamedQuery(name = "Entrada.findByProveedor", query = "SELECT e FROM Entrada e WHERE e.proveedor = :proveedor"),
        @NamedQuery(name = "Entrada.findByDetalle", query = "SELECT e FROM Entrada e WHERE e.detalle = :detalle"),
        @NamedQuery(name = "Entrada.findByCliente", query = "SELECT e FROM Entrada e WHERE e.cliente = :cliente"),
        @NamedQuery(name = "Entrada.findByPedDevcl", query = "SELECT e FROM Entrada e WHERE e.pedDevcl = :pedDevcl") })
public class Entrada implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "index_id")
    private Integer indexId;
    @Basic(optional = false)
    // @NotNull
    @Column(name = "fecha_entrada")
    @Temporal(TemporalType.DATE)
    private Date fechaEntrada;
    @Basic(optional = false)
    // @NotNull
    // @Size(min = 1, max = 60)
    @Column(name = "proveedor")
    private String proveedor;
    @Basic(optional = false)
    // @NotNull
    // @Size(min = 1, max = 60)
    @Column(name = "detalle")
    private String detalle;
    @Basic(optional = false)
    // @NotNull
    // @Size(min = 1, max = 60)
    @Column(name = "cliente")
    private String cliente;
    @Basic(optional = true)
    // @NotNull
    @Column(name = "ped_devcl")
    private boolean pedDevcl;
    @Column(name = "ref_producto")
    private Integer refProducto;

    private Detalle detalleCompleto;

    public Entrada() {
    }

    public Entrada(Integer indexId) {
        this.indexId = indexId;
    }

    public Entrada(Integer indexId, Date fechaEntrada, String proveedor, String detalle, String cliente,
            boolean pedDevcl) {
        this.indexId = indexId;
        this.fechaEntrada = fechaEntrada;
        this.proveedor = proveedor;
        this.detalle = detalle;
        this.cliente = cliente;
        this.pedDevcl = pedDevcl;
    }

    public Integer getIndexId() {
        return indexId;
    }

    public void setIndexId(Integer indexId) {
        this.indexId = indexId;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public boolean getPedDevcl() {
        return pedDevcl;
    }

    public void setPedDevcl(boolean pedDevcl) {
        this.pedDevcl = pedDevcl;
    }

    public Detalle getDetalleCompleto() {
        return detalleCompleto;
    }

    public void setDetalleCompleto(Detalle detalle) {
        this.detalleCompleto = detalle;
    }

    public Integer getRefProducto() {
        return this.refProducto;
    }
    
    public void setRefProducto(Integer refProducto) {
        this.refProducto = refProducto;
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
        if (!(object instanceof Entrada)) {
            return false;
        }
        Entrada other = (Entrada) object;
        if ((this.indexId == null && other.indexId != null)
                || (this.indexId != null && !this.indexId.equals(other.indexId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clases.Entrada[ indexId=" + indexId + " ]";
    }

}
