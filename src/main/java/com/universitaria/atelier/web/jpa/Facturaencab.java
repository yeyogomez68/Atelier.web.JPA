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
@Table(name = "facturaencab")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Facturaencab.findAll", query = "SELECT f FROM Facturaencab f")
    , @NamedQuery(name = "Facturaencab.findByFacturaEncabId", query = "SELECT f FROM Facturaencab f WHERE f.facturaEncabId = :facturaEncabId")
    , @NamedQuery(name = "Facturaencab.findByFacturaEncabNumber", query = "SELECT f FROM Facturaencab f WHERE f.facturaEncabNumber = :facturaEncabNumber")
    , @NamedQuery(name = "Facturaencab.findByFacturaEncabValorBrut", query = "SELECT f FROM Facturaencab f WHERE f.facturaEncabValorBrut = :facturaEncabValorBrut")
    , @NamedQuery(name = "Facturaencab.findByFacturaEncabValorIVA", query = "SELECT f FROM Facturaencab f WHERE f.facturaEncabValorIVA = :facturaEncabValorIVA")
    , @NamedQuery(name = "Facturaencab.findByFacturaEncabValorTot", query = "SELECT f FROM Facturaencab f WHERE f.facturaEncabValorTot = :facturaEncabValorTot")
    , @NamedQuery(name = "Facturaencab.findByFacturaEncabUsuarioCreador", query = "SELECT f FROM Facturaencab f WHERE f.facturaEncabUsuarioCreador = :facturaEncabUsuarioCreador")
    , @NamedQuery(name = "Facturaencab.findByFacturaEncabUsuarioSell", query = "SELECT f FROM Facturaencab f WHERE f.facturaEncabUsuarioSell = :facturaEncabUsuarioSell")})
public class Facturaencab implements Serializable {

    @JoinColumn(name = "ClienteId", referencedColumnName = "ClienteId")
    @ManyToOne
    private Cliente clienteId;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "FacturaEncabId")
    private Integer facturaEncabId;
    @Basic(optional = false)
    @Column(name = "FacturaEncabNumber")
    private String facturaEncabNumber;
    @Basic(optional = false)
    @Column(name = "FacturaEncabValorBrut")
    private float facturaEncabValorBrut;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "FacturaEncabValorIVA")
    private Float facturaEncabValorIVA;
    @Basic(optional = false)
    @Column(name = "FacturaEncabValorTot")
    private float facturaEncabValorTot;
    @Column(name = "FacturaEncabUsuarioCreador")
    private Integer facturaEncabUsuarioCreador;
    @Column(name = "FacturaEncabUsuarioSell")
    private Integer facturaEncabUsuarioSell;
    @JoinColumn(name = "EstadoId", referencedColumnName = "EstadoId")
    @ManyToOne
    private Estado estadoId;
    @JoinColumn(name = "UsuarioId", referencedColumnName = "UsuarioId")
    @ManyToOne
    private Usuario usuarioId;
    @OneToMany(mappedBy = "facturaEncabId")
    private Collection<Facturadeta> facturadetaCollection;

    public Facturaencab() {
    }

    public Facturaencab(Integer facturaEncabId) {
        this.facturaEncabId = facturaEncabId;
    }

    public Facturaencab(Integer facturaEncabId, String facturaEncabNumber, float facturaEncabValorBrut, float facturaEncabValorTot) {
        this.facturaEncabId = facturaEncabId;
        this.facturaEncabNumber = facturaEncabNumber;
        this.facturaEncabValorBrut = facturaEncabValorBrut;
        this.facturaEncabValorTot = facturaEncabValorTot;
    }

    public Integer getFacturaEncabId() {
        return facturaEncabId;
    }

    public void setFacturaEncabId(Integer facturaEncabId) {
        this.facturaEncabId = facturaEncabId;
    }

    public String getFacturaEncabNumber() {
        return facturaEncabNumber;
    }

    public void setFacturaEncabNumber(String facturaEncabNumber) {
        this.facturaEncabNumber = facturaEncabNumber;
    }

    public float getFacturaEncabValorBrut() {
        return facturaEncabValorBrut;
    }

    public void setFacturaEncabValorBrut(float facturaEncabValorBrut) {
        this.facturaEncabValorBrut = facturaEncabValorBrut;
    }

    public Float getFacturaEncabValorIVA() {
        return facturaEncabValorIVA;
    }

    public void setFacturaEncabValorIVA(Float facturaEncabValorIVA) {
        this.facturaEncabValorIVA = facturaEncabValorIVA;
    }

    public float getFacturaEncabValorTot() {
        return facturaEncabValorTot;
    }

    public void setFacturaEncabValorTot(float facturaEncabValorTot) {
        this.facturaEncabValorTot = facturaEncabValorTot;
    }

    public Integer getFacturaEncabUsuarioCreador() {
        return facturaEncabUsuarioCreador;
    }

    public void setFacturaEncabUsuarioCreador(Integer facturaEncabUsuarioCreador) {
        this.facturaEncabUsuarioCreador = facturaEncabUsuarioCreador;
    }

    public Integer getFacturaEncabUsuarioSell() {
        return facturaEncabUsuarioSell;
    }

    public void setFacturaEncabUsuarioSell(Integer facturaEncabUsuarioSell) {
        this.facturaEncabUsuarioSell = facturaEncabUsuarioSell;
    }

    public Estado getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(Estado estadoId) {
        this.estadoId = estadoId;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    @XmlTransient
    public Collection<Facturadeta> getFacturadetaCollection() {
        return facturadetaCollection;
    }

    public void setFacturadetaCollection(Collection<Facturadeta> facturadetaCollection) {
        this.facturadetaCollection = facturadetaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facturaEncabId != null ? facturaEncabId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Facturaencab)) {
            return false;
        }
        Facturaencab other = (Facturaencab) object;
        if ((this.facturaEncabId == null && other.facturaEncabId != null) || (this.facturaEncabId != null && !this.facturaEncabId.equals(other.facturaEncabId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.universitaria.atelier.web.jpa.Facturaencab[ facturaEncabId=" + facturaEncabId + " ]";
    }

    public Cliente getClienteId() {
        return clienteId;
    }

    public void setClienteId(Cliente clienteId) {
        this.clienteId = clienteId;
    }

}
