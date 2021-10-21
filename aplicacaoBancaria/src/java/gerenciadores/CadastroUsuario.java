/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadores;

import conta.entidadesBanco.Usuario;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;

/**
 * f
 *
 * @author User
 */
@ManagedBean(name="Cadastro")
public class CadastroUsuario implements Serializable {

    private Usuario usuario;

    /**
     * Creates a new instance of CadastroUsuario
     */
    public CadastroUsuario() {
        
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    

}
