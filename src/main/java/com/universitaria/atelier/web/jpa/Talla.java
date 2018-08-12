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
@Table(name = "talla")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Talla.findAll", query = "SELECT t FROM Talla t")
    , @NamedQuery(name = "Talla.findByTallaId", query = "SELECT t FROM Talla t WHERE t.tallaId = :tallaId")
    , @NamedQuery(name = "Talla.findByTallaDescrip", query = "SELECT t FROM Talla t WHERE upper( t.tallaDescrip ) = upper( :tallaDescrip )")})
public class Talla implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TallaId")
    private Integer tallaId;
    @Basic(optional = false)
    @Column(name = "TallaDescrip")
    private String tallaDescrip;
    @OneToMany(mappedBy = "tallaId")
    private Collection<Stockprenda> stockprendaCollection;

    public Talla() {
    }

    public Talla(Integer tallaId) {
        this.tallaId = tallaId;
    }

    public Talla(Integer tallaId, String tallaDescrip) {
        this.tallaId = tallaId;
        this.tallaDescrip = tallaDescrip;
    }

    public Integer getTallaId() {
        return tallaId;
    }

    public void setTallaId(Integer tallaId) {
        this.tallaId = tallaId;
    }

    public String getTallaDescrip() {
        return tallaDescrip;
    }

    public void setTallaDescrip(String tallaDescrip) {
        this.tallaDescrip = tallaDescrip;
    }

    @XmlTransient
    public Collection<Stockprenda> getStockprendaCollection() {
        return stockprendaCollection;
    }

    public void setStockprendaCollection(Collection<Stockprenda> stockprendaCollection) {
        this.stockprendaCollection = stockprendaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tallaId != null ? tallaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Talla)) {
            return false;
        }
        Talla other = (Talla) object;
        if ((this.tallaId == null && other.tallaId != null) || (this.tallaId != null && !this.tallaId.equals(other.tallaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.universitaria.atelier.web.jpa.Talla[ tallaId=" + tallaId + " ]";
    }
    
}
