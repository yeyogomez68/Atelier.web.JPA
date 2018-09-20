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
@Table(name = "ordencompradeta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ordencompradeta.findAll", query = "SELECT o FROM Ordencompradeta o")
    , @NamedQuery(name = "Ordencompradeta.findByOrdenCompraDetaId", query = "SELECT o FROM Ordencompradeta o WHERE o.ordenCompraDetaId = :ordenCompraDetaId")
    , @NamedQuery(name = "Ordencompradeta.findByOrdenCompraCantidad", query = "SELECT o FROM Ordencompradeta o WHERE o.ordenCompraCantidad = :ordenCompraCantidad")
    , @NamedQuery(name = "Ordencompradeta.findByOrdenCompraValorUnit", query = "SELECT o FROM Ordencompradeta o WHERE o.ordenCompraValorUnit = :ordenCompraValorUnit")
    , @NamedQuery(name = "Ordencompradeta.findByOrdenCompraIVA", query = "SELECT o FROM Ordencompradeta o WHERE o.ordenCompraIVA = :ordenCompraIVA")
    , @NamedQuery(name = "Ordencompradeta.findByOrdenCompraValorTot", query = "SELECT o FROM Ordencompradeta o WHERE o.ordenCompraValorTot = :ordenCompraValorTot")})
public class Ordencompradeta implements Serializable {

    @JoinColumn(name = "estadoId", referencedColumnName = "EstadoId")
    @ManyToOne
    private Estado estadoId;

    @JoinColumn(name = "EncabezadoRequerimientoId", referencedColumnName = "EncabezadoRequerimientoId")
    @ManyToOne
    private Encabezadorequerimiento encabezadoRequerimientoId;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "OrdenCompraDetaId")
    private Integer ordenCompraDetaId;
    @Basic(optional = false)
    @Column(name = "OrdenCompraCantidad")
    private float ordenCompraCantidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "OrdenCompraValorUnit")
    private Float ordenCompraValorUnit;
    @Lob
    @Column(name = "OrdenCompraDetaTotBruto")
    private String ordenCompraDetaTotBruto;
    @Column(name = "OrdenCompraIVA")
    private Float ordenCompraIVA;
    @Column(name = "OrdenCompraValorTot")
    private Float ordenCompraValorTot;
    @JoinColumn(name = "MaterialId", referencedColumnName = "MaterialId")
    @ManyToOne
    private Material materialId;
    @JoinColumn(name = "OrdenCompraId", referencedColumnName = "OrdenCompraId")
    @ManyToOne
    private Ordencompra ordenCompraId;

    public Ordencompradeta() {
    }

    public Ordencompradeta(Integer ordenCompraDetaId) {
        this.ordenCompraDetaId = ordenCompraDetaId;
    }

    public Ordencompradeta(Integer ordenCompraDetaId, float ordenCompraCantidad) {
        this.ordenCompraDetaId = ordenCompraDetaId;
        this.ordenCompraCantidad = ordenCompraCantidad;
    }

    public Integer getOrdenCompraDetaId() {
        return ordenCompraDetaId;
    }

    public void setOrdenCompraDetaId(Integer ordenCompraDetaId) {
        this.ordenCompraDetaId = ordenCompraDetaId;
    }

    public float getOrdenCompraCantidad() {
        return ordenCompraCantidad;
    }

    public void setOrdenCompraCantidad(float ordenCompraCantidad) {
        this.ordenCompraCantidad = ordenCompraCantidad;
    }

    public Float getOrdenCompraValorUnit() {
        return ordenCompraValorUnit;
    }

    public void setOrdenCompraValorUnit(Float ordenCompraValorUnit) {
        this.ordenCompraValorUnit = ordenCompraValorUnit;
    }

    public String getOrdenCompraDetaTotBruto() {
        return ordenCompraDetaTotBruto;
    }

    public void setOrdenCompraDetaTotBruto(String ordenCompraDetaTotBruto) {
        this.ordenCompraDetaTotBruto = ordenCompraDetaTotBruto;
    }

    public Float getOrdenCompraIVA() {
        return ordenCompraIVA;
    }

    public void setOrdenCompraIVA(Float ordenCompraIVA) {
        this.ordenCompraIVA = ordenCompraIVA;
    }

    public Float getOrdenCompraValorTot() {
        return ordenCompraValorTot;
    }

    public void setOrdenCompraValorTot(Float ordenCompraValorTot) {
        this.ordenCompraValorTot = ordenCompraValorTot;
    }

    public Material getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Material materialId) {
        this.materialId = materialId;
    }

    public Ordencompra getOrdenCompraId() {
        return ordenCompraId;
    }

    public void setOrdenCompraId(Ordencompra ordenCompraId) {
        this.ordenCompraId = ordenCompraId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ordenCompraDetaId != null ? ordenCompraDetaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ordencompradeta)) {
            return false;
        }
        Ordencompradeta other = (Ordencompradeta) object;
        if ((this.ordenCompraDetaId == null && other.ordenCompraDetaId != null) || (this.ordenCompraDetaId != null && !this.ordenCompraDetaId.equals(other.ordenCompraDetaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.universitaria.atelier.web.jpa.Ordencompradeta[ ordenCompraDetaId=" + ordenCompraDetaId + " ]";
    }

    public Encabezadorequerimiento getEncabezadoRequerimientoId() {
        return encabezadoRequerimientoId;
    }

    public void setEncabezadoRequerimientoId(Encabezadorequerimiento encabezadoRequerimientoId) {
        this.encabezadoRequerimientoId = encabezadoRequerimientoId;
    }

    public Estado getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(Estado estadoId) {
        this.estadoId = estadoId;
    }
    
}
