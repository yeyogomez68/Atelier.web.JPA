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
@Table(name = "produccionusuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produccionusuario.findAll", query = "SELECT p FROM Produccionusuario p")
    , @NamedQuery(name = "Produccionusuario.findByProductionUser", query = "SELECT p FROM Produccionusuario p WHERE p.productionUser = :productionUser")})
public class Produccionusuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ProductionUser")
    private Integer productionUser;
    @JoinColumn(name = "produccionId", referencedColumnName = "ProduccionId")
    @ManyToOne
    private Produccion produccionId;
    @JoinColumn(name = "UsuarioId", referencedColumnName = "UsuarioId")
    @ManyToOne
    private Usuario usuarioId;

    public Produccionusuario() {
    }

    public Produccionusuario(Integer productionUser) {
        this.productionUser = productionUser;
    }

    public Integer getProductionUser() {
        return productionUser;
    }

    public void setProductionUser(Integer productionUser) {
        this.productionUser = productionUser;
    }

    public Produccion getProduccionId() {
        return produccionId;
    }

    public void setProduccionId(Produccion produccionId) {
        this.produccionId = produccionId;
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
        hash += (productionUser != null ? productionUser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produccionusuario)) {
            return false;
        }
        Produccionusuario other = (Produccionusuario) object;
        if ((this.productionUser == null && other.productionUser != null) || (this.productionUser != null && !this.productionUser.equals(other.productionUser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.universitaria.atelier.web.jpa.Produccionusuario[ productionUser=" + productionUser + " ]";
    }

}
