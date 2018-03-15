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
@Table(name = "encabezadorequerimiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Encabezadorequerimiento.findAll", query = "SELECT e FROM Encabezadorequerimiento e")
    , @NamedQuery(name = "Encabezadorequerimiento.findByEncabezadoRequerimientoId", query = "SELECT e FROM Encabezadorequerimiento e WHERE e.encabezadoRequerimientoId = :encabezadoRequerimientoId")
    , @NamedQuery(name = "Encabezadorequerimiento.findByEncabezadoRequerimientoDeta", query = "SELECT e FROM Encabezadorequerimiento e WHERE e.encabezadoRequerimientoDeta = :encabezadoRequerimientoDeta")
    , @NamedQuery(name = "Encabezadorequerimiento.findByUsuarioCreador", query = "SELECT e FROM Encabezadorequerimiento e WHERE e.usuarioCreador = :usuarioCreador")})
public class Encabezadorequerimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "EncabezadoRequerimientoId")
    private Integer encabezadoRequerimientoId;
    @Basic(optional = false)
    @Column(name = "EncabezadoRequerimientoDeta")
    private String encabezadoRequerimientoDeta;
    @Column(name = "UsuarioCreador")
    private Integer usuarioCreador;
    @JoinColumn(name = "EstadoId", referencedColumnName = "EstadoId")
    @ManyToOne
    private Estado estadoId;
    @JoinColumn(name = "UsuarioId", referencedColumnName = "UsuarioId")
    @ManyToOne
    private Usuario usuarioId;
    @OneToMany(mappedBy = "encabezadoRequerimientoId")
    private Collection<Requestdeta> requestdetaCollection;

    public Encabezadorequerimiento() {
    }

    public Encabezadorequerimiento(Integer encabezadoRequerimientoId) {
        this.encabezadoRequerimientoId = encabezadoRequerimientoId;
    }

    public Encabezadorequerimiento(Integer encabezadoRequerimientoId, String encabezadoRequerimientoDeta) {
        this.encabezadoRequerimientoId = encabezadoRequerimientoId;
        this.encabezadoRequerimientoDeta = encabezadoRequerimientoDeta;
    }

    public Integer getEncabezadoRequerimientoId() {
        return encabezadoRequerimientoId;
    }

    public void setEncabezadoRequerimientoId(Integer encabezadoRequerimientoId) {
        this.encabezadoRequerimientoId = encabezadoRequerimientoId;
    }

    public String getEncabezadoRequerimientoDeta() {
        return encabezadoRequerimientoDeta;
    }

    public void setEncabezadoRequerimientoDeta(String encabezadoRequerimientoDeta) {
        this.encabezadoRequerimientoDeta = encabezadoRequerimientoDeta;
    }

    public Integer getUsuarioCreador() {
        return usuarioCreador;
    }

    public void setUsuarioCreador(Integer usuarioCreador) {
        this.usuarioCreador = usuarioCreador;
    }

    public Estado getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(Estado estadoId) {
        this.estadoId = estadoId;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    @XmlTransient
    public Collection<Requestdeta> getRequestdetaCollection() {
        return requestdetaCollection;
    }

    public void setRequestdetaCollection(Collection<Requestdeta> requestdetaCollection) {
        this.requestdetaCollection = requestdetaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (encabezadoRequerimientoId != null ? encabezadoRequerimientoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Encabezadorequerimiento)) {
            return false;
        }
        Encabezadorequerimiento other = (Encabezadorequerimiento) object;
        if ((this.encabezadoRequerimientoId == null && other.encabezadoRequerimientoId != null) || (this.encabezadoRequerimientoId != null && !this.encabezadoRequerimientoId.equals(other.encabezadoRequerimientoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.universitaria.atelier.web.jpa.Encabezadorequerimiento[ encabezadoRequerimientoId=" + encabezadoRequerimientoId + " ]";
    }
    
}
