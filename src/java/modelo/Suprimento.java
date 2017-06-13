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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "suprimento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Suprimento.findAll", query = "SELECT s FROM Suprimento s"),
    @NamedQuery(name = "Suprimento.findByIdSuprimento", query = "SELECT s FROM Suprimento s WHERE s.idSuprimento = :idSuprimento"),
    @NamedQuery(name = "Suprimento.findByNomeSuprimento", query = "SELECT s FROM Suprimento s WHERE s.nomeSuprimento = :nomeSuprimento"),
    @NamedQuery(name = "Suprimento.findByDescricao", query = "SELECT s FROM Suprimento s WHERE s.descricao = :descricao"),
    @NamedQuery(name = "Suprimento.findByQuantidade", query = "SELECT s FROM Suprimento s WHERE s.quantidade = :quantidade"),
    @NamedQuery(name = "Suprimento.findByMarca", query = "SELECT s FROM Suprimento s WHERE s.marca = :marca")})
public class Suprimento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idSuprimento")
    private Integer idSuprimento;
    @Size(max = 45)
    @Column(name = "nomeSuprimento")
    private String nomeSuprimento;
    @Size(max = 45)
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "quantidade")
    private Integer quantidade;
    @Size(max = 45)
    @Column(name = "marca")
    private String marca;
    @JoinColumn(name = "corrida_idCorrida", referencedColumnName = "idCorrida")
    @ManyToOne(optional = false)
    private Corrida corridaidCorrida;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "suprimentoidSuprimento")
    private Collection<Alimento> alimentoCollection;

    public Suprimento() {
    }

    public Suprimento(Integer idSuprimento, String nomeSuprimento, String descricao, Integer quantidade, String marca) {
        this.idSuprimento = idSuprimento;
        this.nomeSuprimento = nomeSuprimento;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.marca = marca;
    }

    public Suprimento(Integer idSuprimento) {
        this.idSuprimento = idSuprimento;
    }

    public Integer getIdSuprimento() {
        return idSuprimento;
    }

    public void setIdSuprimento(Integer idSuprimento) {
        this.idSuprimento = idSuprimento;
    }

    public String getNomeSuprimento() {
        return nomeSuprimento;
    }

    public void setNomeSuprimento(String nomeSuprimento) {
        this.nomeSuprimento = nomeSuprimento;
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

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Corrida getCorridaidCorrida() {
        return corridaidCorrida;
    }

    public void setCorridaidCorrida(Corrida corridaidCorrida) {
        this.corridaidCorrida = corridaidCorrida;
    }

    @XmlTransient
    public Collection<Alimento> getAlimentoCollection() {
        return alimentoCollection;
    }

    public void setAlimentoCollection(Collection<Alimento> alimentoCollection) {
        this.alimentoCollection = alimentoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSuprimento != null ? idSuprimento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Suprimento)) {
            return false;
        }
        Suprimento other = (Suprimento) object;
        if ((this.idSuprimento == null && other.idSuprimento != null) || (this.idSuprimento != null && !this.idSuprimento.equals(other.idSuprimento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Suprimento[ idSuprimento=" + idSuprimento + " ]";
    }
    
}
