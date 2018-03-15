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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jeisson.gomez
 */
@Entity
@Table(name = "stockimagen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stockimagen.findAll", query = "SELECT s FROM Stockimagen s")
    , @NamedQuery(name = "Stockimagen.findByStockImagenId", query = "SELECT s FROM Stockimagen s WHERE s.stockImagenId = :stockImagenId")})
public class Stockimagen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "StockImagenId")
    private Integer stockImagenId;
    @Lob
    @Column(name = "StockImagen")
    private byte[] stockImagen;

    public Stockimagen() {
    }

    public Stockimagen(Integer stockImagenId) {
        this.stockImagenId = stockImagenId;
    }

    public Integer getStockImagenId() {
        return stockImagenId;
    }

    public void setStockImagenId(Integer stockImagenId) {
        this.stockImagenId = stockImagenId;
    }

    public byte[] getStockImagen() {
        return stockImagen;
    }

    public void setStockImagen(byte[] stockImagen) {
        this.stockImagen = stockImagen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stockImagenId != null ? stockImagenId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stockimagen)) {
            return false;
        }
        Stockimagen other = (Stockimagen) object;
        if ((this.stockImagenId == null && other.stockImagenId != null) || (this.stockImagenId != null && !this.stockImagenId.equals(other.stockImagenId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.universitaria.atelier.web.jpa.Stockimagen[ stockImagenId=" + stockImagenId + " ]";
    }
    
}
