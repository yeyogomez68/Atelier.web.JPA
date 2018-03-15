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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jeisson.gomez
 */
@Entity
@Table(name = "tablaprueba")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tablaprueba.findAll", query = "SELECT t FROM Tablaprueba t")
    , @NamedQuery(name = "Tablaprueba.findByIdtablaprueba", query = "SELECT t FROM Tablaprueba t WHERE t.idtablaprueba = :idtablaprueba")})
public class Tablaprueba implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtablaprueba")
    private Integer idtablaprueba;

    public Tablaprueba() {
    }

    public Tablaprueba(Integer idtablaprueba) {
        this.idtablaprueba = idtablaprueba;
    }

    public Integer getIdtablaprueba() {
        return idtablaprueba;
    }

    public void setIdtablaprueba(Integer idtablaprueba) {
        this.idtablaprueba = idtablaprueba;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtablaprueba != null ? idtablaprueba.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tablaprueba)) {
            return false;
        }
        Tablaprueba other = (Tablaprueba) object;
        if ((this.idtablaprueba == null && other.idtablaprueba != null) || (this.idtablaprueba != null && !this.idtablaprueba.equals(other.idtablaprueba))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.universitaria.atelier.web.jpa.Tablaprueba[ idtablaprueba=" + idtablaprueba + " ]";
    }
    
}
