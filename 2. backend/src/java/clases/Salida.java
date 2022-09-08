/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
    @NamedQuery(name = "Salida.findByDetalle", query = "SELECT s FROM Salida s WHERE s.detalle = :detalle"),
    @NamedQuery(name = "Salida.findByProveedor", query = "SELECT s FROM Salida s WHERE s.proveedor = :proveedor"),
    @NamedQuery(name = "Salida.findByRefProducto", query = "SELECT s FROM Salida s WHERE s.refProducto = :refProducto"),
    @NamedQuery(name = "Salida.findByCantidad", query = "SELECT s FROM Salida s WHERE s.cantidad = :cantidad"),
    @NamedQuery(name = "Salida.findByVentDevpro", query = "SELECT s FROM Salida s WHERE s.ventDevpro = :ventDevpro"),
    @NamedQuery(name = "Salida.findByCliente", query = "SELECT s FROM Salida s WHERE s.cliente = :cliente")})
public class Salida implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "index_id")
    private Integer indexId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_sal")
    @Temporal(TemporalType.DATE)
    private Date fechaSal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "detalle")
    private String detalle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "proveedor")
    private String proveedor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ref_producto")
    private int refProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vent_devpro")
    private boolean ventDevpro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "cliente")
    private String cliente;

    public Salida() {
    }

    public Salida(Integer indexId) {
        this.indexId = indexId;
    }

    public Salida(Integer indexId, Date fechaSal, String detalle, String proveedor, int refProducto, int cantidad, boolean ventDevpro, String cliente) {
        this.indexId = indexId;
        this.fechaSal = fechaSal;
        this.detalle = detalle;
        this.proveedor = proveedor;
        this.refProducto = refProducto;
        this.cantidad = cantidad;
        this.ventDevpro = ventDevpro;
        this.cliente = cliente;
    }

    public Integer getIndexId() {
        return indexId;
    }

    public void setIndexId(Integer indexId) {
        this.indexId = indexId;
    }

    public Date getFechaSal() {
        return fechaSal;
    }

    public void setFechaSal(Date fechaSal) {
        this.fechaSal = fechaSal;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public int getRefProducto() {
        return refProducto;
    }

    public void setRefProducto(int refProducto) {
        this.refProducto = refProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public boolean getVentDevpro() {
        return ventDevpro;
    }

    public void setVentDevpro(boolean ventDevpro) {
        this.ventDevpro = ventDevpro;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
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
        if ((this.indexId == null && other.indexId != null) || (this.indexId != null && !this.indexId.equals(other.indexId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clases.Salida[ indexId=" + indexId + " ]";
    }
    
}
