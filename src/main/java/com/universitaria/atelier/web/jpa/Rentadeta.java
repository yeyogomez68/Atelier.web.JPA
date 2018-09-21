/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.universitaria.atelier.web.jpa;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jeisson.gomez
 */
@Entity
@Table(name = "rentadeta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rentadeta.findAll", query = "SELECT r FROM Rentadeta r")
    , @NamedQuery(name = "Rentadeta.findByRentaDetaId", query = "SELECT r FROM Rentadeta r WHERE r.rentaDetaId = :rentaDetaId")
    , @NamedQuery(name = "Rentadeta.findByRentaDetaFecha", query = "SELECT r FROM Rentadeta r WHERE r.rentaDetaFecha = :rentaDetaFecha")
    , @NamedQuery(name = "Rentadeta.findByRentaDetaReinEstadomentFecha", query = "SELECT r FROM Rentadeta r WHERE r.rentaDetaReinEstadomentFecha = :rentaDetaReinEstadomentFecha")
    , @NamedQuery(name = "Rentadeta.findByRentaId", query = "SELECT r FROM Rentadeta r WHERE r.rentaId = :rentaId")
    , @NamedQuery(name = "Rentadeta.findByRentaIdEstadoId", query = "SELECT r FROM Rentadeta r WHERE r.rentaId = :rentaId and estadoId = :estadoId")
    , @NamedQuery(name = "Rentadeta.findByRentaVu", query = "SELECT r FROM Rentadeta r WHERE r.rentaVu = :rentaVu")})
public class Rentadeta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "RentaDetaId")
    private Integer rentaDetaId;
    @Column(name = "RentaDetaFecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar rentaDetaFecha;
    @Column(name = "RentaDetaReinEstadomentFecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar rentaDetaReinEstadomentFecha;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "RentaVu")
    private Float rentaVu;
    @JoinColumn(name = "PrendaId", referencedColumnName = "PrendaId")
    @ManyToOne
    private Prenda prendaId;
    @JoinColumn(name = "RentaId", referencedColumnName = "RentaId")
    @ManyToOne
    private Renta rentaId;
    @JoinColumn(name = "ReservacionId", referencedColumnName = "ReservacionId")
    @ManyToOne
    private Reservacion reservacionId;
    @OneToMany(mappedBy = "rentaDetaId")
    private Collection<Retornoprenda> retornoprendaCollection;
    @JoinColumn(name = "EstadoId", referencedColumnName = "EstadoId")
    @ManyToOne
    private Estado estadoId;

    public Rentadeta() {
    }

    public Rentadeta(Integer rentaDetaId) {
        this.rentaDetaId = rentaDetaId;
    }

    public Integer getRentaDetaId() {
        return rentaDetaId;
    }

    public void setRentaDetaId(Integer rentaDetaId) {
        this.rentaDetaId = rentaDetaId;
    }

    public Calendar getRentaDetaFecha() {
        return rentaDetaFecha;
    }

    public void setRentaDetaFecha(Calendar rentaDetaFecha) {
        this.rentaDetaFecha = rentaDetaFecha;
    }

    public Calendar getRentaDetaReinEstadomentFecha() {
        return rentaDetaReinEstadomentFecha;
    }

    public void setRentaDetaReinEstadomentFecha(Calendar rentaDetaReinEstadomentFecha) {
        this.rentaDetaReinEstadomentFecha = rentaDetaReinEstadomentFecha;
    }

        public Float getRentaVu() {
        return rentaVu;
    }

    public void setRentaVu(Float rentaVu) {
        this.rentaVu = rentaVu;
    }

    public Prenda getPrendaId() {
        return prendaId;
    }

    public void setPrendaId(Prenda prendaId) {
        this.prendaId = prendaId;
    }

    public Renta getRentaId() {
        return rentaId;
    }

    public void setRentaId(Renta rentaId) {
        this.rentaId = rentaId;
    }

    public Reservacion getReservacionId() {
        return reservacionId;
    }

    public void setReservacionId(Reservacion reservacionId) {
        this.reservacionId = reservacionId;
    }

    public Estado getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(Estado estadoId) {
        this.estadoId = estadoId;
    }

    @XmlTransient
    public Collection<Retornoprenda> getRetornoprendaCollection() {
        return retornoprendaCollection;
    }

    public void setRetornoprendaCollection(Collection<Retornoprenda> retornoprendaCollection) {
        this.retornoprendaCollection = retornoprendaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rentaDetaId != null ? rentaDetaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rentadeta)) {
            return false;
        }
        Rentadeta other = (Rentadeta) object;
        if ((this.rentaDetaId == null && other.rentaDetaId != null) || (this.rentaDetaId != null && !this.rentaDetaId.equals(other.rentaDetaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.universitaria.atelier.web.jpa.Rentadeta[ rentaDetaId=" + rentaDetaId + " ]";
    }

}
