/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author asus note
 */
@Entity
@Table(name = "alimento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alimento.findAll", query = "SELECT a FROM Alimento a"),
    @NamedQuery(name = "Alimento.findByIdAlimento", query = "SELECT a FROM Alimento a WHERE a.idAlimento = :idAlimento"),
    @NamedQuery(name = "Alimento.findByNomeAlimento", query = "SELECT a FROM Alimento a WHERE a.nomeAlimento = :nomeAlimento"),
    @NamedQuery(name = "Alimento.findByCalorias", query = "SELECT a FROM Alimento a WHERE a.calorias = :calorias"),
    @NamedQuery(name = "Alimento.findByQtdcarboidrato", query = "SELECT a FROM Alimento a WHERE a.qtdcarboidrato = :qtdcarboidrato"),
    @NamedQuery(name = "Alimento.findByPorcao", query = "SELECT a FROM Alimento a WHERE a.porcao = :porcao")})
public class Alimento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idAlimento")
    private Integer idAlimento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nomeAlimento")
    private String nomeAlimento;
    @Column(name = "calorias")
    private Integer calorias;
    @Column(name = "qtdcarboidrato")
    private Integer qtdcarboidrato;
    @Column(name = "porcao")
    private Integer porcao;
    @JoinColumn(name = "suprimento_idSuprimento", referencedColumnName = "idSuprimento")
    @ManyToOne(optional = false)
    private Suprimento suprimentoidSuprimento;

    public Alimento() {
    }

    public Alimento(Integer idAlimento) {
        this.idAlimento = idAlimento;
    }

    public Alimento(Integer idAlimento, String nomeAlimento) {
        this.idAlimento = idAlimento;
        this.nomeAlimento = nomeAlimento;
    }

    public Alimento(Integer idAlimento, String nomeAlimento, Integer calorias, Integer qtdcarboidrato, Integer porcao) {
        this.idAlimento = idAlimento;
        this.nomeAlimento = nomeAlimento;
        this.calorias = calorias;
        this.qtdcarboidrato = qtdcarboidrato;
        this.porcao = porcao;
    }
    
    

    public Integer getIdAlimento() {
        return idAlimento;
    }

    public void setIdAlimento(Integer idAlimento) {
        this.idAlimento = idAlimento;
    }

    public String getNomeAlimento() {
        return nomeAlimento;
    }

    public void setNomeAlimento(String nomeAlimento) {
        this.nomeAlimento = nomeAlimento;
    }

    public Integer getCalorias() {
        return calorias;
    }

    public void setCalorias(Integer calorias) {
        this.calorias = calorias;
    }

    public Integer getQtdcarboidrato() {
        return qtdcarboidrato;
    }

    public void setQtdcarboidrato(Integer qtdcarboidrato) {
        this.qtdcarboidrato = qtdcarboidrato;
    }

    public Integer getPorcao() {
        return porcao;
    }

    public void setPorcao(Integer porcao) {
        this.porcao = porcao;
    }

    public Suprimento getSuprimentoidSuprimento() {
        return suprimentoidSuprimento;
    }

    public void setSuprimentoidSuprimento(Suprimento suprimentoidSuprimento) {
        this.suprimentoidSuprimento = suprimentoidSuprimento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAlimento != null ? idAlimento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alimento)) {
            return false;
        }
        Alimento other = (Alimento) object;
        if ((this.idAlimento == null && other.idAlimento != null) || (this.idAlimento != null && !this.idAlimento.equals(other.idAlimento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Alimento[ idAlimento=" + idAlimento + " ]";
    }
    
}
