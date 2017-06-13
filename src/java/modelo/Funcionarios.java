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
@Table(name = "funcionarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Funcionarios.findAll", query = "SELECT f FROM Funcionarios f"),
    @NamedQuery(name = "Funcionarios.findByIdFuncionarios", query = "SELECT f FROM Funcionarios f WHERE f.idFuncionarios = :idFuncionarios"),
    @NamedQuery(name = "Funcionarios.findByNomeFuncionario", query = "SELECT f FROM Funcionarios f WHERE f.nomeFuncionario = :nomeFuncionario"),
    @NamedQuery(name = "Funcionarios.findByNascimento", query = "SELECT f FROM Funcionarios f WHERE f.nascimento = :nascimento"),
    @NamedQuery(name = "Funcionarios.findByCpf", query = "SELECT f FROM Funcionarios f WHERE f.cpf = :cpf"),
    @NamedQuery(name = "Funcionarios.findByRg", query = "SELECT f FROM Funcionarios f WHERE f.rg = :rg"),
    @NamedQuery(name = "Funcionarios.findBySexo", query = "SELECT f FROM Funcionarios f WHERE f.sexo = :sexo"),
    @NamedQuery(name = "Funcionarios.findByTelefone", query = "SELECT f FROM Funcionarios f WHERE f.telefone = :telefone"),
    @NamedQuery(name = "Funcionarios.findByCelular", query = "SELECT f FROM Funcionarios f WHERE f.celular = :celular"),
    @NamedQuery(name = "Funcionarios.findByLogin", query = "SELECT f FROM Funcionarios f WHERE f.login = :login"),
    @NamedQuery(name = "Funcionarios.findBySenha", query = "SELECT f FROM Funcionarios f WHERE f.senha = :senha"),
    @NamedQuery(name = "Funcionarios.findByLogradouro", query = "SELECT f FROM Funcionarios f WHERE f.logradouro = :logradouro"),
    @NamedQuery(name = "Funcionarios.findByBairro", query = "SELECT f FROM Funcionarios f WHERE f.bairro = :bairro"),
    @NamedQuery(name = "Funcionarios.findByCidade", query = "SELECT f FROM Funcionarios f WHERE f.cidade = :cidade"),
    @NamedQuery(name = "Funcionarios.findByUf", query = "SELECT f FROM Funcionarios f WHERE f.uf = :uf")})
public class Funcionarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idFuncionarios")
    private Integer idFuncionarios;
    @Size(max = 45)
    @Column(name = "nomeFuncionario")
    private String nomeFuncionario;
    @Size(max = 45)
    @Column(name = "nascimento")
    private String nascimento;
    @Size(max = 45)
    @Column(name = "cpf")
    private String cpf;
    @Size(max = 45)
    @Column(name = "rg")
    private String rg;
    @Size(max = 45)
    @Column(name = "sexo")
    private String sexo;
    @Column(name = "telefone")
    private Integer telefone;
    @Column(name = "celular")
    private Integer celular;
    @Size(max = 45)
    @Column(name = "login")
    private String login;
    @Size(max = 45)
    @Column(name = "senha")
    private String senha;
    @Size(max = 45)
    @Column(name = "logradouro")
    private String logradouro;
    @Size(max = 45)
    @Column(name = "bairro")
    private String bairro;
    @Size(max = 45)
    @Column(name = "cidade")
    private String cidade;
    @Size(max = 45)
    @Column(name = "uf")
    private String uf;
    @JoinColumn(name = "Cargo_idCargo", referencedColumnName = "idCargo")
    @ManyToOne(optional = false)
    private Cargo cargoidCargo;
    @JoinColumn(name = "Corrida_idCorrida", referencedColumnName = "idCorrida")
    @ManyToOne(optional = false)
    private Corrida corridaidCorrida;

    public Funcionarios() {
    }

    public Funcionarios(Integer idFuncionarios, String nomeFuncionario, String nascimento, String cpf, String rg, String sexo, Integer telefone, Integer celular, String login, String senha, String logradouro, String bairro, String cidade, String uf) {
        this.idFuncionarios = idFuncionarios;
        this.nomeFuncionario = nomeFuncionario;
        this.nascimento = nascimento;
        this.cpf = cpf;
        this.rg = rg;
        this.sexo = sexo;
        this.telefone = telefone;
        this.celular = celular;
        this.login = login;
        this.senha = senha;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
    }

    
    
    public Funcionarios(Integer idFuncionarios) {
        this.idFuncionarios = idFuncionarios;
    }

    public Integer getIdFuncionarios() {
        return idFuncionarios;
    }

    public void setIdFuncionarios(Integer idFuncionarios) {
        this.idFuncionarios = idFuncionarios;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Integer getTelefone() {
        return telefone;
    }

    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
    }

    public Integer getCelular() {
        return celular;
    }

    public void setCelular(Integer celular) {
        this.celular = celular;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Cargo getCargoidCargo() {
        return cargoidCargo;
    }

    public void setCargoidCargo(Cargo cargoidCargo) {
        this.cargoidCargo = cargoidCargo;
    }

    public Corrida getCorridaidCorrida() {
        return corridaidCorrida;
    }

    public void setCorridaidCorrida(Corrida corridaidCorrida) {
        this.corridaidCorrida = corridaidCorrida;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFuncionarios != null ? idFuncionarios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcionarios)) {
            return false;
        }
        Funcionarios other = (Funcionarios) object;
        if ((this.idFuncionarios == null && other.idFuncionarios != null) || (this.idFuncionarios != null && !this.idFuncionarios.equals(other.idFuncionarios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Funcionarios[ idFuncionarios=" + idFuncionarios + " ]";
    }
    
}
