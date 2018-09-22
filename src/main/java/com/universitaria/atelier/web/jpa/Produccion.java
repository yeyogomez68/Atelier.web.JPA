/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.universitaria.atelier.web.jpa;

import java.io.Serializable;
import java.util.Calendar;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jeisson.gomez
 */
@Entity
@Table(name = "produccion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produccion.findAll", query = "SELECT p FROM Produccion p")
    , @NamedQuery(name = "Produccion.findByProduccionId", query = "SELECT p FROM Produccion p WHERE p.produccionId = :produccionId")
    , @NamedQuery(name = "Produccion.findByProduccionFecha", query = "SELECT p FROM Produccion p WHERE p.produccionFecha = :produccionFecha")
    , @NamedQuery(name = "Produccion.findByProduccionDiaEstimated", query = "SELECT p FROM Produccion p WHERE p.produccionDiaEstimated = :produccionDiaEstimated")
    , @NamedQuery(name = "Produccion.findByProduccionDescripcion", query = "SELECT p FROM Produccion p WHERE p.produccionDescripcion = :produccionDescripcion")})

public class Produccion implements Serializable {

    @Column(name = "ProduccionFecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar produccionFecha;
    @Size(max = 300)
    @Column(name = "produccionDescripcion")
    private String produccionDescripcion;

    @Column(name = "avance")
    private Integer avance;

    @OneToMany(mappedBy = "produccionId")
    private Collection<Produccionusuario> produccionusuarioCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ProduccionId")
    private Integer produccionId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ProduccionDiaEstimated")
    private Float produccionDiaEstimated;

    @JoinColumn(name = "EstadoId", referencedColumnName = "EstadoId")
    @ManyToOne
    private Estado estadoId;

    @JoinColumn(name = "PrendaId", referencedColumnName = "PrendaId")
    @ManyToOne
    private Prenda prendaId;

    @JoinColumn(name = "UsuarioCreador", referencedColumnName = "UsuarioId")
    @ManyToOne
    private Usuario usuarioCreador;
    @OneToMany(mappedBy = "produccionId")
    private Collection<Producciondeta> producciondetaCollection;

    public Produccion() {
    }

    public Produccion(Integer produccionId) {
        this.produccionId = produccionId;
    }

    public Integer getProduccionId() {
        return produccionId;
    }

    public void setProduccionId(Integer produccionId) {
        this.produccionId = produccionId;
    }

    public Float getProduccionDiaEstimated() {
        return produccionDiaEstimated;
    }

    public void setProduccionDiaEstimated(Float produccionDiaEstimated) {
        this.produccionDiaEstimated = produccionDiaEstimated;
    }

    public Estado getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(Estado estadoId) {
        this.estadoId = estadoId;
    }

    public Usuario getUsuarioCreador() {
        return usuarioCreador;
    }

    public void setUsuarioCreador(Usuario usuarioCreador) {
        this.usuarioCreador = usuarioCreador;
    }

    public Integer getAvance() {
        return avance;
    }

    public void setAvance(Integer avance) {
        this.avance = avance;
    }

    @XmlTransient
    public Collection<Producciondeta> getProducciondetaCollection() {
        return producciondetaCollection;
    }

    public void setProducciondetaCollection(Collection<Producciondeta> producciondetaCollection) {
        this.producciondetaCollection = producciondetaCollection;
    }

    public String getProduccionDescripcion() {
        return produccionDescripcion;
    }

    public void setProduccionDescripcion(String produccionDescripcion) {
        this.produccionDescripcion = produccionDescripcion;
    }

    public Prenda getPrendaId() {
        return prendaId;
    }

    public void setPrendaId(Prenda prendaId) {
        this.prendaId = prendaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (produccionId != null ? produccionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produccion)) {
            return false;
        }
        Produccion other = (Produccion) object;
        if ((this.produccionId == null && other.produccionId != null) || (this.produccionId != null && !this.produccionId.equals(other.produccionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.universitaria.atelier.web.jpa.Produccion[ produccionId=" + produccionId + " ]";
    }

    public Calendar getProduccionFecha() {
        return produccionFecha;
    }

    public void setProduccionFecha(Calendar produccionFecha) {
        this.produccionFecha = produccionFecha;
    }

}
