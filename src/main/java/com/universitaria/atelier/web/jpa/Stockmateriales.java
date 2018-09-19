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
 * @author SoulHunter
 */
@Entity
@Table(name = "stockmateriales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stockmateriales.findAll", query = "SELECT s FROM Stockmateriales s")
    , @NamedQuery(name = "Stockmateriales.findByStockMaterialId", query = "SELECT s FROM Stockmateriales s WHERE s.stockMaterialId = :stockMaterialId")
    , @NamedQuery(name = "Stockmateriales.findByMaterialId", query = "SELECT s FROM Stockmateriales s WHERE s.materialId = :materialId")
    , @NamedQuery(name = "Stockmateriales.findByCantidad", query = "SELECT s FROM Stockmateriales s WHERE s.cantidad = :cantidad")})
public class Stockmateriales implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "StockMaterialId")
    private Integer stockMaterialId;
    @Column(name = "Cantidad")
    private Integer cantidad;
    @JoinColumn(name = "MaterialId", referencedColumnName = "MaterialId")
    @ManyToOne
    private Material materialId;

    public Stockmateriales() {
    }

    public Stockmateriales(Integer stockMaterialId) {
        this.stockMaterialId = stockMaterialId;
    }

    public Integer getStockMaterialId() {
        return stockMaterialId;
    }

    public void setStockMaterialId(Integer stockMaterialId) {
        this.stockMaterialId = stockMaterialId;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Material getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Material materialId) {
        this.materialId = materialId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stockMaterialId != null ? stockMaterialId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stockmateriales)) {
            return false;
        }
        Stockmateriales other = (Stockmateriales) object;
        if ((this.stockMaterialId == null && other.stockMaterialId != null) || (this.stockMaterialId != null && !this.stockMaterialId.equals(other.stockMaterialId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.universitaria.atelier.web.jpa.Stockmateriales[ stockMaterialId=" + stockMaterialId + " ]";
    }

}
