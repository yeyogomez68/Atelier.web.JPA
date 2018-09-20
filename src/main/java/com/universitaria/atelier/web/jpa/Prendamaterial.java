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
@Table(name = "prendamaterial")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prendamaterial.findAll", query = "SELECT p FROM Prendamaterial p")
    , @NamedQuery(name = "Prendamaterial.findByPrendaMaterial", query = "SELECT p FROM Prendamaterial p WHERE p.prendaMaterial = :prendaMaterial")})
public class Prendamaterial implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PrendaMaterial")
    private Integer prendaMaterial;
    @JoinColumn(name = "MaterialId", referencedColumnName = "MaterialId")
    @ManyToOne
    private Material materialId;
    @JoinColumn(name = "PrendaId", referencedColumnName = "PrendaId")
    @ManyToOne
    private Prenda prendaId;

    public Prendamaterial() {
    }

    public Prendamaterial(Integer prendaMaterial) {
        this.prendaMaterial = prendaMaterial;
    }

    public Integer getPrendaMaterial() {
        return prendaMaterial;
    }

    public void setPrendaMaterial(Integer prendaMaterial) {
        this.prendaMaterial = prendaMaterial;
    }

    public Material getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Material materialId) {
        this.materialId = materialId;
    }

    public Prenda getPrendaId() {
        return prendaId;
    }

    public void setPrendaId(Prenda prendaId) {
        this.prendaId = prendaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prendaMaterial != null ? prendaMaterial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prendamaterial)) {
            return false;
        }
        Prendamaterial other = (Prendamaterial) object;
        if ((this.prendaMaterial == null && other.prendaMaterial != null) || (this.prendaMaterial != null && !this.prendaMaterial.equals(other.prendaMaterial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.universitaria.atelier.web.jpa.Prendamaterial[ prendaMaterial=" + prendaMaterial + " ]";
    }
    
}
