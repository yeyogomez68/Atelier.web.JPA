/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.universitaria.atelier.web.jpa;

import java.io.Serializable;
import java.util.Calendar;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jeisson.gomez
 */
@Entity
@Table(name = "renta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Renta.findAll", query = "SELECT r FROM Renta r")
    , @NamedQuery(name = "Renta.findByRentaId", query = "SELECT r FROM Renta r WHERE r.rentaId = :rentaId")
    , @NamedQuery(name = "Renta.findByUsuarioRenta", query = "SELECT r FROM Renta r WHERE r.usuarioRenta = :usuarioRenta")
    , @NamedQuery(name = "Renta.findByRentaIdFecha", query = "SELECT r FROM Renta r WHERE r.rentaIdFecha = :rentaIdFecha")
    , @NamedQuery(name = "Renta.findByDiaRenta", query = "SELECT r FROM Renta r WHERE r.diaRenta = :diaRenta")
    , @NamedQuery(name = "Renta.findByRentaReinEstadomentFecha", query = "SELECT r FROM Renta r WHERE r.rentaReinEstadomentFecha = :rentaReinEstadomentFecha")
    , @NamedQuery(name = "Renta.findByRentaTot", query = "SELECT r FROM Renta r WHERE r.rentaTot = :rentaTot")})
public class Renta implements Serializable {

    @JoinColumn(name = "ClienteId", referencedColumnName = "ClienteId")
    @ManyToOne
    private Cliente clienteId;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "RentaId")
    private Integer rentaId;
    @Column(name = "UsuarioRenta")
    private Integer usuarioRenta;
    @Column(name = "RentaIdFecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar rentaIdFecha;
    @Column(name = "DiaRenta")
    private Integer diaRenta;
    @Column(name = "RentaReinEstadomentFecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar rentaReinEstadomentFecha;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "RentaTot")
    private Float rentaTot;
    @OneToMany(mappedBy = "rentaId")
    private Collection<Rentadeta> rentadetaCollection;
    @JoinColumn(name = "UsuarioId", referencedColumnName = "UsuarioId")
    @ManyToOne
    private Usuario usuarioId;
    @JoinColumn(name = "UsuarioCreador", referencedColumnName = "UsuarioId")
    @ManyToOne
    private Usuario usuarioCreador;

    public Renta() {
    }

    public Renta(Integer rentaId) {
        this.rentaId = rentaId;
    }

    public Integer getRentaId() {
        return rentaId;
    }

    public void setRentaId(Integer rentaId) {
        this.rentaId = rentaId;
    }

    public Integer getUsuarioRenta() {
        return usuarioRenta;
    }

    public void setUsuarioRenta(Integer usuarioRenta) {
        this.usuarioRenta = usuarioRenta;
    }

    public Calendar getRentaIdFecha() {
        return rentaIdFecha;
    }

    public void setRentaIdFecha(Calendar rentaIdFecha) {
        this.rentaIdFecha = rentaIdFecha;
    }

    public Integer getDiaRenta() {
        return diaRenta;
    }

    public void setDiaRenta(Integer diaRenta) {
        this.diaRenta = diaRenta;
    }

    public Calendar getRentaReinEstadomentFecha() {
        return rentaReinEstadomentFecha;
    }

    public void setRentaReinEstadomentFecha(Calendar rentaReinEstadomentFecha) {
        this.rentaReinEstadomentFecha = rentaReinEstadomentFecha;
    }

    public Float getRentaTot() {
        return rentaTot;
    }

    public void setRentaTot(Float rentaTot) {
        this.rentaTot = rentaTot;
    }

    @XmlTransient
    public Collection<Rentadeta> getRentadetaCollection() {
        return rentadetaCollection;
    }

    public void setRentadetaCollection(Collection<Rentadeta> rentadetaCollection) {
        this.rentadetaCollection = rentadetaCollection;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Usuario getUsuarioCreador() {
        return usuarioCreador;
    }

    public void setUsuarioCreador(Usuario usuarioCreador) {
        this.usuarioCreador = usuarioCreador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rentaId != null ? rentaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Renta)) {
            return false;
        }
        Renta other = (Renta) object;
        if ((this.rentaId == null && other.rentaId != null) || (this.rentaId != null && !this.rentaId.equals(other.rentaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.universitaria.atelier.web.jpa.Renta[ rentaId=" + rentaId + " ]";
    }

    public Cliente getClienteId() {
        return clienteId;
    }

    public void setClienteId(Cliente clienteId) {
        this.clienteId = clienteId;
    }

}
