/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.universitaria.atelier.web.jpa;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
    , @NamedQuery(name = "Produccion.findByProduccionInicioHora", query = "SELECT p FROM Produccion p WHERE p.produccionInicioHora = :produccionInicioHora")
    , @NamedQuery(name = "Produccion.findByProduccionDiaEstimated", query = "SELECT p FROM Produccion p WHERE p.produccionDiaEstimated = :produccionDiaEstimated")})
public class Produccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ProduccionId")
    private Integer produccionId;
    @Column(name = "ProduccionFecha")
    @Temporal(TemporalType.DATE)
    private Date produccionFecha;
    @Column(name = "ProduccionInicioHora")
    @Temporal(TemporalType.DATE)
    private Date produccionInicioHora;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ProduccionDiaEstimated")
    private Float produccionDiaEstimated;
    @JoinColumn(name = "EstadoId", referencedColumnName = "EstadoId")
    @ManyToOne
    private Estado estadoId;
    @JoinColumn(name = "PrendaId", referencedColumnName = "PrendaId")
    @ManyToOne
    private Prenda prendaId;
    @JoinColumn(name = "UsuarioId", referencedColumnName = "UsuarioId")
    @ManyToOne
    private Usuario usuarioId;
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

    public Date getProduccionFecha() {
        return produccionFecha;
    }

    public void setProduccionFecha(Date produccionFecha) {
        this.produccionFecha = produccionFecha;
    }

    public Date getProduccionInicioHora() {
        return produccionInicioHora;
    }

    public void setProduccionInicioHora(Date produccionInicioHora) {
        this.produccionInicioHora = produccionInicioHora;
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

    public Prenda getPrendaId() {
        return prendaId;
    }

    public void setPrendaId(Prenda prendaId) {
        this.prendaId = prendaId;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Usuario getUsuarioCreador() {
        return usuarioCreador;
    }

    public void setUsuarioCreador(Usuario usuarioCreador) {
        this.usuarioCreador = usuarioCreador;
    }

    @XmlTransient
    public Collection<Producciondeta> getProducciondetaCollection() {
        return producciondetaCollection;
    }

    public void setProducciondetaCollection(Collection<Producciondeta> producciondetaCollection) {
        this.producciondetaCollection = producciondetaCollection;
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
    
}
