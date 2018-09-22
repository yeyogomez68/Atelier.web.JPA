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
@Table(name = "estado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estado.findAll", query = "SELECT e FROM Estado e")
    , @NamedQuery(name = "Estado.findByEstadoId", query = "SELECT e FROM Estado e WHERE e.estadoId = :estadoId")
    , @NamedQuery(name = "Estado.findByEstadoDescrip", query = "SELECT e FROM Estado e WHERE upper (e.estadoDescrip) = upper (:estadoDescrip)")})
public class Estado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "EstadoId")
    private Integer estadoId;
    @Column(name = "EstadoDescrip")
    private String estadoDescrip;
    @OneToMany(mappedBy = "estadoId")
    private Collection<Roll> rollCollection;
    @OneToMany(mappedBy = "estadoId")
    private Collection<Facturaencab> facturaencabCollection;
    @OneToMany(mappedBy = "estadoId")
    private Collection<Ordencompra> ordencompraCollection;
    @OneToMany(mappedBy = "estadoId")
    private Collection<Encabezadorequerimiento> encabezadorequerimientoCollection;
    @OneToMany(mappedBy = "estadoId")
    private Collection<Produccion> produccionCollection;
    @OneToMany(mappedBy = "estadoId")
    private Collection<Requestdeta> requestdetaCollection;
    @OneToMany(mappedBy = "estadoId")
    private Collection<Reservacion> reservacionCollection;
    @OneToMany(mappedBy = "estadoId")
    private Collection<Proveedor> proveedorCollection;
    @OneToMany(mappedBy = "estadoId")
    private Collection<Usuario> usuarioCollection;
    @OneToMany(mappedBy = "estadoId")
    private Collection<Prenda> prendaCollection;

    public Estado() {
    }

    public Estado(Integer estadoId) {
        this.estadoId = estadoId;
    }

    public Integer getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(Integer estadoId) {
        this.estadoId = estadoId;
    }

    public String getEstadoDescrip() {
        return estadoDescrip;
    }

    public void setEstadoDescrip(String estadoDescrip) {
        this.estadoDescrip = estadoDescrip;
    }

    @XmlTransient
    public Collection<Roll> getRollCollection() {
        return rollCollection;
    }

    public void setRollCollection(Collection<Roll> rollCollection) {
        this.rollCollection = rollCollection;
    }

    @XmlTransient
    public Collection<Facturaencab> getFacturaencabCollection() {
        return facturaencabCollection;
    }

    public void setFacturaencabCollection(Collection<Facturaencab> facturaencabCollection) {
        this.facturaencabCollection = facturaencabCollection;
    }

    @XmlTransient
    public Collection<Ordencompra> getOrdencompraCollection() {
        return ordencompraCollection;
    }

    public void setOrdencompraCollection(Collection<Ordencompra> ordencompraCollection) {
        this.ordencompraCollection = ordencompraCollection;
    }

    @XmlTransient
    public Collection<Encabezadorequerimiento> getEncabezadorequerimientoCollection() {
        return encabezadorequerimientoCollection;
    }

    public void setEncabezadorequerimientoCollection(Collection<Encabezadorequerimiento> encabezadorequerimientoCollection) {
        this.encabezadorequerimientoCollection = encabezadorequerimientoCollection;
    }

    @XmlTransient
    public Collection<Produccion> getProduccionCollection() {
        return produccionCollection;
    }

    public void setProduccionCollection(Collection<Produccion> produccionCollection) {
        this.produccionCollection = produccionCollection;
    }

    @XmlTransient
    public Collection<Requestdeta> getRequestdetaCollection() {
        return requestdetaCollection;
    }

    public void setRequestdetaCollection(Collection<Requestdeta> requestdetaCollection) {
        this.requestdetaCollection = requestdetaCollection;
    }

    @XmlTransient
    public Collection<Reservacion> getReservacionCollection() {
        return reservacionCollection;
    }

    public void setReservacionCollection(Collection<Reservacion> reservacionCollection) {
        this.reservacionCollection = reservacionCollection;
    }

    @XmlTransient
    public Collection<Proveedor> getProveedorCollection() {
        return proveedorCollection;
    }

    public void setProveedorCollection(Collection<Proveedor> proveedorCollection) {
        this.proveedorCollection = proveedorCollection;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @XmlTransient
    public Collection<Prenda> getPrendaCollection() {
        return prendaCollection;
    }

    public void setPrendaCollection(Collection<Prenda> prendaCollection) {
        this.prendaCollection = prendaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estadoId != null ? estadoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estado)) {
            return false;
        }
        Estado other = (Estado) object;
        if ((this.estadoId == null && other.estadoId != null) || (this.estadoId != null && !this.estadoId.equals(other.estadoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.universitaria.atelier.web.jpa.Estado[ estadoId=" + estadoId + " ]";
    }
    
}
