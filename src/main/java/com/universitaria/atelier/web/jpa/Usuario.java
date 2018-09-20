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
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByLogin", query = "SELECT u FROM Usuario u WHERE u.usuarioEmail = :usuarioEmail and u.usuarioPassword = :usuarioPassword ")
    , @NamedQuery(name = "Usuario.findByUsuarioId", query = "SELECT u FROM Usuario u WHERE u.usuarioId = :usuarioId")
    , @NamedQuery(name = "Usuario.findByUsuarioIdentificacion", query = "SELECT u FROM Usuario u WHERE u.usuarioIdentificacion = :usuarioIdentificacion")
    , @NamedQuery(name = "Usuario.findByUsuarioNombre", query = "SELECT u FROM Usuario u WHERE u.usuarioNombre = :usuarioNombre")
    , @NamedQuery(name = "Usuario.findByUsuarioApellido", query = "SELECT u FROM Usuario u WHERE u.usuarioApellido = :usuarioApellido")
    , @NamedQuery(name = "Usuario.findByUsuarioEmail", query = "SELECT u FROM Usuario u WHERE u.usuarioEmail = :usuarioEmail")
    , @NamedQuery(name = "Usuario.findByUsuarioPassword", query = "SELECT u FROM Usuario u WHERE u.usuarioPassword = :usuarioPassword")
    , @NamedQuery(name = "Usuario.findByUsuarioDireccion", query = "SELECT u FROM Usuario u WHERE u.usuarioDireccion = :usuarioDireccion")
    , @NamedQuery(name = "Usuario.findByRoll", query = "SELECT u FROM Usuario u WHERE u.rollId = :rollId")
    , @NamedQuery(name = "Usuario.findByUsuarioCel", query = "SELECT u FROM Usuario u WHERE u.usuarioCel = :usuarioCel")})
public class Usuario implements Serializable {

    @OneToMany(mappedBy = "usuarioAsignado")
    private Collection<Producciondeta> producciondetaCollection;
    @JoinColumn(name = "contratoId", referencedColumnName = "ContratoId")
    @ManyToOne
    private Contrato contratoId;

