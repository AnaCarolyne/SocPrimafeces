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
@Table(name = "objetokit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Objetokit.findAll", query = "SELECT o FROM Objetokit o"),
    @NamedQuery(name = "Objetokit.findByIdObjetoKit", query = "SELECT o FROM Objetokit o WHERE o.idObjetoKit = :idObjetoKit"),
    @NamedQuery(name = "Objetokit.findByNomeObjetoKit", query = "SELECT o FROM Objetokit o WHERE o.nomeObjetoKit = :nomeObjetoKit"),
    @NamedQuery(name = "Objetokit.findByDescricao", query = "SELECT o FROM Objetokit o WHERE o.descricao = :descricao"),
    @NamedQuery(name = "Objetokit.findByQuantidade", query = "SELECT o FROM Objetokit o WHERE o.quantidade = :quantidade")})
public class Objetokit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idObjetoKit")
    private Integer idObjetoKit;
    @Size(max = 45)
    @Column(name = "nomeObjetoKit")
    private String nomeObjetoKit;
    @Size(max = 45)
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "quantidade")
    private Integer quantidade;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "objetoKitidObjetoKit")
    private Collection<Kitprova> kitprovaCollection;

    public Objetokit() {
    }

    public Objetokit(Integer idObjetoKit, String nomeObjetoKit, String descricao, Integer quantidade) {
        this.idObjetoKit = idObjetoKit;
        this.nomeObjetoKit = nomeObjetoKit;
        this.descricao = descricao;
        this.quantidade = quantidade;
    }

    
    
    public Objetokit(Integer idObjetoKit) {
        this.idObjetoKit = idObjetoKit;
    }

    public Integer getIdObjetoKit() {
        return idObjetoKit;
    }

    public void setIdObjetoKit(Integer idObjetoKit) {
        this.idObjetoKit = idObjetoKit;
    }

    public String getNomeObjetoKit() {
        return nomeObjetoKit;
    }

    public void setNomeObjetoKit(String nomeObjetoKit) {
        this.nomeObjetoKit = nomeObjetoKit;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
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
        hash += (idObjetoKit != null ? idObjetoKit.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Objetokit)) {
            return false;
        }
        Objetokit other = (Objetokit) object;
        if ((this.idObjetoKit == null && other.idObjetoKit != null) || (this.idObjetoKit != null && !this.idObjetoKit.equals(other.idObjetoKit))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Objetokit[ idObjetoKit=" + idObjetoKit + " ]";
    }
    
}
