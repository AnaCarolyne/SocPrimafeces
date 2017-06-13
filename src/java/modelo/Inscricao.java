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
@Table(name = "inscricao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inscricao.findAll", query = "SELECT i FROM Inscricao i"),
    @NamedQuery(name = "Inscricao.findByIdInscricao", query = "SELECT i FROM Inscricao i WHERE i.idInscricao = :idInscricao"),
    @NamedQuery(name = "Inscricao.findByBoleto", query = "SELECT i FROM Inscricao i WHERE i.boleto = :boleto"),
    @NamedQuery(name = "Inscricao.findByNumeroDePeito", query = "SELECT i FROM Inscricao i WHERE i.numeroDePeito = :numeroDePeito")})
public class Inscricao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idInscricao")
    private Integer idInscricao;
    @Column(name = "boleto")
    private Integer boleto;
    @Size(max = 45)
    @Column(name = "numeroDePeito")
    private String numeroDePeito;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inscricaoidInscricao")
    private Collection<Atleta> atletaCollection;
    @JoinColumn(name = "Corrida_idCorrida", referencedColumnName = "idCorrida")
    @ManyToOne(optional = false)
    private Corrida corridaidCorrida;
    @JoinColumn(name = "KitProva_idKitProva", referencedColumnName = "idKitProva")
    @ManyToOne(optional = false)
    private Kitprova kitProvaidKitProva;
    @JoinColumn(name = "Lote_idLote", referencedColumnName = "idLote")
    @ManyToOne(optional = false)
    private Lote loteidLote;
    @JoinColumn(name = "Modalidade_idModalidade", referencedColumnName = "idModalidade")
    @ManyToOne(optional = false)
    private Modalidade modalidadeidModalidade;

    public Inscricao() {
    }

    public Inscricao(Integer idInscricao, Integer boleto, String numeroDePeito) {
        this.idInscricao = idInscricao;
        this.boleto = boleto;
        this.numeroDePeito = numeroDePeito;
    }


    
    public Inscricao(Integer idInscricao) {
        this.idInscricao = idInscricao;
    }

    public Integer getIdInscricao() {
        return idInscricao;
    }

    public void setIdInscricao(Integer idInscricao) {
        this.idInscricao = idInscricao;
    }

    public Integer getBoleto() {
        return boleto;
    }

    public void setBoleto(Integer boleto) {
        this.boleto = boleto;
    }

    public String getNumeroDePeito() {
        return numeroDePeito;
    }

    public void setNumeroDePeito(String numeroDePeito) {
        this.numeroDePeito = numeroDePeito;
    }

    @XmlTransient
    public Collection<Atleta> getAtletaCollection() {
        return atletaCollection;
    }

    public void setAtletaCollection(Collection<Atleta> atletaCollection) {
        this.atletaCollection = atletaCollection;
    }

    public Corrida getCorridaidCorrida() {
        return corridaidCorrida;
    }

    public void setCorridaidCorrida(Corrida corridaidCorrida) {
        this.corridaidCorrida = corridaidCorrida;
    }

    public Kitprova getKitProvaidKitProva() {
        return kitProvaidKitProva;
    }

    public void setKitProvaidKitProva(Kitprova kitProvaidKitProva) {
        this.kitProvaidKitProva = kitProvaidKitProva;
    }

    public Lote getLoteidLote() {
        return loteidLote;
    }

    public void setLoteidLote(Lote loteidLote) {
        this.loteidLote = loteidLote;
    }

    public Modalidade getModalidadeidModalidade() {
        return modalidadeidModalidade;
    }

    public void setModalidadeidModalidade(Modalidade modalidadeidModalidade) {
        this.modalidadeidModalidade = modalidadeidModalidade;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInscricao != null ? idInscricao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inscricao)) {
            return false;
        }
        Inscricao other = (Inscricao) object;
        if ((this.idInscricao == null && other.idInscricao != null) || (this.idInscricao != null && !this.idInscricao.equals(other.idInscricao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Inscricao[ idInscricao=" + idInscricao + " ]";
    }
    
}
