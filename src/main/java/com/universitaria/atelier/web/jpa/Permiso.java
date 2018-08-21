/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.universitaria.atelier.web.jpa;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jeisson.gomez
 */
@Entity
@Table(name = "permiso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Permiso.findAll", query = "SELECT p FROM Permiso p")
    , @NamedQuery(name = "Permiso.findPermByUserMod", query = "SELECT p.opcionId FROM Permiso p WHERE p.opcionId.opcionPadre is null")
    , @NamedQuery(name = "Permiso.findPermByUserItem", query = "SELECT p.opcionId FROM Permiso p WHERE p.opcionId.opcionPadre is not null")
    , @NamedQuery(name = "Permiso.findByPermisoId", query = "SELECT p FROM Permiso p WHERE p.permisoId = :permisoId")})
public class Permiso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PermisoId")
    private Integer permisoId;
    @JoinColumn(name = "OpcionId", referencedColumnName = "OpcionId")
    @ManyToOne
    private Opcion opcionId;
    @JoinColumn(name = "RollId", referencedColumnName = "RollId")
    @ManyToOne
    private Roll rollId;

    public Permiso() {
    }

    public Permiso(Integer permisoId) {
        this.permisoId = permisoId;
    }

    public Integer getPermisoId() {
        return permisoId;
    }

    public void setPermisoId(Integer permisoId) {
        this.permisoId = permisoId;
    }

    public Opcion getOpcionId() {
        return opcionId;
    }

    public void setOpcionId(Opcion opcionId) {
        this.opcionId = opcionId;
    }

    public Roll getRollId() {
        return rollId;
    }

    public void setRollId(Roll rollId) {
        this.rollId = rollId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (permisoId != null ? permisoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Permiso)) {
            return false;
        }
        Permiso other = (Permiso) object;
        if ((this.permisoId == null && other.permisoId != null) || (this.permisoId != null && !this.permisoId.equals(other.permisoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.universitaria.atelier.web.jpa.Permiso[ permisoId=" + permisoId + " ]";
    }
    
}
