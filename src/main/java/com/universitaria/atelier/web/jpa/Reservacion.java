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
@Table(name = "reservacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reservacion.findAll", query = "SELECT r FROM Reservacion r")
    , @NamedQuery(name = "Reservacion.findByReservacionId", query = "SELECT r FROM Reservacion r WHERE r.reservacionId = :reservacionId")
    , @NamedQuery(name = "Reservacion.findByReservacionFecha", query = "SELECT r FROM Reservacion r WHERE r.reservacionFecha = :reservacionFecha")
    , @NamedQuery(name = "Reservacion.findByReservacionLimit", query = "SELECT r FROM Reservacion r WHERE r.reservacionLimit = :reservacionLimit")
    , @NamedQuery(name = "Reservacion.findByEstadoId", query = "SELECT r FROM Reservacion r WHERE r.estadoId = :estadoId")
    , @NamedQuery(name = "Reservacion.findByReservacionLimitFecha", query = "SELECT r FROM Reservacion r WHERE r.reservacionLimitFecha = :reservacionLimitFecha")})
public class Reservacion implements Serializable {

    @JoinColumn(name = "ClienteId", referencedColumnName = "ClienteId")
    @ManyToOne
    private Cliente clienteId;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ReservacionId")
    private Integer reservacionId;
    @Column(name = "ReservacionFecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar reservacionFecha;
    @Column(name = "ReservacionLimit")
    private Integer reservacionLimit;
    @Column(name = "ReservacionLimitFecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar reservacionLimitFecha;
    @OneToMany(mappedBy = "reservacionId")
    private Collection<Rentadeta> rentadetaCollection;
    @JoinColumn(name = "UsuarioReservacionId", referencedColumnName = "UsuarioId")
    @ManyToOne
    private Usuario usuarioReservacionId;
    @JoinColumn(name = "EstadoId", referencedColumnName = "EstadoId")
    @ManyToOne
    private Estado estadoId;
    @JoinColumn(name = "PrendaId", referencedColumnName = "PrendaId")
    @ManyToOne
    private Prenda prendaId;
    @JoinColumn(name = "UsuarioId", referencedColumnName = "UsuarioId")
    @ManyToOne
    private Usuario usuarioId;

    public Reservacion() {
    }

    public Reservacion(Integer reservacionId) {
        this.reservacionId = reservacionId;
    }

    public Integer getReservacionId() {
        return reservacionId;
    }

    public void setReservacionId(Integer reservacionId) {
        this.reservacionId = reservacionId;
    }

    public Calendar getReservacionFecha() {
        return reservacionFecha;
    }

    public void setReservacionFecha(Calendar reservacionFecha) {
        this.reservacionFecha = reservacionFecha;
    }

    public Integer getReservacionLimit() {
        return reservacionLimit;
    }

    public void setReservacionLimit(Integer reservacionLimit) {
        this.reservacionLimit = reservacionLimit;
    }

    public Calendar getReservacionLimitFecha() {
        return reservacionLimitFecha;
    }

    public void setReservacionLimitFecha(Calendar reservacionLimitFecha) {
        this.reservacionLimitFecha = reservacionLimitFecha;
    }

    @XmlTransient
    public Collection<Rentadeta> getRentadetaCollection() {
        return rentadetaCollection;
    }

    public void setRentadetaCollection(Collection<Rentadeta> rentadetaCollection) {
        this.rentadetaCollection = rentadetaCollection;
    }

    public Usuario getUsuarioReservacionId() {
        return usuarioReservacionId;
    }

    public void setUsuarioReservacionId(Usuario usuarioReservacionId) {
        this.usuarioReservacionId = usuarioReservacionId;
    }

    public Estado getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(Estado estadoId) {
        this.estadoId = estadoId;
    }

    public Prenda getPrendaId() {
        return prendaId;
    }

    public void setPrendaId(Prenda prendaId) {
        this.prendaId = prendaId;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reservacionId != null ? reservacionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservacion)) {
            return false;
        }
        Reservacion other = (Reservacion) object;
        if ((this.reservacionId == null && other.reservacionId != null) || (this.reservacionId != null && !this.reservacionId.equals(other.reservacionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.universitaria.atelier.web.jpa.Reservacion[ reservacionId=" + reservacionId + " ]";
    }

    public Cliente getClienteId() {
        return clienteId;
    }

    public void setClienteId(Cliente clienteId) {
        this.clienteId = clienteId;
    }

}
