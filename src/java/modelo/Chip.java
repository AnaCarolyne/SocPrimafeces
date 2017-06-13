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
@Table(name = "chip")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Chip.findAll", query = "SELECT c FROM Chip c"),
    @NamedQuery(name = "Chip.findByIdChip", query = "SELECT c FROM Chip c WHERE c.idChip = :idChip"),
    @NamedQuery(name = "Chip.findByNumeroDePeito", query = "SELECT c FROM Chip c WHERE c.numeroDePeito = :numeroDePeito"),
    @NamedQuery(name = "Chip.findByTempo", query = "SELECT c FROM Chip c WHERE c.tempo = :tempo")})
public class Chip implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idChip")
    private Integer idChip;
    @Size(max = 45)
    @Column(name = "numeroDePeito")
    private String numeroDePeito;
    @Column(name = "tempo")
    private Integer tempo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chipidChip")
    private Collection<Kitprova> kitprovaCollection;

    public Chip() {
    }

    public Chip(Integer idChip, String numeroDePeito, Integer tempo) {
        this.idChip = idChip;
        this.numeroDePeito = numeroDePeito;
        this.tempo = tempo;
    }

    
    
    public Chip(Integer idChip) {
        this.idChip = idChip;
    }

    public Integer getIdChip() {
        return idChip;
    }

    public void setIdChip(Integer idChip) {
        this.idChip = idChip;
    }

    public String getNumeroDePeito() {
        return numeroDePeito;
    }

    public void setNumeroDePeito(String numeroDePeito) {
        this.numeroDePeito = numeroDePeito;
    }

    public Integer getTempo() {
        return tempo;
    }

    public void setTempo(Integer tempo) {
        this.tempo = tempo;
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
        hash += (idChip != null ? idChip.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chip)) {
            return false;
        }
        Chip other = (Chip) object;
        if ((this.idChip == null && other.idChip != null) || (this.idChip != null && !this.idChip.equals(other.idChip))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Chip[ idChip=" + idChip + " ]";
    }
    
}
