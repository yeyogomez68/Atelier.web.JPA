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
import javax.persistence.Lob;
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
@Table(name = "facturadeta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Facturadeta.findAll", query = "SELECT f FROM Facturadeta f")
    , @NamedQuery(name = "Facturadeta.findByFacturaDetaId", query = "SELECT f FROM Facturadeta f WHERE f.facturaDetaId = :facturaDetaId")
    , @NamedQuery(name = "Facturadeta.findByFacturaDetaValUni", query = "SELECT f FROM Facturadeta f WHERE f.facturaDetaValUni = :facturaDetaValUni")
    , @NamedQuery(name = "Facturadeta.findByFacturaDetaCantidad", query = "SELECT f FROM Facturadeta f WHERE f.facturaDetaCantidad = :facturaDetaCantidad")
    , @NamedQuery(name = "Facturadeta.findByFacturaDetaValTot", query = "SELECT f FROM Facturadeta f WHERE f.facturaDetaValTot = :facturaDetaValTot")})
public class Facturadeta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "FacturaDetaId")
    private Integer facturaDetaId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "FacturaDetaValUni")
    private Float facturaDetaValUni;
    @Column(name = "FacturaDetaCantidad")
    private Integer facturaDetaCantidad;
    @Basic(optional = false)
    @Lob
    @Column(name = "FacturaDetaValIVA")
    private String facturaDetaValIVA;
    @Basic(optional = false)
    @Column(name = "FacturaDetaValTot")
    private float facturaDetaValTot;
    @JoinColumn(name = "FacturaEncabId", referencedColumnName = "FacturaEncabId")
    @ManyToOne
    private Facturaencab facturaEncabId;
    @JoinColumn(name = "PrendaId", referencedColumnName = "PrendaId")
    @ManyToOne
    private Prenda prendaId;

    public Facturadeta() {
    }

    public Facturadeta(Integer facturaDetaId) {
        this.facturaDetaId = facturaDetaId;
    }

    public Facturadeta(Integer facturaDetaId, String facturaDetaValIVA, float facturaDetaValTot) {
        this.facturaDetaId = facturaDetaId;
        this.facturaDetaValIVA = facturaDetaValIVA;
        this.facturaDetaValTot = facturaDetaValTot;
    }

    public Integer getFacturaDetaId() {
        return facturaDetaId;
    }

    public void setFacturaDetaId(Integer facturaDetaId) {
        this.facturaDetaId = facturaDetaId;
    }

    public Float getFacturaDetaValUni() {
        return facturaDetaValUni;
    }

    public void setFacturaDetaValUni(Float facturaDetaValUni) {
        this.facturaDetaValUni = facturaDetaValUni;
    }

    public Integer getFacturaDetaCantidad() {
        return facturaDetaCantidad;
    }

    public void setFacturaDetaCantidad(Integer facturaDetaCantidad) {
        this.facturaDetaCantidad = facturaDetaCantidad;
    }

    public String getFacturaDetaValIVA() {
        return facturaDetaValIVA;
    }

    public void setFacturaDetaValIVA(String facturaDetaValIVA) {
        this.facturaDetaValIVA = facturaDetaValIVA;
    }

    public float getFacturaDetaValTot() {
        return facturaDetaValTot;
    }

    public void setFacturaDetaValTot(float facturaDetaValTot) {
        this.facturaDetaValTot = facturaDetaValTot;
    }

    public Facturaencab getFacturaEncabId() {
        return facturaEncabId;
    }

    public void setFacturaEncabId(Facturaencab facturaEncabId) {
        this.facturaEncabId = facturaEncabId;
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
        hash += (facturaDetaId != null ? facturaDetaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Facturadeta)) {
            return false;
        }
        Facturadeta other = (Facturadeta) object;
        if ((this.facturaDetaId == null && other.facturaDetaId != null) || (this.facturaDetaId != null && !this.facturaDetaId.equals(other.facturaDetaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.universitaria.atelier.web.jpa.Facturadeta[ facturaDetaId=" + facturaDetaId + " ]";
    }
    
}
