/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author judit
 */
@Entity
@Table(name = "productos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p"),
    @NamedQuery(name = "Producto.findByIndexId", query = "SELECT p FROM Producto p WHERE p.indexId = :indexId"),
    @NamedQuery(name = "Producto.findByNombre", query = "SELECT p FROM Producto p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Producto.findByLaboratorio", query = "SELECT p FROM Producto p WHERE p.laboratorio = :laboratorio"),
    @NamedQuery(name = "Producto.findByFechaVen", query = "SELECT p FROM Producto p WHERE p.fechaVen = :fechaVen"),
    @NamedQuery(name = "Producto.findByReqFormula", query = "SELECT p FROM Producto p WHERE p.reqFormula = :reqFormula"),
    @NamedQuery(name = "Producto.findByPrecioUnidad", query = "SELECT p FROM Producto p WHERE p.precioUnidad = :precioUnidad")})
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "index_id")
    private Integer indexId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "laboratorio")
    private String laboratorio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_ven")
    @Temporal(TemporalType.DATE)
    private Date fechaVen;
    @Size(max = 2)
    @Column(name = "req_formula")
    private String reqFormula;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precioUnidad")
    private float precioUnidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "refProducto")
    private Collection<Existencia> existenciaCollection;

    public Producto() {
    }

    public Producto(Integer indexId) {
        this.indexId = indexId;
    }

    public Producto(Integer indexId, String nombre, String laboratorio, Date fechaVen, float precioUnidad) {
        this.indexId = indexId;
        this.nombre = nombre;
        this.laboratorio = laboratorio;
        this.fechaVen = fechaVen;
        this.precioUnidad = precioUnidad;
    }

    public Integer getIndexId() {
        return indexId;
    }

    public void setIndexId(Integer indexId) {
        this.indexId = indexId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public String getReqFormula() {
        return reqFormula;
    }

    public void setReqFormula(String reqFormula) {
        this.reqFormula = reqFormula;
    }

    public float getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(float precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    @XmlTransient
    public Collection<Existencia> getExistenciaCollection() {
        return existenciaCollection;
    }

    public void setExistenciaCollection(Collection<Existencia> existenciaCollection) {
        this.existenciaCollection = existenciaCollection;
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
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.indexId == null && other.indexId != null) || (this.indexId != null && !this.indexId.equals(other.indexId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clases.Producto[ indexId=" + indexId + " ]";
    }
    
}
