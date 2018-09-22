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
@Table(name = "ocasion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ocasion.findAll", query = "SELECT o FROM Ocasion o")
    , @NamedQuery(name = "Ocasion.findByOcasionId", query = "SELECT o FROM Ocasion o WHERE o.ocasionId = :ocasionId")
    , @NamedQuery(name = "Ocasion.findByOcasionDescrip", query = "SELECT o FROM Ocasion o WHERE upper (o.ocasionDescrip) = upper (:ocasionDescrip)")})
public class Ocasion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "OcasionId")
    private Integer ocasionId;
    @Basic(optional = false)
    @Column(name = "OcasionDescrip")
    private String ocasionDescrip;
    @OneToMany(mappedBy = "ocasionId")
    private Collection<Prenda> prendaCollection;

    public Ocasion() {
    }

    public Ocasion(Integer ocasionId) {
        this.ocasionId = ocasionId;
    }

    public Ocasion(Integer ocasionId, String ocasionDescrip) {
        this.ocasionId = ocasionId;
        this.ocasionDescrip = ocasionDescrip;
    }

    public Integer getOcasionId() {
        return ocasionId;
    }

    public void setOcasionId(Integer ocasionId) {
        this.ocasionId = ocasionId;
    }

    public String getOcasionDescrip() {
        return ocasionDescrip;
    }

    public void setOcasionDescrip(String ocasionDescrip) {
        this.ocasionDescrip = ocasionDescrip;
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
        hash += (ocasionId != null ? ocasionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ocasion)) {
            return false;
        }
        Ocasion other = (Ocasion) object;
        if ((this.ocasionId == null && other.ocasionId != null) || (this.ocasionId != null && !this.ocasionId.equals(other.ocasionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.universitaria.atelier.web.jpa.Ocasion[ ocasionId=" + ocasionId + " ]";
    }
    
}
