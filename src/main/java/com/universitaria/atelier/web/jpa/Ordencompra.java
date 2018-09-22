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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jeisson.gomez
 */
@Entity
@Table(name = "ordencompra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ordencompra.findAll", query = "SELECT o FROM Ordencompra o")
    , @NamedQuery(name = "Ordencompra.findByOrdenCompraId", query = "SELECT o FROM Ordencompra o WHERE o.ordenCompraId = :ordenCompraId")
    , @NamedQuery(name = "Ordencompra.findByOrdenByUserId", query = "SELECT o FROM Ordencompra o WHERE o.usuarioId.usuarioId = :usuarioId")
    , @NamedQuery(name = "Ordencompra.findByOrdenCompraCode", query = "SELECT o FROM Ordencompra o WHERE o.ordenCompraCode = :ordenCompraCode")
    , @NamedQuery(name = "Ordencompra.findByOrdenCompraDescrip", query = "SELECT o FROM Ordencompra o WHERE o.ordenCompraDescrip = :ordenCompraDescrip")
    , @NamedQuery(name = "Ordencompra.findByOrdenCompraBruto", query = "SELECT o FROM Ordencompra o WHERE o.ordenCompraBruto = :ordenCompraBruto")
    , @NamedQuery(name = "Ordencompra.findByOrdenCompraIVA", query = "SELECT o FROM Ordencompra o WHERE o.ordenCompraIVA = :ordenCompraIVA")
    , @NamedQuery(name = "Ordencompra.findByOrdenCompraTot", query = "SELECT o FROM Ordencompra o WHERE o.ordenCompraTot = :ordenCompraTot")})
public class Ordencompra implements Serializable {

    @OneToMany(mappedBy = "ordenCompraId")
    private Collection<Ordencompradeta> ordencompradetaCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "OrdenCompraId")
    private Integer ordenCompraId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 19)
    @Column(name = "OrdenCompraCode")
    private String ordenCompraCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 600)
    @Column(name = "OrdenCompraDescrip")
    private String ordenCompraDescrip;

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "OrdenCompraBruto")
    private Double ordenCompraBruto;
    @Column(name = "OrdenCompraIVA")
    private Double ordenCompraIVA;
    @Column(name = "OrdenCompraTot")
    private Double ordenCompraTot;
    @JoinColumn(name = "EstadoId", referencedColumnName = "EstadoId")
    @ManyToOne
    private Estado estadoId;
    @JoinColumn(name = "ProveedorId", referencedColumnName = "ProveedorId")
    @ManyToOne
    private Proveedor proveedorId;
    @JoinColumn(name = "UsuarioId", referencedColumnName = "UsuarioId")
    @ManyToOne
    private Usuario usuarioId;


    public Ordencompra() {
    }

    public Ordencompra(Integer ordenCompraId) {
        this.ordenCompraId = ordenCompraId;
    }

    public Ordencompra(Integer ordenCompraId, String ordenCompraCode, String ordenCompraDescrip) {
        this.ordenCompraId = ordenCompraId;
        this.ordenCompraCode = ordenCompraCode;
        this.ordenCompraDescrip = ordenCompraDescrip;
    }

    public Integer getOrdenCompraId() {
        return ordenCompraId;
    }

    public void setOrdenCompraId(Integer ordenCompraId) {
        this.ordenCompraId = ordenCompraId;
    }

    public String getOrdenCompraCode() {
        return ordenCompraCode;
    }

    public void setOrdenCompraCode(String ordenCompraCode) {
        this.ordenCompraCode = ordenCompraCode;
    }

    public String getOrdenCompraDescrip() {
        return ordenCompraDescrip;
    }

    public void setOrdenCompraDescrip(String ordenCompraDescrip) {
        this.ordenCompraDescrip = ordenCompraDescrip;
    }

    public Double getOrdenCompraBruto() {
        return ordenCompraBruto;
    }

    public void setOrdenCompraBruto(Double ordenCompraBruto) {
        this.ordenCompraBruto = ordenCompraBruto;
    }

    public Double getOrdenCompraIVA() {
        return ordenCompraIVA;
    }

    public void setOrdenCompraIVA(Double ordenCompraIVA) {
        this.ordenCompraIVA = ordenCompraIVA;
    }

    public Double getOrdenCompraTot() {
        return ordenCompraTot;
    }

    public void setOrdenCompraTot(Double ordenCompraTot) {
        this.ordenCompraTot = ordenCompraTot;
    }

    public Estado getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(Estado estadoId) {
        this.estadoId = estadoId;
    }

    public Proveedor getProveedorId() {
        return proveedorId;
    }

    public void setProveedorId(Proveedor proveedorId) {
        this.proveedorId = proveedorId;
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
        hash += (ordenCompraId != null ? ordenCompraId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ordencompra)) {
            return false;
        }
        Ordencompra other = (Ordencompra) object;
        if ((this.ordenCompraId == null && other.ordenCompraId != null) || (this.ordenCompraId != null && !this.ordenCompraId.equals(other.ordenCompraId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.universitaria.atelier.web.jpa.Ordencompra[ ordenCompraId=" + ordenCompraId + " ]";
    }

    @XmlTransient
    public Collection<Ordencompradeta> getOrdencompradetaCollection() {
        return ordencompradetaCollection;
    }

    public void setOrdencompradetaCollection(Collection<Ordencompradeta> ordencompradetaCollection) {
        this.ordencompradetaCollection = ordencompradetaCollection;
    }
    
}
