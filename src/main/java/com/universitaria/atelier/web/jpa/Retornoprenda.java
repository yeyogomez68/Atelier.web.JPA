/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.universitaria.atelier.web.jpa;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jeisson.gomez
 */
@Entity
@Table(name = "retornoprenda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Retornoprenda.findAll", query = "SELECT r FROM Retornoprenda r")
    , @NamedQuery(name = "Retornoprenda.findByRetornoPrendaId", query = "SELECT r FROM Retornoprenda r WHERE r.retornoPrendaId = :retornoPrendaId")
    , @NamedQuery(name = "Retornoprenda.findByRetornoPrendaFecha", query = "SELECT r FROM Retornoprenda r WHERE r.retornoPrendaFecha = :retornoPrendaFecha")
    , @NamedQuery(name = "Retornoprenda.findByRetornoPrendaObserv", query = "SELECT r FROM Retornoprenda r WHERE r.retornoPrendaObserv = :retornoPrendaObserv")
    , @NamedQuery(name = "Retornoprenda.findByRetornoPrendaValor", query = "SELECT r FROM Retornoprenda r WHERE r.retornoPrendaValor = :retornoPrendaValor")})
public class Retornoprenda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "RetornoPrendaId")
    private Integer retornoPrendaId;
    @Basic(optional = false)
    @Column(name = "RetornoPrendaFecha")
    @Temporal(TemporalType.DATE)
    private Date retornoPrendaFecha;
    @Column(name = "RetornoPrendaObserv")
    private String retornoPrendaObserv;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "RetornoPrendaValor")
    private Float retornoPrendaValor;
    @JoinColumn(name = "RentaDetaId", referencedColumnName = "RentaDetaId")
    @ManyToOne
    private Rentadeta rentaDetaId;

    public Retornoprenda() {
    }

    public Retornoprenda(Integer retornoPrendaId) {
        this.retornoPrendaId = retornoPrendaId;
    }

    public Retornoprenda(Integer retornoPrendaId, Date retornoPrendaFecha) {
        this.retornoPrendaId = retornoPrendaId;
        this.retornoPrendaFecha = retornoPrendaFecha;
    }

    public Integer getRetornoPrendaId() {
        return retornoPrendaId;
    }

    public void setRetornoPrendaId(Integer retornoPrendaId) {
        this.retornoPrendaId = retornoPrendaId;
    }

    public Date getRetornoPrendaFecha() {
        return retornoPrendaFecha;
    }

    public void setRetornoPrendaFecha(Date retornoPrendaFecha) {
        this.retornoPrendaFecha = retornoPrendaFecha;
    }

    public String getRetornoPrendaObserv() {
        return retornoPrendaObserv;
    }

    public void setRetornoPrendaObserv(String retornoPrendaObserv) {
        this.retornoPrendaObserv = retornoPrendaObserv;
    }

    public Float getRetornoPrendaValor() {
        return retornoPrendaValor;
    }

    public void setRetornoPrendaValor(Float retornoPrendaValor) {
        this.retornoPrendaValor = retornoPrendaValor;
    }

    public Rentadeta getRentaDetaId() {
        return rentaDetaId;
    }

    public void setRentaDetaId(Rentadeta rentaDetaId) {
        this.rentaDetaId = rentaDetaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (retornoPrendaId != null ? retornoPrendaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Retornoprenda)) {
            return false;
        }
        Retornoprenda other = (Retornoprenda) object;
        if ((this.retornoPrendaId == null && other.retornoPrendaId != null) || (this.retornoPrendaId != null && !this.retornoPrendaId.equals(other.retornoPrendaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.universitaria.atelier.web.jpa.Retornoprenda[ retornoPrendaId=" + retornoPrendaId + " ]";
    }
    
}
