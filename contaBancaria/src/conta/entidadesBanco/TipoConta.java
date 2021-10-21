/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conta.entidadesBanco;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author User
 */
@Entity
@Table(name = "tipo_conta")
@XmlRootElement
public class TipoConta implements Serializable {

    private static final int CONTA_CORRENTE = 1;
    private static final int CONTA_POUPANCA = 2;
    private static final int CONTA_DIGITAL = 3;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "descricao", nullable = false, length = 45)
    private String descricao;

    public TipoConta() {
    }

    public TipoConta(Integer id) {
        this.id = id;
    }

    public TipoConta(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public static int getCONTA_CORRENTE() {
        return CONTA_CORRENTE;
    }

    @XmlTransient
    public static int getCONTA_POUPANCA() {
        return CONTA_POUPANCA;
    }

    @XmlTransient
    public static int getCONTA_DIGITAL() {
        return CONTA_DIGITAL;
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
        if (!(object instanceof TipoConta)) {
            return false;
        }
        TipoConta other = (TipoConta) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "conta.entidadesBanco.TipoConta[ id=" + id + " ]";
    }

}
