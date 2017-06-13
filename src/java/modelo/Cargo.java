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
@Table(name = "cargo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cargo.findAll", query = "SELECT c FROM Cargo c"),
    @NamedQuery(name = "Cargo.findByIdCargo", query = "SELECT c FROM Cargo c WHERE c.idCargo = :idCargo"),
    @NamedQuery(name = "Cargo.findByNomeCargo", query = "SELECT c FROM Cargo c WHERE c.nomeCargo = :nomeCargo"),
    @NamedQuery(name = "Cargo.findByDescricao", query = "SELECT c FROM Cargo c WHERE c.descricao = :descricao"),
    @NamedQuery(name = "Cargo.findByPermissoes", query = "SELECT c FROM Cargo c WHERE c.permissoes = :permissoes"),
    @NamedQuery(name = "Cargo.findBySalario", query = "SELECT c FROM Cargo c WHERE c.salario = :salario")})
public class Cargo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idCargo")
    private Integer idCargo;
    @Size(max = 45)
    @Column(name = "nomeCargo")
    private String nomeCargo;
    @Size(max = 45)
    @Column(name = "descricao")
    private String descricao;
    @Size(max = 45)
    @Column(name = "permissoes")
    private String permissoes;
    @Size(max = 45)
    @Column(name = "salario")
    private String salario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cargoidCargo")
    private Collection<Funcionarios> funcionariosCollection;

    public Cargo() {
    }

    public Cargo(Integer idCargo, String nomeCargo, String descricao, String permissoes, String salario) {
        this.idCargo = idCargo;
        this.nomeCargo = nomeCargo;
        this.descricao = descricao;
        this.permissoes = permissoes;
        this.salario = salario;
    }

   

    
    
    public Cargo(Integer idCargo) {
        this.idCargo = idCargo;
    }

    public Integer getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Integer idCargo) {
        this.idCargo = idCargo;
    }

    public String getNomeCargo() {
        return nomeCargo;
    }

    public void setNomeCargo(String nomeCargo) {
        this.nomeCargo = nomeCargo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(String permissoes) {
        this.permissoes = permissoes;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
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
        hash += (idCargo != null ? idCargo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cargo)) {
            return false;
        }
        Cargo other = (Cargo) object;
        if ((this.idCargo == null && other.idCargo != null) || (this.idCargo != null && !this.idCargo.equals(other.idCargo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Cargo[ idCargo=" + idCargo + " ]";
    }
    
}
