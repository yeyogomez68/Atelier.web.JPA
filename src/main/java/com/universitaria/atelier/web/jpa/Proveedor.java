/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.universitaria.atelier.web.jpa;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jeisson.gomez
 */
@Entity
@Table(name = "proveedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proveedor.findAll", query = "SELECT p FROM Proveedor p")
    , @NamedQuery(name = "Proveedor.findByProveedorId", query = "SELECT p FROM Proveedor p WHERE p.proveedorId = :proveedorId")
    , @NamedQuery(name = "Proveedor.findByNit", query = "SELECT p FROM Proveedor p WHERE p.nit = :nit")
    , @NamedQuery(name = "Proveedor.findByProveedorNombre", query = "SELECT p FROM Proveedor p WHERE upper (p.proveedorNombre) = upper (:proveedorNombre)")
    , @NamedQuery(name = "Proveedor.findByProveedorDireccion", query = "SELECT p FROM Proveedor p WHERE p.proveedorDireccion = :proveedorDireccion")
    , @NamedQuery(name = "Proveedor.findByProveedorPhone", query = "SELECT p FROM Proveedor p WHERE p.proveedorPhone = :proveedorPhone")})
public class Proveedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ProveedorId")
    private Integer proveedorId;
    @Column(name = "NIT")
    private String nit;
    @Column(name = "ProveedorNombre")
    private String proveedorNombre;
    @Column(name = "ProveedorDireccion")
    private String proveedorDireccion;
    @Column(name = "ProveedorPhone")
    private String proveedorPhone;
    @OneToMany(mappedBy = "proveedorId")
    private Collection<Ordencompra> ordencompraCollection;
    @JoinColumn(name = "CiudadId", referencedColumnName = "CiudadId")
    @ManyToOne
    private Ciudad ciudadId;
    @JoinColumn(name = "EstadoId", referencedColumnName = "EstadoId")
    @ManyToOne
    private Estado estadoId;

    public Proveedor() {
    }

    public Proveedor(Integer proveedorId) {
        this.proveedorId = proveedorId;
    }

    public Integer getProveedorId() {
        return proveedorId;
    }

    public void setProveedorId(Integer proveedorId) {
        this.proveedorId = proveedorId;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getProveedorNombre() {
        return proveedorNombre;
    }

    public void setProveedorNombre(String proveedorNombre) {
        this.proveedorNombre = proveedorNombre;
    }

    public String getProveedorDireccion() {
        return proveedorDireccion;
    }

    public void setProveedorDireccion(String proveedorDireccion) {
        this.proveedorDireccion = proveedorDireccion;
    }

    public String getProveedorPhone() {
        return proveedorPhone;
    }

    public void setProveedorPhone(String proveedorPhone) {
        this.proveedorPhone = proveedorPhone;
    }

    @XmlTransient
    public Collection<Ordencompra> getOrdencompraCollection() {
        return ordencompraCollection;
    }

    public void setOrdencompraCollection(Collection<Ordencompra> ordencompraCollection) {
        this.ordencompraCollection = ordencompraCollection;
    }

    public Ciudad getCiudadId() {
        return ciudadId;
    }

    public void setCiudadId(Ciudad ciudadId) {
        this.ciudadId = ciudadId;
    }

    public Estado getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(Estado estadoId) {
        this.estadoId = estadoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proveedorId != null ? proveedorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proveedor)) {
            return false;
        }
        Proveedor other = (Proveedor) object;
        if ((this.proveedorId == null && other.proveedorId != null) || (this.proveedorId != null && !this.proveedorId.equals(other.proveedorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.universitaria.atelier.web.jpa.Proveedor[ proveedorId=" + proveedorId + " ]";
    }

}
