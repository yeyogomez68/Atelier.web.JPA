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
@Table(name = "cargo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cargo.findAll", query = "SELECT c FROM Cargo c")
    , @NamedQuery(name = "Cargo.findByCargoId", query = "SELECT c FROM Cargo c WHERE c.cargoId = :cargoId")
    , @NamedQuery(name = "Cargo.findByCargoDesc", query = "SELECT c FROM Cargo c WHERE upper( c.cargoDesc ) = upper( :cargoDesc )")})
public class Cargo implements Serializable {

    @OneToMany(mappedBy = "cargoId")
    private Collection<Contrato> contratoCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CargoId")
    private Integer cargoId;
    @Size(max = 50)
    @Column(name = "CargoDesc")
    private String cargoDesc;

    public Cargo() {
    }

    public Cargo(Integer cargoId) {
        this.cargoId = cargoId;
    }

    public Integer getCargoId() {
        return cargoId;
    }

    public void setCargoId(Integer cargoId) {
        this.cargoId = cargoId;
    }

    public String getCargoDesc() {
        return cargoDesc;
    }

    public void setCargoDesc(String cargoDesc) {
        this.cargoDesc = cargoDesc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cargoId != null ? cargoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cargo)) {
            return false;
        }
        Cargo other = (Cargo) object;
        if ((this.cargoId == null && other.cargoId != null) || (this.cargoId != null && !this.cargoId.equals(other.cargoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.universitaria.atelier.web.jpa.Cargo[ cargoId=" + cargoId + " ]";
    }

    @XmlTransient
    public Collection<Contrato> getContratoCollection() {
        return contratoCollection;
    }

    public void setContratoCollection(Collection<Contrato> contratoCollection) {
        this.contratoCollection = contratoCollection;
    }

}
