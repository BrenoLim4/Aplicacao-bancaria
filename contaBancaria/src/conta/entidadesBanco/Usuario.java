/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conta.entidadesBanco;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author User
 */
@Entity
@Table(name = "usuario", schema = "gerenciador_contas_bancarias")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cpf", nullable = false, length = 14)
    private String cpf;
    @Basic(optional = false)
    @Column(name = "nome", nullable = false, length = 45)
    private String nome;
    @Basic(optional = false)
    @Column(name = "data_nascimento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    @Basic(optional = false)
    @Column(name = "idade", nullable = false)
    private int idade;
    @Basic(optional = false)
    @Column(name = "senha", nullable = false, length = 45)
    private String senha;
    @Basic(optional = false)
    @Column(name = "email", nullable = false, length = 45)
    private String email;
    @Basic(optional = false)
    @Column(name = "telefone", nullable = false, length = 45)
    private String telefone;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuariocpf", fetch = FetchType.LAZY)
    private List<ChavesPix> chavesPix;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuariocpf", fetch = FetchType.LAZY)
    private List<Conta> conta;

    public Usuario() {
    }

    public Usuario(String cpf) {
        this.cpf = cpf;
    }

    public Usuario(String cpf, String nome, Date dataNascimento, int idade, String senha, String email, String telefone) {
        this.cpf = cpf;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.idade = idade;
        this.senha = senha;
        this.email = email;
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @XmlTransient
    public List<ChavesPix> getChavesPix() {
        return chavesPix;
    }

    public void setChavesPix(List<ChavesPix> chavesPixCollection) {
        this.chavesPix = chavesPixCollection;
    }

    @XmlTransient
    public List<Conta> getConta() {
        return conta;
    }

    public void setConta(List<Conta> conta) {
        this.conta = conta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cpf != null ? cpf.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        return !((this.cpf == null && other.cpf != null) || (this.cpf != null && !this.cpf.equals(other.cpf)));
    }

    @Override
    public String toString() {
        return "conta.entidadesBanco.Usuario[ cpf=" + cpf + " ]";
    }
    
}
