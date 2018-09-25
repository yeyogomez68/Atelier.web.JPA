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
@Table(name = "prendatipo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prendatipo.findAll", query = "SELECT p FROM Prendatipo p")
    , @NamedQuery(name = "Prendatipo.findByPrendaTipoId", query = "SELECT p FROM Prendatipo p WHERE p.prendaTipoId = :prendaTipoId")
    , @NamedQuery(name = "Prendatipo.findByPrendaTipoDescripcion", query = "SELECT p FROM Prendatipo p WHERE upper (p.prendaTipoDescripcion) = upper (:prendaTipoDescripcion)")})
public class Prendatipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PrendaTipoId")
    private Integer prendaTipoId;
    @Column(name = "PrendaTipoDescripcion")
    private String prendaTipoDescripcion;
    @OneToMany(mappedBy = "prendaTipoId")
    private Collection<Prenda> prendaCollection;

    public Prendatipo() {
    }

    public Prendatipo(Integer prendaTipoId) {
        this.prendaTipoId = prendaTipoId;
    }

    public Integer getPrendaTipoId() {
        return prendaTipoId;
    }

    public void setPrendaTipoId(Integer prendaTipoId) {
        this.prendaTipoId = prendaTipoId;
    }

    public String getPrendaTipoDescripcion() {
        return prendaTipoDescripcion;
    }

    public void setPrendaTipoDescripcion(String prendaTipoDescripcion) {
        this.prendaTipoDescripcion = prendaTipoDescripcion;
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
        hash += (prendaTipoId != null ? prendaTipoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prendatipo)) {
            return false;
        }
        Prendatipo other = (Prendatipo) object;
        if ((this.prendaTipoId == null && other.prendaTipoId != null) || (this.prendaTipoId != null && !this.prendaTipoId.equals(other.prendaTipoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.universitaria.atelier.web.jpa.Prendatipo[ prendaTipoId=" + prendaTipoId + " ]";
    }

}