    @OneToMany(mappedBy = "usuarioId")
    private Collection<Produccionusuario> produccionusuarioCollection;
   

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "UsuarioId")
    private Integer usuarioId;
    @Column(name = "UsuarioIdentificacion")
    private Integer usuarioIdentificacion;
    @Column(name = "UsuarioNombre")
    private String usuarioNombre;
    @Column(name = "UsuarioApellido")
    private String usuarioApellido;
    @Column(name = "UsuarioEmail")
    private String usuarioEmail;
    @Column(name = "UsuarioPassword")
    private String usuarioPassword;
    @Column(name = "UsuarioDireccion")
    private String usuarioDireccion;
    @Column(name = "UsuarioCel")
    private String usuarioCel;
    @OneToMany(mappedBy = "usuarioId")
    private Collection<Facturaencab> facturaencabCollection;
    @OneToMany(mappedBy = "usuarioId")
    private Collection<Ordencompra> ordencompraCollection;
    @OneToMany(mappedBy = "usuarioAprueba")
    private Collection<Ordencompra> ordencompraCollection2;
    @OneToMany(mappedBy = "usuarioId")
    private Collection<Encabezadorequerimiento> encabezadorequerimientoCollection;
    @OneToMany(mappedBy = "usuarioCreador")
    private Collection<Produccion> produccionCollection1;
    @OneToMany(mappedBy = "usuarioIdApruebaTwo")
    private Collection<Requestdeta> requestdetaCollection;
    @OneToMany(mappedBy = "usuarioIdAprueba")
    private Collection<Requestdeta> requestdetaCollection1;
    @OneToMany(mappedBy = "usuarioReservacionId")
    private Collection<Reservacion> reservacionCollection;
    @OneToMany(mappedBy = "usuarioId")
    private Collection<Reservacion> reservacionCollection1;
    @JoinColumn(name = "EstadoId", referencedColumnName = "EstadoId")
    @ManyToOne
    private Estado estadoId;
    @JoinColumn(name = "RollId", referencedColumnName = "RollId")
    @ManyToOne
    private Roll rollId;
    @JoinColumn(name = "CiudadId", referencedColumnName = "CiudadId")
    @ManyToOne
    private Ciudad ciudadId;
    @OneToMany(mappedBy = "usuarioId")
    private Collection<Renta> rentaCollection;
    @OneToMany(mappedBy = "usuarioCreador")
    private Collection<Renta> rentaCollection1;

    public Usuario() {
    }

    public Usuario(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Integer getUsuarioIdentificacion() {
        return usuarioIdentificacion;
    }

    public void setUsuarioIdentificacion(Integer usuarioIdentificacion) {
        this.usuarioIdentificacion = usuarioIdentificacion;
    }

    public String getUsuarioNombre() {
        return usuarioNombre;
    }

    public void setUsuarioNombre(String usuarioNombre) {
        this.usuarioNombre = usuarioNombre;
    }

    public String getUsuarioApellido() {
        return usuarioApellido;
    }

    public void setUsuarioApellido(String usuarioApellido) {
        this.usuarioApellido = usuarioApellido;
    }

    public String getUsuarioEmail() {
        return usuarioEmail;
    }

    public void setUsuarioEmail(String usuarioEmail) {
        this.usuarioEmail = usuarioEmail;
    }

    public String getUsuarioPassword() {
        return usuarioPassword;
    }

    public void setUsuarioPassword(String usuarioPassword) {
        this.usuarioPassword = usuarioPassword;
    }

    public String getUsuarioDireccion() {
        return usuarioDireccion;
    }

    public void setUsuarioDireccion(String usuarioDireccion) {
        this.usuarioDireccion = usuarioDireccion;
    }

    public String getUsuarioCel() {
        return usuarioCel;
    }

    public void setUsuarioCel(String usuarioCel) {
        this.usuarioCel = usuarioCel;
    }

    @XmlTransient
    public Collection<Facturaencab> getFacturaencabCollection() {
        return facturaencabCollection;
    }

    public void setFacturaencabCollection(Collection<Facturaencab> facturaencabCollection) {
        this.facturaencabCollection = facturaencabCollection;
    }

    @XmlTransient
    public Collection<Ordencompra> getOrdencompraCollection() {
        return ordencompraCollection;
    }

    public void setOrdencompraCollection(Collection<Ordencompra> ordencompraCollection) {
        this.ordencompraCollection = ordencompraCollection;
    }

    @XmlTransient
    public Collection<Ordencompra> getOrdencompraCollection2() {
        return ordencompraCollection2;
    }

    public void setOrdencompraCollection2(Collection<Ordencompra> ordencompraCollection2) {
        this.ordencompraCollection2 = ordencompraCollection2;
    }

    @XmlTransient
    public Collection<Encabezadorequerimiento> getEncabezadorequerimientoCollection() {
        return encabezadorequerimientoCollection;
    }

    public void setEncabezadorequerimientoCollection(Collection<Encabezadorequerimiento> encabezadorequerimientoCollection) {
        this.encabezadorequerimientoCollection = encabezadorequerimientoCollection;
    }

    
    @XmlTransient
    public Collection<Producciondeta> getProduccionCollection() {
        return producciondetaCollection;
    }

    public void setProduccionCollection(Collection<Producciondeta> produccionCollection) {
        this.producciondetaCollection = produccionCollection;
    }
    
    @XmlTransient
    public Collection<Produccion> getProduccionCollection1() {
        return produccionCollection1;
    }

    public void setProduccionCollection1(Collection<Produccion> produccionCollection1) {
        this.produccionCollection1 = produccionCollection1;
    }

    @XmlTransient
    public Collection<Requestdeta> getRequestdetaCollection() {
        return requestdetaCollection;
    }

    public void setRequestdetaCollection(Collection<Requestdeta> requestdetaCollection) {
        this.requestdetaCollection = requestdetaCollection;
    }

    @XmlTransient
    public Collection<Requestdeta> getRequestdetaCollection1() {
        return requestdetaCollection1;
    }

    public void setRequestdetaCollection1(Collection<Requestdeta> requestdetaCollection1) {
        this.requestdetaCollection1 = requestdetaCollection1;
    }

    @XmlTransient
    public Collection<Reservacion> getReservacionCollection() {
        return reservacionCollection;
    }

    public void setReservacionCollection(Collection<Reservacion> reservacionCollection) {
        this.reservacionCollection = reservacionCollection;
    }

    @XmlTransient
    public Collection<Reservacion> getReservacionCollection1() {
        return reservacionCollection1;
    }

    public void setReservacionCollection1(Collection<Reservacion> reservacionCollection1) {
        this.reservacionCollection1 = reservacionCollection1;
    }

    public Estado getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(Estado estadoId) {
        this.estadoId = estadoId;
    }

    public Roll getRollId() {
        return rollId;
    }

    public void setRollId(Roll rollId) {
        this.rollId = rollId;
    }

    public Ciudad getCiudadId() {
        return ciudadId;
    }

    public void setCiudadId(Ciudad ciudadId) {
        this.ciudadId = ciudadId;
    }

    @XmlTransient
    public Collection<Renta> getRentaCollection() {
        return rentaCollection;
    }

    public void setRentaCollection(Collection<Renta> rentaCollection) {
        this.rentaCollection = rentaCollection;
    }

    @XmlTransient
    public Collection<Renta> getRentaCollection1() {
        return rentaCollection1;
    }

    public void setRentaCollection1(Collection<Renta> rentaCollection1) {
        this.rentaCollection1 = rentaCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioId != null ? usuarioId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.usuarioId == null && other.usuarioId != null) || (this.usuarioId != null && !this.usuarioId.equals(other.usuarioId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.universitaria.atelier.web.jpa.Usuario[ usuarioId=" + usuarioId + " ]";
    }

    @XmlTransient
    public Collection<Produccionusuario> getProduccionusuarioCollection() {
        return produccionusuarioCollection;
    }

    public void setProduccionusuarioCollection(Collection<Produccionusuario> produccionusuarioCollection) {
        this.produccionusuarioCollection = produccionusuarioCollection;
    }

    @XmlTransient
    public Collection<Producciondeta> getProducciondetaCollection() {
        return producciondetaCollection;
    }

    public void setProducciondetaCollection(Collection<Producciondeta> producciondetaCollection) {
        this.producciondetaCollection = producciondetaCollection;
    }

    public Contrato getContratoId() {
        return contratoId;
    }

    public void setContratoId(Contrato contratoId) {
        this.contratoId = contratoId;
    }
    
}
