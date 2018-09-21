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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jeisson.gomez
 */
@Entity
@Table(name = "cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")
    , @NamedQuery(name = "Cliente.findByClienteId", query = "SELECT c FROM Cliente c WHERE c.clienteId = :clienteId")
    , @NamedQuery(name = "Cliente.findByClienteIdentificacion", query = "SELECT c FROM Cliente c WHERE c.clienteIdentificacion = :clienteIdentificacion")
    , @NamedQuery(name = "Cliente.findByClienteNombre", query = "SELECT c FROM Cliente c WHERE c.clienteNombre = :clienteNombre")
    , @NamedQuery(name = "Cliente.findByClienteApellido", query = "SELECT c FROM Cliente c WHERE c.clienteApellido = :clienteApellido")
    , @NamedQuery(name = "Cliente.findByClienteEmail", query = "SELECT c FROM Cliente c WHERE c.clienteEmail = :clienteEmail")
    , @NamedQuery(name = "Cliente.findByClientePassword", query = "SELECT c FROM Cliente c WHERE c.clientePassword = :clientePassword")
    , @NamedQuery(name = "Cliente.findByClienteDireccion", query = "SELECT c FROM Cliente c WHERE c.clienteDireccion = :clienteDireccion")
    , @NamedQuery(name = "Cliente.findByClienteCel", query = "SELECT c FROM Cliente c WHERE c.clienteCel = :clienteCel")})
public class Cliente implements Serializable {

    @JoinColumn(name = "RollId", referencedColumnName = "RollId")
    @ManyToOne
    private Roll rollId;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ClienteId")
    private Integer clienteId;
    @Column(name = "ClienteIdentificacion")
    private String clienteIdentificacion;
    @Size(max = 60)
    @Column(name = "ClienteNombre")
    private String clienteNombre;
    @Size(max = 60)
    @Column(name = "ClienteApellido")
    private String clienteApellido;
    @Size(max = 60)
    @Column(name = "ClienteEmail")
    private String clienteEmail;
    @Size(max = 60)
    @Column(name = "ClientePassword")
    private String clientePassword;
    @Size(max = 60)
    @Column(name = "ClienteDireccion")
    private String clienteDireccion;
    @Size(max = 60)
    @Column(name = "ClienteCel")
    private String clienteCel;
    @OneToMany(mappedBy = "clienteId")
    private Collection<Facturaencab> facturaencabCollection;
    @OneToMany(mappedBy = "clienteId")
    private Collection<Reservacion> reservacionCollection;
    @JoinColumn(name = "CiudadId", referencedColumnName = "CiudadId")
    @ManyToOne
    private Ciudad ciudadId;
    @JoinColumn(name = "EstadoId", referencedColumnName = "EstadoId")
    @ManyToOne
    private Estado estadoId;

    public Cliente() {
    }

    public Cliente(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public String getClienteIdentificacion() {
        return clienteIdentificacion;
    }

    public void setClienteIdentificacion(String clienteIdentificacion) {
        this.clienteIdentificacion = clienteIdentificacion;
    }

    public String getClienteNombre() {
        return clienteNombre;
    }

    public void setClienteNombre(String clienteNombre) {
        this.clienteNombre = clienteNombre;
    }

    public String getClienteApellido() {
        return clienteApellido;
    }

    public void setClienteApellido(String clienteApellido) {
        this.clienteApellido = clienteApellido;
    }

    public String getClienteEmail() {
        return clienteEmail;
    }

    public void setClienteEmail(String clienteEmail) {
        this.clienteEmail = clienteEmail;
    }

    public String getClientePassword() {
        return clientePassword;
    }

    public void setClientePassword(String clientePassword) {
        this.clientePassword = clientePassword;
    }

    public String getClienteDireccion() {
        return clienteDireccion;
    }

    public void setClienteDireccion(String clienteDireccion) {
        this.clienteDireccion = clienteDireccion;
    }

    public String getClienteCel() {
        return clienteCel;
    }

    public void setClienteCel(String clienteCel) {
        this.clienteCel = clienteCel;
    }

    @XmlTransient
    public Collection<Facturaencab> getFacturaencabCollection() {
        return facturaencabCollection;
    }

    public void setFacturaencabCollection(Collection<Facturaencab> facturaencabCollection) {
        this.facturaencabCollection = facturaencabCollection;
    }

    @XmlTransient
    public Collection<Reservacion> getReservacionCollection() {
        return reservacionCollection;
    }

    public void setReservacionCollection(Collection<Reservacion> reservacionCollection) {
        this.reservacionCollection = reservacionCollection;
    }

    public Ciudad getCiudadId() {
        return ciudadId;
    }

    public void setCiudadId(Ciudad ciudadId) {
        this.ciudadId = ciudadId;
    }

    public Estado getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(Estado estadoId) {
        this.estadoId = estadoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clienteId != null ? clienteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.clienteId == null && other.clienteId != null) || (this.clienteId != null && !this.clienteId.equals(other.clienteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.universitaria.atelier.web.jpa.Cliente[ clienteId=" + clienteId + " ]";
    }

    public Roll getRollId() {
        return rollId;
    }

    public void setRollId(Roll rollId) {
        this.rollId = rollId;
    }

}
