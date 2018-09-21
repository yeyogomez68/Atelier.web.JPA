/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.universitaria.atelier.web.jpa;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jeisson.gomez
 */
@Entity
@Table(name = "requestdeta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Requestdeta.findAll", query = "SELECT r FROM Requestdeta r")
    , @NamedQuery(name = "Requestdeta.findByRequestDetaId", query = "SELECT r FROM Requestdeta r WHERE r.requestDetaId = :requestDetaId")
    , @NamedQuery(name = "Requestdeta.findByRequestDetaFecha", query = "SELECT r FROM Requestdeta r WHERE r.requestDetaFecha = :requestDetaFecha")
    , @NamedQuery(name = "Requestdeta.findByRequestDetaCantidad", query = "SELECT r FROM Requestdeta r WHERE r.requestDetaCantidad = :requestDetaCantidad")
    , @NamedQuery(name = "Requestdeta.findByUsuarioId", query = "SELECT r FROM Requestdeta r WHERE r.usuarioId = :usuarioId")
    , @NamedQuery(name = "Requestdeta.findByIdRq", query = "SELECT r FROm Requestdeta r WHERE r.encabezadoRequerimientoId.encabezadoRequerimientoId = :idRq")})
public class Requestdeta implements Serializable {

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "RequestDetaCantidad")
    private Double requestDetaCantidad;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "RequestDetaId")
    private Integer requestDetaId;
    @Basic(optional = false)
    @Column(name = "RequestDetaFecha")
    @Temporal(TemporalType.DATE)
    private Date requestDetaFecha;

    @Column(name = "UsuarioId")
    private Integer usuarioId;
    @JoinColumn(name = "EncabezadoRequerimientoId", referencedColumnName = "EncabezadoRequerimientoId")
    @ManyToOne
    private Encabezadorequerimiento encabezadoRequerimientoId;
    @JoinColumn(name = "EstadoId", referencedColumnName = "EstadoId")
    @ManyToOne
    private Estado estadoId;
    @JoinColumn(name = "MaterialId", referencedColumnName = "MaterialId")
    @ManyToOne
    private Material materialId;

    public Requestdeta() {
    }

    public Requestdeta(Integer requestDetaId) {
        this.requestDetaId = requestDetaId;
    }

    public Requestdeta(Integer requestDetaId, Date requestDetaFecha, Double requestDetaCantidad) {
        this.requestDetaId = requestDetaId;
        this.requestDetaFecha = requestDetaFecha;
        this.requestDetaCantidad = requestDetaCantidad;
    }

    public Integer getRequestDetaId() {
        return requestDetaId;
    }

    public void setRequestDetaId(Integer requestDetaId) {
        this.requestDetaId = requestDetaId;
    }

    public Date getRequestDetaFecha() {
        return requestDetaFecha;
    }

    public void setRequestDetaFecha(Date requestDetaFecha) {
        this.requestDetaFecha = requestDetaFecha;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Encabezadorequerimiento getEncabezadoRequerimientoId() {
        return encabezadoRequerimientoId;
    }

    public void setEncabezadoRequerimientoId(Encabezadorequerimiento encabezadoRequerimientoId) {
        this.encabezadoRequerimientoId = encabezadoRequerimientoId;
    }

    public Estado getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(Estado estadoId) {
        this.estadoId = estadoId;
    }

    public Material getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Material materialId) {
        this.materialId = materialId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (requestDetaId != null ? requestDetaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Requestdeta)) {
            return false;
        }
        Requestdeta other = (Requestdeta) object;
        if ((this.requestDetaId == null && other.requestDetaId != null) || (this.requestDetaId != null && !this.requestDetaId.equals(other.requestDetaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.universitaria.atelier.web.jpa.Requestdeta[ requestDetaId=" + requestDetaId + " ]";
    }

    public Double getRequestDetaCantidad() {
        return requestDetaCantidad;
    }

    public void setRequestDetaCantidad(Double requestDetaCantidad) {
        this.requestDetaCantidad = requestDetaCantidad;
    }
    
}
