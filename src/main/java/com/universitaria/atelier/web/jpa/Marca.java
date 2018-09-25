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
@Table(name = "marca")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Marca.findAll", query = "SELECT m FROM Marca m")
    , @NamedQuery(name = "Marca.findByMarcaId", query = "SELECT m FROM Marca m WHERE m.marcaId = :marcaId")
    , @NamedQuery(name = "Marca.findByMarcaNombre", query = "SELECT m FROM Marca m WHERE upper (m.marcaNombre) = upper (:marcaNombre)")})
public class Marca implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MarcaId")
    private Integer marcaId;
    @Column(name = "MarcaNombre")
    private String marcaNombre;
    @OneToMany(mappedBy = "marcaId")
    private Collection<Material> materialCollection;

    public Marca() {
    }

    public Marca(Integer marcaId) {
        this.marcaId = marcaId;
    }

    public Integer getMarcaId() {
        return marcaId;
    }

    public void setMarcaId(Integer marcaId) {
        this.marcaId = marcaId;
    }

    public String getMarcaNombre() {
        return marcaNombre;
    }

    public void setMarcaNombre(String marcaNombre) {
        this.marcaNombre = marcaNombre;
    }

    @XmlTransient
    public Collection<Material> getMaterialCollection() {
        return materialCollection;
    }

    public void setMaterialCollection(Collection<Material> materialCollection) {
        this.materialCollection = materialCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (marcaId != null ? marcaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Marca)) {
            return false;
        }
        Marca other = (Marca) object;
        if ((this.marcaId == null && other.marcaId != null) || (this.marcaId != null && !this.marcaId.equals(other.marcaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.universitaria.atelier.web.jpa.Marca[ marcaId=" + marcaId + " ]";
    }

}
