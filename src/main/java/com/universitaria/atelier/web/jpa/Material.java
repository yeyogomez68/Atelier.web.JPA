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
@Table(name = "material")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Material.findAll", query = "SELECT m FROM Material m")
    , @NamedQuery(name = "Material.findByMaterialId", query = "SELECT m FROM Material m WHERE m.materialId = :materialId")
    , @NamedQuery(name = "Material.findByMaterialNombre", query = "SELECT m FROM Material m WHERE m.materialNombre = :materialNombre")
    , @NamedQuery(name = "Material.findByMaterialReference", query = "SELECT m FROM Material m WHERE m.materialReference = :materialReference")})
public class Material implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaterialId")
    private Integer materialId;
    @Column(name = "MaterialNombre")
    private String materialNombre;
    @Column(name = "MaterialReference")
    private String materialReference;
    @OneToMany(mappedBy = "materialId")
    private Collection<Ordencompradeta> ordencompradetaCollection;
    @OneToMany(mappedBy = "materialId")
    private Collection<Requestdeta> requestdetaCollection;
    @OneToMany(mappedBy = "materialId")
    private Collection<Producciondeta> producciondetaCollection;
    @JoinColumn(name = "MaterialTipoId", referencedColumnName = "MaterialTipoId")
    @ManyToOne
    private Materialtipo materialTipoId;
    @JoinColumn(name = "MarcaId", referencedColumnName = "MarcaId")
    @ManyToOne
    private Marca marcaId;
    @OneToMany(mappedBy = "materialId")
    private Collection<Prenda> prendaCollection;

    public Material() {
    }

    public Material(Integer materialId) {
        this.materialId = materialId;
    }

    public Integer getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Integer materialId) {
        this.materialId = materialId;
    }

    public String getMaterialNombre() {
        return materialNombre;
    }

    public void setMaterialNombre(String materialNombre) {
        this.materialNombre = materialNombre;
    }

    public String getMaterialReference() {
        return materialReference;
    }

    public void setMaterialReference(String materialReference) {
        this.materialReference = materialReference;
    }

    @XmlTransient
    public Collection<Ordencompradeta> getOrdencompradetaCollection() {
        return ordencompradetaCollection;
    }

    public void setOrdencompradetaCollection(Collection<Ordencompradeta> ordencompradetaCollection) {
        this.ordencompradetaCollection = ordencompradetaCollection;
    }

    @XmlTransient
    public Collection<Requestdeta> getRequestdetaCollection() {
        return requestdetaCollection;
    }

    public void setRequestdetaCollection(Collection<Requestdeta> requestdetaCollection) {
        this.requestdetaCollection = requestdetaCollection;
    }

    public Materialtipo getMaterialTipoId() {
        return materialTipoId;
    }

    public void setMaterialTipoId(Materialtipo materialTipoId) {
        this.materialTipoId = materialTipoId;
    }

    public Marca getMarcaId() {
        return marcaId;
    }

    public void setMarcaId(Marca marcaId) {
        this.marcaId = marcaId;
    }

    @XmlTransient
    public Collection<Prenda> getPrendaCollection() {
        return prendaCollection;
    }

    public void setPrendaCollection(Collection<Prenda> prendaCollection) {
        this.prendaCollection = prendaCollection;
    }

    @XmlTransient
    public Collection<Producciondeta> getProducciondetaCollection() {
        return producciondetaCollection;
    }

    public void setProducciondetaCollection(Collection<Producciondeta> producciondetaCollection) {
        this.producciondetaCollection = producciondetaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (materialId != null ? materialId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Material)) {
            return false;
        }
        Material other = (Material) object;
        if ((this.materialId == null && other.materialId != null) || (this.materialId != null && !this.materialId.equals(other.materialId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.universitaria.atelier.web.jpa.Material[ materialId=" + materialId + " ]";
    }

}
