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
@Table(name = "roll")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Roll.findAll", query = "SELECT r FROM Roll r")
    , @NamedQuery(name = "Roll.findByRollId", query = "SELECT r FROM Roll r WHERE r.rollId = :rollId")
    , @NamedQuery(name = "Roll.findByRollDesc", query = "SELECT r FROM Roll r WHERE upper (r.rollDesc) = upper (:rollDesc)")})
public class Roll implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "RollId")
    private Integer rollId;
    @Basic(optional = false)
    @Column(name = "RollDesc")
    private String rollDesc;
    @JoinColumn(name = "EstadoId", referencedColumnName = "EstadoId")
    @ManyToOne
    private Estado estadoId;
    @OneToMany(mappedBy = "rollId")
    private Collection<Permiso> permisoCollection;
    @OneToMany(mappedBy = "rollId")
    private Collection<Usuario> usuarioCollection;

    public Roll() {
    }

    public Roll(Integer rollId) {
        this.rollId = rollId;
    }

    public Roll(Integer rollId, String rollDesc) {
        this.rollId = rollId;
        this.rollDesc = rollDesc;
    }

    public Integer getRollId() {
        return rollId;
    }

    public void setRollId(Integer rollId) {
        this.rollId = rollId;
    }

    public String getRollDesc() {
        return rollDesc;
    }

    public void setRollDesc(String rollDesc) {
        this.rollDesc = rollDesc;
    }

    public Estado getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(Estado estadoId) {
        this.estadoId = estadoId;
    }

    @XmlTransient
    public Collection<Permiso> getPermisoCollection() {
        return permisoCollection;
    }

    public void setPermisoCollection(Collection<Permiso> permisoCollection) {
        this.permisoCollection = permisoCollection;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rollId != null ? rollId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Roll)) {
            return false;
        }
        Roll other = (Roll) object;
        if ((this.rollId == null && other.rollId != null) || (this.rollId != null && !this.rollId.equals(other.rollId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.universitaria.atelier.web.jpa.Roll[ rollId=" + rollId + " ]";
    }
    
}
