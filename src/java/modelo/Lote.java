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
@Table(name = "lote")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lote.findAll", query = "SELECT l FROM Lote l"),
    @NamedQuery(name = "Lote.findByIdLote", query = "SELECT l FROM Lote l WHERE l.idLote = :idLote"),
    @NamedQuery(name = "Lote.findByDataComeco", query = "SELECT l FROM Lote l WHERE l.dataComeco = :dataComeco"),
    @NamedQuery(name = "Lote.findByDataFim", query = "SELECT l FROM Lote l WHERE l.dataFim = :dataFim"),
    @NamedQuery(name = "Lote.findByValor", query = "SELECT l FROM Lote l WHERE l.valor = :valor")})
public class Lote implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idLote")
    private Integer idLote;
    @Size(max = 45)
    @Column(name = "dataComeco")
    private String dataComeco;
    @Size(max = 45)
    @Column(name = "dataFim")
    private String dataFim;
    @Size(max = 45)
    @Column(name = "valor")
    private String valor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "loteidLote")
    private Collection<Inscricao> inscricaoCollection;

    public Lote() {
    }

    public Lote(Integer idLote, String dataComeco, String dataFim, String valor) {
        this.idLote = idLote;
        this.dataComeco = dataComeco;
        this.dataFim = dataFim;
        this.valor = valor;
    }
    
    public Lote(Integer idLote) {
        this.idLote = idLote;
    }

    public Integer getIdLote() {
        return idLote;
    }

    public void setIdLote(Integer idLote) {
        this.idLote = idLote;
    }

    public String getDataComeco() {
        return dataComeco;
    }

    public void setDataComeco(String dataComeco) {
        this.dataComeco = dataComeco;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @XmlTransient
    public Collection<Inscricao> getInscricaoCollection() {
        return inscricaoCollection;
    }

    public void setInscricaoCollection(Collection<Inscricao> inscricaoCollection) {
        this.inscricaoCollection = inscricaoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLote != null ? idLote.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lote)) {
            return false;
        }
        Lote other = (Lote) object;
        if ((this.idLote == null && other.idLote != null) || (this.idLote != null && !this.idLote.equals(other.idLote))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Lote[ idLote=" + idLote + " ]";
    }
    
}
