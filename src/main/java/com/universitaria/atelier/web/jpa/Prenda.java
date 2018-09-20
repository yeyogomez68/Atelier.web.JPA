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
@Table(name = "prenda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prenda.findAll", query = "SELECT p FROM Prenda p")
    , @NamedQuery(name = "Prenda.findByPrendaId", query = "SELECT p FROM Prenda p WHERE p.prendaId = :prendaId")
    , @NamedQuery(name = "Prenda.findByPrendaNombre", query = "SELECT p FROM Prenda p WHERE p.prendaNombre = :prendaNombre")
    , @NamedQuery(name = "Prenda.findByPrendaDescripcion", query = "SELECT p FROM Prenda p WHERE p.prendaDescripcion = :prendaDescripcion")})
public class Prenda implements Serializable {

    @Size(max = 60)
    @Column(name = "ubicacion")
    private String ubicacion;
    @Size(max = 200)
    @Column(name = "URL")
    private String url;
    @OneToMany(mappedBy = "prendaId")
    private Collection<Prendamaterial> prendamaterialCollection;
    @JoinColumn(name = "tallaId", referencedColumnName = "TallaId")
    @ManyToOne
    private Talla tallaId;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PrendaId")
    private Integer prendaId;
    @Column(name = "PrendaNombre")
    private String prendaNombre;
    @Column(name = "PrendaDescripcion")
    private String prendaDescripcion;
    @OneToMany(mappedBy = "prendaId")
    private Collection<Rentadeta> rentadetaCollection;
    @OneToMany(mappedBy = "prendaId")
    private Collection<Facturadeta> facturadetaCollection;
    //@OneToMany(mappedBy = "prendaId")
    //private Collection<Produccion> produccionCollection;
    @OneToMany(mappedBy = "prendaId")
    private Collection<Stockprenda> stockprendaCollection;
    @OneToMany(mappedBy = "prendaId")
    private Collection<Reservacion> reservacionCollection;

    @OneToMany(mappedBy = "prendaId")
    private Collection<Produccion> produccionCollection;
    @JoinColumn(name = "ColorId", referencedColumnName = "ColorId")
    @ManyToOne
    private Color colorId;
    @JoinColumn(name = "EstadoId", referencedColumnName = "EstadoId")
    @ManyToOne
    private Estado estadoId;
    @JoinColumn(name = "PrendaTipoId", referencedColumnName = "PrendaTipoId")
    @ManyToOne
    private Prendatipo prendaTipoId;
    @JoinColumn(name = "MaterialId", referencedColumnName = "MaterialId")
    @ManyToOne
    private Material materialId;
    @JoinColumn(name = "OcasionId", referencedColumnName = "OcasionId")
    @ManyToOne
    private Ocasion ocasionId;

    public Prenda() {
    }

    public Prenda(Integer prendaId) {
        this.prendaId = prendaId;
    }

    public Integer getPrendaId() {
        return prendaId;
    }

    public void setPrendaId(Integer prendaId) {
        this.prendaId = prendaId;
    }

    public String getPrendaNombre() {
        return prendaNombre;
    }

    public void setPrendaNombre(String prendaNombre) {
        this.prendaNombre = prendaNombre;
    }

    public String getPrendaDescripcion() {
        return prendaDescripcion;
    }

    public void setPrendaDescripcion(String prendaDescripcion) {
        this.prendaDescripcion = prendaDescripcion;
    }

    @XmlTransient
    public Collection<Rentadeta> getRentadetaCollection() {
        return rentadetaCollection;
    }

    public void setRentadetaCollection(Collection<Rentadeta> rentadetaCollection) {
        this.rentadetaCollection = rentadetaCollection;
    }

    @XmlTransient
    public Collection<Facturadeta> getFacturadetaCollection() {
        return facturadetaCollection;
    }

    public void setFacturadetaCollection(Collection<Facturadeta> facturadetaCollection) {
        this.facturadetaCollection = facturadetaCollection;
    }

    @XmlTransient
    public Collection<Stockprenda> getStockprendaCollection() {
        return stockprendaCollection;
    }

    public void setStockprendaCollection(Collection<Stockprenda> stockprendaCollection) {
        this.stockprendaCollection = stockprendaCollection;
    }

    @XmlTransient
    public Collection<Reservacion> getReservacionCollection() {
        return reservacionCollection;
    }

    public void setReservacionCollection(Collection<Reservacion> reservacionCollection) {
        this.reservacionCollection = reservacionCollection;
    }

    @XmlTransient
    public Collection<Produccion> getProduccionCollection() {
        return produccionCollection;
    }

    public void setProduccionCollection(Collection<Produccion> produccionCollection) {
        this.produccionCollection = produccionCollection;
    }

    public Talla getTallaId() {
        return tallaId;
    }

    public void setTallaId(Talla tallaId) {
        this.tallaId = tallaId;
    }

    public Color getColorId() {
        return colorId;
    }

    public void setColorId(Color colorId) {
        this.colorId = colorId;
    }

    public Estado getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(Estado estadoId) {
        this.estadoId = estadoId;
    }

    public Prendatipo getPrendaTipoId() {
        return prendaTipoId;
    }

    public void setPrendaTipoId(Prendatipo prendaTipoId) {
        this.prendaTipoId = prendaTipoId;
    }

    public Material getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Material materialId) {
        this.materialId = materialId;
    }

    public Ocasion getOcasionId() {
        return ocasionId;
    }

    public void setOcasionId(Ocasion ocasionId) {
        this.ocasionId = ocasionId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prendaId != null ? prendaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prenda)) {
            return false;
        }
        Prenda other = (Prenda) object;
        if ((this.prendaId == null && other.prendaId != null) || (this.prendaId != null && !this.prendaId.equals(other.prendaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.universitaria.atelier.web.jpa.Prenda[ prendaId=" + prendaId + " ]";
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @XmlTransient
    public Collection<Prendamaterial> getPrendamaterialCollection() {
        return prendamaterialCollection;
    }

    public void setPrendamaterialCollection(Collection<Prendamaterial> prendamaterialCollection) {
        this.prendamaterialCollection = prendamaterialCollection;
    }
}
