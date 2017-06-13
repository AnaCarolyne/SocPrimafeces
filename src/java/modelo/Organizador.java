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
@Table(name = "organizador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Organizador.findAll", query = "SELECT o FROM Organizador o"),
    @NamedQuery(name = "Organizador.findByIdOrganizador", query = "SELECT o FROM Organizador o WHERE o.idOrganizador = :idOrganizador"),
    @NamedQuery(name = "Organizador.findByCpf", query = "SELECT o FROM Organizador o WHERE o.cpf = :cpf"),
    @NamedQuery(name = "Organizador.findBySenha", query = "SELECT o FROM Organizador o WHERE o.senha = :senha")})
public class Organizador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idOrganizador")
    private Integer idOrganizador;
    @Size(max = 45)
    @Column(name = "cpf")
    private String cpf;
    @Size(max = 45)
    @Column(name = "senha")
    private String senha;

    public Organizador() {
    }

    public Organizador(Integer idOrganizador) {
        this.idOrganizador = idOrganizador;
    }

    public Organizador(Integer idOrganizador, String cpf, String senha) {
        this.idOrganizador = idOrganizador;
        this.cpf = cpf;
        this.senha = senha;
    }        

    public Integer getIdOrganizador() {
        return idOrganizador;
    }

    public void setIdOrganizador(Integer idOrganizador) {
        this.idOrganizador = idOrganizador;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrganizador != null ? idOrganizador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Organizador)) {
            return false;
        }
        Organizador other = (Organizador) object;
        if ((this.idOrganizador == null && other.idOrganizador != null) || (this.idOrganizador != null && !this.idOrganizador.equals(other.idOrganizador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Organizador[ idOrganizador=" + idOrganizador + " ]";
    }
    
}
