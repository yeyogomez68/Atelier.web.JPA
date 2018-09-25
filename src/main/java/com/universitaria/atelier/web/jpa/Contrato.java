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
@Table(name = "contrato")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contrato.findAll", query = "SELECT c FROM Contrato c")
    , @NamedQuery(name = "Contrato.findByContratoId", query = "SELECT c FROM Contrato c WHERE c.contratoId = :contratoId")
    , @NamedQuery(name = "Contrato.findByContratoDesc", query = "SELECT c FROM Contrato c WHERE c.contratoDesc = :contratoDesc")})
public class Contrato implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ContratoId")
    private Integer contratoId;
    @Size(max = 50)
    @Column(name = "ContratoDesc")
    private String contratoDesc;
    @JoinColumn(name = "CargoId", referencedColumnName = "CargoId")
    @ManyToOne
    private Cargo cargoId;
    @OneToMany(mappedBy = "contratoId")
    private Collection<Usuario> usuarioCollection;

    public Contrato() {
    }

    public Contrato(Integer contratoId) {
        this.contratoId = contratoId;
    }

    public Integer getContratoId() {
        return contratoId;
    }

    public void setContratoId(Integer contratoId) {
        this.contratoId = contratoId;
    }

    public String getContratoDesc() {
        return contratoDesc;
    }

    public void setContratoDesc(String contratoDesc) {
        this.contratoDesc = contratoDesc;
    }

    public Cargo getCargoId() {
        return cargoId;
    }

    public void setCargoId(Cargo cargoId) {
        this.cargoId = cargoId;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contratoId != null ? contratoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contrato)) {
            return false;
        }
        Contrato other = (Contrato) object;
        if ((this.contratoId == null && other.contratoId != null) || (this.contratoId != null && !this.contratoId.equals(other.contratoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.universitaria.atelier.web.jpa.Contrato[ contratoId=" + contratoId + " ]";
    }

}
