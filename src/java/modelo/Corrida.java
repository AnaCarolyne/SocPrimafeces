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
@Table(name = "corrida")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Corrida.findAll", query = "SELECT c FROM Corrida c"),
    @NamedQuery(name = "Corrida.findByIdCorrida", query = "SELECT c FROM Corrida c WHERE c.idCorrida = :idCorrida"),
    @NamedQuery(name = "Corrida.findByNomeCorrida", query = "SELECT c FROM Corrida c WHERE c.nomeCorrida = :nomeCorrida"),
    @NamedQuery(name = "Corrida.findByData", query = "SELECT c FROM Corrida c WHERE c.data = :data"),
    @NamedQuery(name = "Corrida.findByHorario", query = "SELECT c FROM Corrida c WHERE c.horario = :horario"),
    @NamedQuery(name = "Corrida.findByMaximoAtletas", query = "SELECT c FROM Corrida c WHERE c.maximoAtletas = :maximoAtletas"),
    @NamedQuery(name = "Corrida.findByEstado", query = "SELECT c FROM Corrida c WHERE c.estado = :estado"),
    @NamedQuery(name = "Corrida.findByOrganizadoridOrganizador", query = "SELECT c FROM Corrida c WHERE c.organizadoridOrganizador = :organizadoridOrganizador")})
public class Corrida implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idCorrida")
    private Integer idCorrida;
    @Size(max = 45)
    @Column(name = "nomeCorrida")
    private String nomeCorrida;
    @Size(max = 45)
    @Column(name = "data")
    private String data;
    @Size(max = 45)
    @Column(name = "horario")
    private String horario;
    @Column(name = "maximoAtletas")
    private Integer maximoAtletas;
    @Size(max = 45)
    @Column(name = "estado")
    private String estado;
    @JoinColumn(name = "Organizador_idOrganizador", referencedColumnName = "idOrganizador")
    @ManyToOne(optional = false)
    private Organizador organizadoridOrganizador;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "corridaidCorrida")
    private Collection<Inscricao> inscricaoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "corridaidCorrida")
    private Collection<Suprimento> suprimentoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "corridaidCorrida")
    private Collection<Funcionarios> funcionariosCollection;

    public Corrida() {
    }

    public Corrida(Integer idCorrida) {
        this.idCorrida = idCorrida;
    }

    public Corrida(Integer idCorrida, String nomeCorrida, String data, String horario, Integer maximoAtletas, String estado) {
        this.idCorrida = idCorrida;
        this.nomeCorrida = nomeCorrida;
        this.data = data;
        this.horario = horario;
        this.maximoAtletas = maximoAtletas;
        this.estado = estado;
    }

    public Integer getIdCorrida() {
        return idCorrida;
    }

    public void setIdCorrida(Integer idCorrida) {
        this.idCorrida = idCorrida;
    }

    public String getNomeCorrida() {
        return nomeCorrida;
    }

    public void setNomeCorrida(String nomeCorrida) {
        this.nomeCorrida = nomeCorrida;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Integer getMaximoAtletas() {
        return maximoAtletas;
    }

    public void setMaximoAtletas(Integer maximoAtletas) {
        this.maximoAtletas = maximoAtletas;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Organizador getOrganizadoridOrganizador() {
        return organizadoridOrganizador;
    }

    public void setOrganizadoridOrganizador(Organizador organizadoridOrganizador) {
        this.organizadoridOrganizador = organizadoridOrganizador;
    }

    @XmlTransient
    public Collection<Inscricao> getInscricaoCollection() {
        return inscricaoCollection;
    }

    public void setInscricaoCollection(Collection<Inscricao> inscricaoCollection) {
        this.inscricaoCollection = inscricaoCollection;
    }

    @XmlTransient
    public Collection<Suprimento> getSuprimentoCollection() {
        return suprimentoCollection;
    }

    public void setSuprimentoCollection(Collection<Suprimento> suprimentoCollection) {
        this.suprimentoCollection = suprimentoCollection;
    }

    @XmlTransient
    public Collection<Funcionarios> getFuncionariosCollection() {
        return funcionariosCollection;
    }

    public void setFuncionariosCollection(Collection<Funcionarios> funcionariosCollection) {
        this.funcionariosCollection = funcionariosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCorrida != null ? idCorrida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Corrida)) {
            return false;
        }
        Corrida other = (Corrida) object;
        if ((this.idCorrida == null && other.idCorrida != null) || (this.idCorrida != null && !this.idCorrida.equals(other.idCorrida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Corrida[ idCorrida=" + idCorrida + " ]";
    }

}
