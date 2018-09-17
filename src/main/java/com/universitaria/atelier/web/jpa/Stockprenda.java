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
@Table(name = "stockprenda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stockprenda.findAll", query = "SELECT s FROM Stockprenda s")
    , @NamedQuery(name = "Stockprenda.findByStockPrendaId", query = "SELECT s FROM Stockprenda s WHERE s.stockPrendaId = :stockPrendaId")
    , @NamedQuery(name = "Stockprenda.findByStockPrendaCant", query = "SELECT s FROM Stockprenda s WHERE s.stockPrendaCant = :stockPrendaCant")
    , @NamedQuery(name = "Stockprenda.findByStrockImagenId", query = "SELECT s FROM Stockprenda s WHERE s.strockImagenId = :strockImagenId")})
public class Stockprenda implements Serializable {

    @JoinColumn(name = "StrockImagenId", referencedColumnName = "StockImagenId")
    @ManyToOne
    private Stockimagen strockImagenId;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "StockPrendaId")
    private Integer stockPrendaId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "StockPrendaCant")
    private Float stockPrendaCant;
    
    @JoinColumn(name = "PrendaId", referencedColumnName = "PrendaId")
    @ManyToOne
    private Prenda prendaId;
    @JoinColumn(name = "TallaId", referencedColumnName = "TallaId")
    @ManyToOne
    private Talla tallaId;

    public Stockprenda() {
    }

    public Stockprenda(Integer stockPrendaId) {
        this.stockPrendaId = stockPrendaId;
    }

    public Integer getStockPrendaId() {
        return stockPrendaId;
    }

    public void setStockPrendaId(Integer stockPrendaId) {
        this.stockPrendaId = stockPrendaId;
    }

    public Float getStockPrendaCant() {
        return stockPrendaCant;
    }

    public void setStockPrendaCant(Float stockPrendaCant) {
        this.stockPrendaCant = stockPrendaCant;
    }

    public Prenda getPrendaId() {
        return prendaId;
    }

    public void setPrendaId(Prenda prendaId) {
        this.prendaId = prendaId;
    }

    public Talla getTallaId() {
        return tallaId;
    }

    public void setTallaId(Talla tallaId) {
        this.tallaId = tallaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stockPrendaId != null ? stockPrendaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stockprenda)) {
            return false;
        }
        Stockprenda other = (Stockprenda) object;
        if ((this.stockPrendaId == null && other.stockPrendaId != null) || (this.stockPrendaId != null && !this.stockPrendaId.equals(other.stockPrendaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.universitaria.atelier.web.jpa.Stockprenda[ stockPrendaId=" + stockPrendaId + " ]";
    }

    public Stockimagen getStrockImagenId() {
        return strockImagenId;
    }

    public void setStrockImagenId(Stockimagen strockImagenId) {
        this.strockImagenId = strockImagenId;
    }
    
}
