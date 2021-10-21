/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conta.entidadesBanco;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "chaves_pix")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ChavesPix.findAll", query = "SELECT c FROM ChavesPix c")
    , @NamedQuery(name = "ChavesPix.findByChave", query = "SELECT c FROM ChavesPix c WHERE c.chave = :chave")})
public class ChavesPix implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "chave", nullable = false, length = 45)
    private String chave;
    @JoinColumn(name = "Usuario_cpf", referencedColumnName = "cpf", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario usuariocpf;

    public ChavesPix() {
    }

    public ChavesPix(String chave) {
        this.chave = chave;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public Usuario getUsuariocpf() {
        return usuariocpf;
    }

    public void setUsuariocpf(Usuario usuariocpf) {
        this.usuariocpf = usuariocpf;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (chave != null ? chave.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChavesPix)) {
            return false;
        }
        ChavesPix other = (ChavesPix) object;
        if ((this.chave == null && other.chave != null) || (this.chave != null && !this.chave.equals(other.chave))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "conta.entidadesBanco.ChavesPix[ chave=" + chave + " ]";
    }
    
}
