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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jeisson.gomez
 */
@Entity
@Table(name = "opcion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Opcion.findAll", query = "SELECT o FROM Opcion o")
    , @NamedQuery(name = "Opcion.findByOpcionId", query = "SELECT o FROM Opcion o WHERE o.opcionId = :opcionId")
    , @NamedQuery(name = "Opcion.findByOpcionPadre", query = "SELECT o FROM Opcion o WHERE o.opcionPadre = :opcionPadre")
    , @NamedQuery(name = "Opcion.findByFormulario", query = "SELECT o FROM Opcion o WHERE o.formulario = :formulario")})
public class Opcion implements Serializable {

    @Size(max = 200)
    @Column(name = "Url")
    private String url;
    @Size(max = 1)
    @Column(name = "Referencia")
    private String referencia;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "OpcionId")
    private Integer opcionId;
    @Column(name = "OpcionPadre")
    private Integer opcionPadre;
    @Basic(optional = false)
    @Column(name = "Formulario")
    private String formulario;
    @OneToMany(mappedBy = "opcionId")
    private Collection<Permiso> permisoCollection;

    public Opcion() {
    }

    public Opcion(Integer opcionId) {
        this.opcionId = opcionId;
    }

    public Opcion(Integer opcionId, String formulario) {
        this.opcionId = opcionId;
        this.formulario = formulario;
    }

    public Integer getOpcionId() {
        return opcionId;
    }

    public void setOpcionId(Integer opcionId) {
        this.opcionId = opcionId;
    }

    public Integer getOpcionPadre() {
        return opcionPadre;
    }

    public void setOpcionPadre(Integer opcionPadre) {
        this.opcionPadre = opcionPadre;
    }

    public String getFormulario() {
        return formulario;
    }

    public void setFormulario(String formulario) {
        this.formulario = formulario;
    }

    @XmlTransient
    public Collection<Permiso> getPermisoCollection() {
        return permisoCollection;
    }

    public void setPermisoCollection(Collection<Permiso> permisoCollection) {
        this.permisoCollection = permisoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (opcionId != null ? opcionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Opcion)) {
            return false;
        }
        Opcion other = (Opcion) object;
        if ((this.opcionId == null && other.opcionId != null) || (this.opcionId != null && !this.opcionId.equals(other.opcionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.universitaria.atelier.web.jpa.Opcion[ opcionId=" + opcionId + " ]";
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }
    
}
