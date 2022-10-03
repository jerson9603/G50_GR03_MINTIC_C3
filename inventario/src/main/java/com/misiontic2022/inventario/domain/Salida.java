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
@Table(name = "salidas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Salida.findAll", query = "SELECT s FROM Salida s"),
    @NamedQuery(name = "Salida.findByIndexId", query = "SELECT s FROM Salida s WHERE s.indexId = :indexId"),
    @NamedQuery(name = "Salida.findByFechaSal", query = "SELECT s FROM Salida s WHERE s.fechaSal = :fechaSal"),
   // @NamedQuery(name = "Salida.findByDetalle", query = "SELECT s FROM Salida s WHERE s.detalle = :detalle"),
    @NamedQuery(name = "Salida.findByProveedor", query = "SELECT s FROM Salida s WHERE s.proveedor = :proveedor"),
   // @NamedQuery(name = "Salida.findByRefProducto", query = "SELECT s FROM Salida s WHERE s.refProducto = :refProducto"),
    //@NamedQuery(name = "Salida.findByCantidad", query = "SELECT s FROM Salida s WHERE s.cantidad = :cantidad"),
    //@NamedQuery(name = "Salida.findByVentDevpro", query = "SELECT s FROM Salida s WHERE s.ventDevpro = :ventDevpro"),
   // @NamedQuery(name = "Salida.findByCliente", query = "SELECT s FROM Salida s WHERE s.cliente = :cliente")
})

   public class Salida implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "index_id")
    private Long indexId;
    @Basic(optional = false)
    // @NotNull
    @Column(name = "fecha_salida")
    @Temporal(TemporalType.DATE)
    private Date fechaSal;
    @Basic(optional = false)
    // @NotNull
    // @Size(min = 1, max = 60)
    @Column(name = "proveedor")
    private String proveedor;
    //@Basic(optional = false)
    // @NotNull
    // @Size(min = 1, max = 60)
    //@Column(name = "detalle")
    //private String detalle;
    @Basic(optional = false)
    // @NotNull
    // @Size(min = 1, max = 60)
    //@Column(name = "cliente")
    //private String cliente;
    //@Basic(optional = true)
    // @NotNull
    //@Column(name = "ped_devcl")
    //private boolean pedDevcl;
    @Column(name = "ref_producto")
    private Long refProducto;

    private Detalle detalleCompleto;

    public Salida() {
    }

    public Salida(Long indexId) {
        this.indexId = indexId;
    }

    public Salida(Long indexId, Date fechaSal, String proveedor/*, String detalle , String cliente,
            boolean pedDevcl*/) {
        this.indexId = indexId;
        this.fechaSal = fechaSal;
        this.proveedor = proveedor;
        //this.detalle = detalle;
        //this.cliente = cliente;
        //this.pedDevcl = pedDevcl;
    }

    public Long getIndexId() {
        return indexId;
    }

    public void setIndexId(Long indexId) {
        this.indexId = indexId;
    }

    public Date getFechaSal() {
        return fechaSal;
    }

    public void setFechaSal(Date fechaSal) {
        this.fechaSal = fechaSal;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    //public String getDetalle() {
    //    return detalle;
    //}

    //public void setDetalle(String detalle) {
    //    this.detalle = detalle;
    //}

    //public String getCliente() {
    //    return cliente;
    //}

    //public void setCliente(String cliente) {
    //    this.cliente = cliente;
    //}

    //public boolean getPedDevcl() {
    //    return pedDevcl;
    //}

    //public void setPedDevcl(boolean pedDevcl) {
    //    this.pedDevcl = pedDevcl;
    //}

    public Detalle getDetalleCompleto() {
        return detalleCompleto;
    }

    public void setDetalleCompleto(Detalle detalle) {
        this.detalleCompleto = detalle;
    }

    public Long getRefProducto() {
        return this.refProducto;
    }
    
    public void setRefProducto(Long refProducto) {
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
        if (!(object instanceof Salida)) {
            return false;
        }
        Salida other = (Salida) object;
        if ((this.indexId == null && other.indexId != null)
                || (this.indexId != null && !this.indexId.equals(other.indexId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clases.Salida[ indexId=" + indexId + " ]";
    }

}
