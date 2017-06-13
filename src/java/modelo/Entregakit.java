/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author asus note
 */
@Entity
@Table(name = "entregakit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entregakit.findAll", query = "SELECT e FROM Entregakit e"),
    @NamedQuery(name = "Entregakit.findByIdEntregaKit", query = "SELECT e FROM Entregakit e WHERE e.idEntregaKit = :idEntregaKit"),
    @NamedQuery(name = "Entregakit.findByLogradouro", query = "SELECT e FROM Entregakit e WHERE e.logradouro = :logradouro"),
    @NamedQuery(name = "Entregakit.findByComplemento", query = "SELECT e FROM Entregakit e WHERE e.complemento = :complemento"),
    @NamedQuery(name = "Entregakit.findByNumero", query = "SELECT e FROM Entregakit e WHERE e.numero = :numero"),
    @NamedQuery(name = "Entregakit.findByBairro", query = "SELECT e FROM Entregakit e WHERE e.bairro = :bairro"),
    @NamedQuery(name = "Entregakit.findByUf", query = "SELECT e FROM Entregakit e WHERE e.uf = :uf"),
    @NamedQuery(name = "Entregakit.findByData", query = "SELECT e FROM Entregakit e WHERE e.data = :data"),
    @NamedQuery(name = "Entregakit.findByCep", query = "SELECT e FROM Entregakit e WHERE e.cep = :cep")})
public class Entregakit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idEntregaKit")
    private Integer idEntregaKit;
    @Size(max = 45)
    @Column(name = "logradouro")
    private String logradouro;
    @Size(max = 45)
    @Column(name = "complemento")
    private String complemento;
    @Column(name = "numero")
    private Integer numero;
    @Size(max = 45)
    @Column(name = "bairro")
    private String bairro;
    @Size(max = 45)
    @Column(name = "uf")
    private String uf;
    @Size(max = 45)
    @Column(name = "data")
    private String data;
    @Column(name = "cep")
    private Integer cep;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entregaKitidEntregaKit")
    private Collection<Kitprova> kitprovaCollection;

    public Entregakit() {
    }

    public Entregakit(Integer idEntregaKit, String logradouro, String complemento, Integer numero, String bairro, String uf, String data, Integer cep) {
        this.idEntregaKit = idEntregaKit;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.numero = numero;
        this.bairro = bairro;
        this.uf = uf;
        this.data = data;
        this.cep = cep;
    }

    
    
    public Entregakit(Integer idEntregaKit) {
        this.idEntregaKit = idEntregaKit;
    }

    public Integer getIdEntregaKit() {
        return idEntregaKit;
    }

    public void setIdEntregaKit(Integer idEntregaKit) {
        this.idEntregaKit = idEntregaKit;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    @XmlTransient
    public Collection<Kitprova> getKitprovaCollection() {
        return kitprovaCollection;
    }

    public void setKitprovaCollection(Collection<Kitprova> kitprovaCollection) {
        this.kitprovaCollection = kitprovaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEntregaKit != null ? idEntregaKit.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entregakit)) {
            return false;
        }
        Entregakit other = (Entregakit) object;
        if ((this.idEntregaKit == null && other.idEntregaKit != null) || (this.idEntregaKit != null && !this.idEntregaKit.equals(other.idEntregaKit))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Entregakit[ idEntregaKit=" + idEntregaKit + " ]";
    }
    
}
