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
@Table(name = "producciondeta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producciondeta.findAll", query = "SELECT p FROM Producciondeta p")
    , @NamedQuery(name = "Producciondeta.findByProduccionDetaId", query = "SELECT p FROM Producciondeta p WHERE p.produccionDetaId = :produccionDetaId")
    , @NamedQuery(name = "Producciondeta.findByMaterialId", query = "SELECT p FROM Producciondeta p WHERE p.materialId = :materialId")
    , @NamedQuery(name = "Producciondeta.findByProduccion", query = "SELECT p FROM Producciondeta p WHERE p.produccionId = :produccionId")
    , @NamedQuery(name = "Producciondeta.findByProduccionDetaCant", query = "SELECT p FROM Producciondeta p WHERE p.produccionDetaCant = :produccionDetaCant")
    , @NamedQuery(name = "Producciondeta.findByProduccionDetaFecha", query = "SELECT p FROM Producciondeta p WHERE p.produccionDetaFecha = :produccionDetaFecha")})
public class Producciondeta implements Serializable {

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ProduccionDetaCant")
    private Float produccionDetaCant;

    @JoinColumn(name = "estadoId", referencedColumnName = "EstadoId")
    @ManyToOne
    private Estado estadoId;
    @JoinColumn(name = "MaterialId", referencedColumnName = "MaterialId")
    @ManyToOne
    private Material materialId;
    @JoinColumn(name = "usuarioAsignado", referencedColumnName = "UsuarioId")
    @ManyToOne
    private Usuario usuarioAsignado;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ProduccionDetaId")
    private Integer produccionDetaId;
    @Column(name = "ProduccionDetaFecha")
    @Temporal(TemporalType.DATE)
    private Date produccionDetaFecha;

    @JoinColumn(name = "ProduccionId", referencedColumnName = "ProduccionId")
    @ManyToOne
    private Produccion produccionId;

    public Producciondeta() {
    }

    public Producciondeta(Integer produccionDetaId) {
        this.produccionDetaId = produccionDetaId;
    }

    public Integer getProduccionDetaId() {
        return produccionDetaId;
    }

    public void setProduccionDetaId(Integer produccionDetaId) {
        this.produccionDetaId = produccionDetaId;
    }

    public Material getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Material materialId) {
        this.materialId = materialId;
    }


    public Date getProduccionDetaFecha() {
        return produccionDetaFecha;
    }

    public void setProduccionDetaFecha(Date produccionDetaFecha) {
        this.produccionDetaFecha = produccionDetaFecha;
    }

    public Produccion getProduccionId() {
        return produccionId;
    }

    public void setProduccionId(Produccion produccionId) {
        this.produccionId = produccionId;
    }

    public Usuario getUsuarioAsignado() {
        return usuarioAsignado;
    }

    public void setUsuarioAsignado(Usuario usuarioAsignado) {
        this.usuarioAsignado = usuarioAsignado;
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
        hash += (produccionDetaId != null ? produccionDetaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producciondeta)) {
            return false;
        }
        Producciondeta other = (Producciondeta) object;
        if ((this.produccionDetaId == null && other.produccionDetaId != null) || (this.produccionDetaId != null && !this.produccionDetaId.equals(other.produccionDetaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.universitaria.atelier.web.jpa.Producciondeta[ produccionDetaId=" + produccionDetaId + " ]";
    }

    public Float getProduccionDetaCant() {
        return produccionDetaCant;
    }

    public void setProduccionDetaCant(Float produccionDetaCant) {
        this.produccionDetaCant = produccionDetaCant;
    }
}
