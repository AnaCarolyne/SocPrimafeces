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
@Table(name = "atleta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Atleta.findAll", query = "SELECT a FROM Atleta a"),
    @NamedQuery(name = "Atleta.findByIdAtleta", query = "SELECT a FROM Atleta a WHERE a.idAtleta = :idAtleta"),
    @NamedQuery(name = "Atleta.findByNomeAtleta", query = "SELECT a FROM Atleta a WHERE a.nomeAtleta = :nomeAtleta"),
    @NamedQuery(name = "Atleta.findByDataNascimento", query = "SELECT a FROM Atleta a WHERE a.dataNascimento = :dataNascimento"),
    @NamedQuery(name = "Atleta.findByLogradouro", query = "SELECT a FROM Atleta a WHERE a.logradouro = :logradouro"),
    @NamedQuery(name = "Atleta.findByNumero", query = "SELECT a FROM Atleta a WHERE a.numero = :numero"),
    @NamedQuery(name = "Atleta.findByComplemento", query = "SELECT a FROM Atleta a WHERE a.complemento = :complemento"),
    @NamedQuery(name = "Atleta.findByBairro", query = "SELECT a FROM Atleta a WHERE a.bairro = :bairro"),
    @NamedQuery(name = "Atleta.findByCidade", query = "SELECT a FROM Atleta a WHERE a.cidade = :cidade"),
    @NamedQuery(name = "Atleta.findByEstado", query = "SELECT a FROM Atleta a WHERE a.estado = :estado"),
    @NamedQuery(name = "Atleta.findByCpf", query = "SELECT a FROM Atleta a WHERE a.cpf = :cpf"),
    @NamedQuery(name = "Atleta.findByRg", query = "SELECT a FROM Atleta a WHERE a.rg = :rg"),
    @NamedQuery(name = "Atleta.findBySexo", query = "SELECT a FROM Atleta a WHERE a.sexo = :sexo"),
    @NamedQuery(name = "Atleta.findByTelefone", query = "SELECT a FROM Atleta a WHERE a.telefone = :telefone"),
    @NamedQuery(name = "Atleta.findByCelular", query = "SELECT a FROM Atleta a WHERE a.celular = :celular"),
    @NamedQuery(name = "Atleta.findByPortDeficiencia", query = "SELECT a FROM Atleta a WHERE a.portDeficiencia = :portDeficiencia"),
    @NamedQuery(name = "Atleta.findByContEmergencia", query = "SELECT a FROM Atleta a WHERE a.contEmergencia = :contEmergencia"),
    @NamedQuery(name = "Atleta.findByLogin", query = "SELECT a FROM Atleta a WHERE a.login = :login"),
    @NamedQuery(name = "Atleta.findBySenha", query = "SELECT a FROM Atleta a WHERE a.senha = :senha"),
    @NamedQuery(name = "Atleta.findByEmail", query = "SELECT a FROM Atleta a WHERE a.email = :email"),
    @NamedQuery(name = "Atleta.findByCep", query = "SELECT a FROM Atleta a WHERE a.cep = :cep"),
    @NamedQuery(name = "Atleta.findByTipoSanguineo", query = "SELECT a FROM Atleta a WHERE a.tipoSanguineo = :tipoSanguineo")})
public class Atleta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idAtleta")
    private Integer idAtleta;
    @Size(max = 45)
    @Column(name = "nomeAtleta")
    private String nomeAtleta;
    @Size(max = 45)
    @Column(name = "dataNascimento")
    private String dataNascimento;
    @Size(max = 45)
    @Column(name = "logradouro")
    private String logradouro;
    @Column(name = "numero")
    private Integer numero;
    @Size(max = 45)
    @Column(name = "complemento")
    private String complemento;
    @Size(max = 45)
    @Column(name = "bairro")
    private String bairro;
    @Size(max = 45)
    @Column(name = "cidade")
    private String cidade;
    @Size(max = 45)
    @Column(name = "estado")
    private String estado;
    @Column(name = "cpf")
    private Integer cpf;
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
    @Column(name = "portDeficiencia")
    private Integer portDeficiencia;
    @Column(name = "contEmergencia")
    private Integer contEmergencia;
    @Size(max = 45)
    @Column(name = "login")
    private String login;
    @Size(max = 45)
    @Column(name = "senha")
    private String senha;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "email")
    private String email;
    @Column(name = "cep")
    private Integer cep;
    @Size(max = 45)
    @Column(name = "tipoSanguineo")
    private String tipoSanguineo;
    @JoinColumn(name = "Inscricao_idInscricao", referencedColumnName = "idInscricao")
    @ManyToOne(optional = false)
    private Inscricao inscricaoidInscricao;

    public Atleta() {
    }

    public Atleta(Integer idAtleta, String nomeAtleta, String dataNascimento, String logradouro, Integer numero, String complemento, String bairro, String cidade, String estado, Integer cpf, String rg, String sexo, Integer telefone, Integer celular, Integer portDeficiencia, Integer contEmergencia, String login, String senha, String email, Integer cep, String tipoSanguineo) {
        this.idAtleta = idAtleta;
        this.nomeAtleta = nomeAtleta;
        this.dataNascimento = dataNascimento;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cpf = cpf;
        this.rg = rg;
        this.sexo = sexo;
        this.telefone = telefone;
        this.celular = celular;
        this.portDeficiencia = portDeficiencia;
        this.contEmergencia = contEmergencia;
        this.login = login;
        this.senha = senha;
        this.email = email;
        this.cep = cep;
        this.tipoSanguineo = tipoSanguineo;
    }

    
    
    public Atleta(Integer idAtleta) {
        this.idAtleta = idAtleta;
    }

    public Integer getIdAtleta() {
        return idAtleta;
    }

    public void setIdAtleta(Integer idAtleta) {
        this.idAtleta = idAtleta;
    }

    public String getNomeAtleta() {
        return nomeAtleta;
    }

    public void setNomeAtleta(String nomeAtleta) {
        this.nomeAtleta = nomeAtleta;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getCpf() {
        return cpf;
    }

    public void setCpf(Integer cpf) {
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

    public Integer getPortDeficiencia() {
        return portDeficiencia;
    }

    public void setPortDeficiencia(Integer portDeficiencia) {
        this.portDeficiencia = portDeficiencia;
    }

    public Integer getContEmergencia() {
        return contEmergencia;
    }

    public void setContEmergencia(Integer contEmergencia) {
        this.contEmergencia = contEmergencia;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    public Inscricao getInscricaoidInscricao() {
        return inscricaoidInscricao;
    }

    public void setInscricaoidInscricao(Inscricao inscricaoidInscricao) {
        this.inscricaoidInscricao = inscricaoidInscricao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAtleta != null ? idAtleta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Atleta)) {
            return false;
        }
        Atleta other = (Atleta) object;
        if ((this.idAtleta == null && other.idAtleta != null) || (this.idAtleta != null && !this.idAtleta.equals(other.idAtleta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Atleta[ idAtleta=" + idAtleta + " ]";
    }
    
}
