/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conta.entidadesBanco;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@Table(name = "conta")
@XmlRootElement
public class Conta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "numero_conta", nullable = false, length = 45)
    private String numeroConta;
    @Basic(optional = false)
    @Column(name = "numero_agencia", nullable = false, length = 45)
    private String numeroAgencia;
    @Basic(optional = false)
    @Column(name = "vencimento", nullable = false, length = 6)
    private String vencimento;
    @Basic(optional = false)
    @Column(name = "cvv", nullable = false)
    private int cvv;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "saldo", nullable = false, precision = 16, scale = 2)
    private BigDecimal saldo;
    @JoinColumn(name = "Usuario_cpf", referencedColumnName = "cpf", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario usuariocpf;
    @JoinColumn(name = "tipo_conta_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoConta tipoContaId;

    public Conta() {
    }

    public Conta(Integer id) {
        this.id = id;
    }

    public Conta(Integer id, String numeroConta, String numeroAgencia, String vencimento, int cvv, BigDecimal saldo) {
        this.id = id;
        this.numeroConta = numeroConta;
        this.numeroAgencia = numeroAgencia;
        this.vencimento = vencimento;
        this.cvv = cvv;
        this.saldo = saldo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getNumeroAgencia() {
        return numeroAgencia;
    }

    public void setNumeroAgencia(String numeroAgencia) {
        this.numeroAgencia = numeroAgencia;
    }

    public String getVencimento() {
        return vencimento;
    }

    public void setVencimento(String vencimento) {
        this.vencimento = vencimento;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Usuario getUsuariocpf() {
        return usuariocpf;
    }

    public void setUsuariocpf(Usuario usuariocpf) {
        this.usuariocpf = usuariocpf;
    }

    public TipoConta getTipoContaId() {
        return tipoContaId;
    }

    public void setTipoContaId(TipoConta tipoContaId) {
        this.tipoContaId = tipoContaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Conta)) {
            return false;
        }
        Conta other = (Conta) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "conta.entidadesBanco.Conta[ id=" + id + " ]";
    }
    
}
