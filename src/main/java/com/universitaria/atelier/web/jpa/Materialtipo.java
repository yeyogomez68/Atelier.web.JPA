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
@Table(name = "materialtipo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Materialtipo.findAll", query = "SELECT m FROM Materialtipo m")
    , @NamedQuery(name = "Materialtipo.findByMaterialTipoId", query = "SELECT m FROM Materialtipo m WHERE m.materialTipoId = :materialTipoId")
    , @NamedQuery(name = "Materialtipo.findByMaterialTipoDescript", query = "SELECT m FROM Materialtipo m WHERE upper (m.materialTipoDescript) = upper (:materialTipoDescript)")})
public class Materialtipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaterialTipoId")
    private Integer materialTipoId;
    @Basic(optional = false)
    @Column(name = "MaterialTipoDescript")
    private String materialTipoDescript;
    @OneToMany(mappedBy = "materialTipoId")
    private Collection<Material> materialCollection;

    public Materialtipo() {
    }

    public Materialtipo(Integer materialTipoId) {
        this.materialTipoId = materialTipoId;
    }

    public Materialtipo(Integer materialTipoId, String materialTipoDescript) {
        this.materialTipoId = materialTipoId;
        this.materialTipoDescript = materialTipoDescript;
    }

    public Integer getMaterialTipoId() {
        return materialTipoId;
    }

    public void setMaterialTipoId(Integer materialTipoId) {
        this.materialTipoId = materialTipoId;
    }

    public String getMaterialTipoDescript() {
        return materialTipoDescript;
    }

    public void setMaterialTipoDescript(String materialTipoDescript) {
        this.materialTipoDescript = materialTipoDescript;
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
        hash += (materialTipoId != null ? materialTipoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Materialtipo)) {
            return false;
        }
        Materialtipo other = (Materialtipo) object;
        if ((this.materialTipoId == null && other.materialTipoId != null) || (this.materialTipoId != null && !this.materialTipoId.equals(other.materialTipoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.universitaria.atelier.web.jpa.Materialtipo[ materialTipoId=" + materialTipoId + " ]";
    }
    
}
