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
@Table(name = "modalidade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Modalidade.findAll", query = "SELECT m FROM Modalidade m"),
    @NamedQuery(name = "Modalidade.findByIdModalidade", query = "SELECT m FROM Modalidade m WHERE m.idModalidade = :idModalidade"),
    @NamedQuery(name = "Modalidade.findBySexo", query = "SELECT m FROM Modalidade m WHERE m.sexo = :sexo"),
    @NamedQuery(name = "Modalidade.findByPercurso", query = "SELECT m FROM Modalidade m WHERE m.percurso = :percurso"),
    @NamedQuery(name = "Modalidade.findByHoraLargada", query = "SELECT m FROM Modalidade m WHERE m.horaLargada = :horaLargada"),
    @NamedQuery(name = "Modalidade.findByTipoProva", query = "SELECT m FROM Modalidade m WHERE m.tipoProva = :tipoProva"),
    @NamedQuery(name = "Modalidade.findByQuilometragem", query = "SELECT m FROM Modalidade m WHERE m.quilometragem = :quilometragem")})
public class Modalidade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idModalidade")
    private Integer idModalidade;
    @Size(max = 45)
    @Column(name = "sexo")
    private String sexo;
    @Size(max = 45)
    @Column(name = "percurso")
    private String percurso;
    @Size(max = 45)
    @Column(name = "horaLargada")
    private String horaLargada;
    @Size(max = 45)
    @Column(name = "tipoProva")
    private String tipoProva;
    @Column(name = "quilometragem")
    private Integer quilometragem;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modalidadeidModalidade")
    private Collection<Inscricao> inscricaoCollection;

    public Modalidade() {
    }

    public Modalidade(Integer idModalidade, String sexo, String percurso, String horaLargada, String tipoProva, Integer quilometragem) {
        this.idModalidade = idModalidade;
        this.sexo = sexo;
        this.percurso = percurso;
        this.horaLargada = horaLargada;
        this.tipoProva = tipoProva;
        this.quilometragem = quilometragem;
    }

    
    public Modalidade(Integer idModalidade) {
        this.idModalidade = idModalidade;
    }

    public Integer getIdModalidade() {
        return idModalidade;
    }

    public void setIdModalidade(Integer idModalidade) {
        this.idModalidade = idModalidade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getPercurso() {
        return percurso;
    }

    public void setPercurso(String percurso) {
        this.percurso = percurso;
    }

    public String getHoraLargada() {
        return horaLargada;
    }

    public void setHoraLargada(String horaLargada) {
        this.horaLargada = horaLargada;
    }

    public String getTipoProva() {
        return tipoProva;
    }

    public void setTipoProva(String tipoProva) {
        this.tipoProva = tipoProva;
    }

    public Integer getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(Integer quilometragem) {
        this.quilometragem = quilometragem;
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
        hash += (idModalidade != null ? idModalidade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Modalidade)) {
            return false;
        }
        Modalidade other = (Modalidade) object;
        if ((this.idModalidade == null && other.idModalidade != null) || (this.idModalidade != null && !this.idModalidade.equals(other.idModalidade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Modalidade[ idModalidade=" + idModalidade + " ]";
    }
    
}
