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
@Table(name = "kitprova")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kitprova.findAll", query = "SELECT k FROM Kitprova k")
    ,
    @NamedQuery(name = "Kitprova.findByIdKitProva", query = "SELECT k FROM Kitprova k WHERE k.idKitProva = :idKitProva")
    ,
    @NamedQuery(name = "Kitprova.findByTamanho", query = "SELECT k FROM Kitprova k WHERE k.tamanho = :tamanho")
    ,
    @NamedQuery(name = "Kitprova.findBySexo", query = "SELECT k FROM Kitprova k WHERE k.sexo = :sexo")})
public class Kitprova implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idKitProva")
    private Integer idKitProva;
    @Size(max = 45)
    @Column(name = "tamanho")
    private String tamanho;
    @Size(max = 45)
    @Column(name = "sexo")
    private String sexo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kitProvaidKitProva")
    private Collection<Inscricao> inscricaoCollection;
    @JoinColumn(name = "Chip_idChip", referencedColumnName = "idChip")
    @ManyToOne(optional = false)
    private Chip chipidChip;
    @JoinColumn(name = "EntregaKit_idEntregaKit", referencedColumnName = "idEntregaKit")
    @ManyToOne(optional = false)
    private Entregakit entregaKitidEntregaKit;
    @JoinColumn(name = "ObjetoKit_idObjetoKit", referencedColumnName = "idObjetoKit")
    @ManyToOne(optional = false)
    private Objetokit objetoKitidObjetoKit;

    public Kitprova() {
    }

    public Kitprova(Integer idKitProva, String tamanho, String sexo) {
        this.idKitProva = idKitProva;
        this.tamanho = tamanho;
        this.sexo = sexo;
    }

    public Kitprova(Integer idKitProva) {
        this.idKitProva = idKitProva;
    }

    public Integer getIdKitProva() {
        return idKitProva;
    }

    public void setIdKitProva(Integer idKitProva) {
        this.idKitProva = idKitProva;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @XmlTransient
    public Collection<Inscricao> getInscricaoCollection() {
        return inscricaoCollection;
    }

    public void setInscricaoCollection(Collection<Inscricao> inscricaoCollection) {
        this.inscricaoCollection = inscricaoCollection;
    }

    public Chip getChipidChip() {
        return chipidChip;
    }

    public void setChipidChip(Chip chipidChip) {
        this.chipidChip = chipidChip;
    }

    public Entregakit getEntregaKitidEntregaKit() {
        return entregaKitidEntregaKit;
    }

    public void setEntregaKitidEntregaKit(Entregakit entregaKitidEntregaKit) {
        this.entregaKitidEntregaKit = entregaKitidEntregaKit;
    }

    public Objetokit getObjetoKitidObjetoKit() {
        return objetoKitidObjetoKit;
    }

    public void setObjetoKitidObjetoKit(Objetokit objetoKitidObjetoKit) {
        this.objetoKitidObjetoKit = objetoKitidObjetoKit;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idKitProva != null ? idKitProva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kitprova)) {
            return false;
        }
        Kitprova other = (Kitprova) object;
        if ((this.idKitProva == null && other.idKitProva != null) || (this.idKitProva != null && !this.idKitProva.equals(other.idKitProva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Kitprova[ idKitProva=" + idKitProva + " ]";
    }

}
