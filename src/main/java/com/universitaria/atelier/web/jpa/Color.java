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
@Table(name = "color")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Color.findAll", query = "SELECT c FROM Color c")
    , @NamedQuery(name = "Color.findByColorId", query = "SELECT c FROM Color c WHERE c.colorId = :colorId")
    , @NamedQuery(name = "Color.findByColorDescrip", query = "SELECT c FROM Color c WHERE  upper( c.colorDescrip) = upper (:colorDescrip)")})
public class Color implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ColorId")
    private Integer colorId;
    @Basic(optional = false)
    @Column(name = "ColorDescrip")
    private String colorDescrip;
    @OneToMany(mappedBy = "colorId")
    private Collection<Prenda> prendaCollection;

    public Color() {
    }

    public Color(Integer colorId) {
        this.colorId = colorId;
    }

    public Color(Integer colorId, String colorDescrip) {
        this.colorId = colorId;
        this.colorDescrip = colorDescrip;
    }

    public Integer getColorId() {
        return colorId;
    }

    public void setColorId(Integer colorId) {
        this.colorId = colorId;
    }

    public String getColorDescrip() {
        return colorDescrip;
    }

    public void setColorDescrip(String colorDescrip) {
        this.colorDescrip = colorDescrip;
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
        hash += (colorId != null ? colorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Color)) {
            return false;
        }
        Color other = (Color) object;
        if ((this.colorId == null && other.colorId != null) || (this.colorId != null && !this.colorId.equals(other.colorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.universitaria.atelier.web.jpa.Color[ colorId=" + colorId + " ]";
    }

}
