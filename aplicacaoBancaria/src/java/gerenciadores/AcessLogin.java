/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadores;



//import conta.RepositorioDAO.Repositorio;
import Entidades.TipoConta2;
import conta.entidadesBanco.Usuario;
import hibernate.HibernateUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author User
 */
//@Named(value = "login")
@ManagedBean(name= "login")
public class AcessLogin implements Serializable {
    private Usuario user = new Usuario();
    private List<Usuario> listUser = new ArrayList<>();
    private String cpf;
    private String senha;
    private StringBuilder sql;
    private SessionFactory fabrica;
    private Session sessao;
    
 //   private final Repositorio DAO = new Repositorio();
    /**
     * Creates a new instance of AcessLogin
     */
    public AcessLogin() {
    }

    public void fazerLogin(){
        sql = new StringBuilder("select ge from conta.entidadesBanco.Usuario ge ")
                .append("where ge.cpf = '").append(cpf).append("' and ge.senha = '").append(senha).append("'");
        try {
            fabrica = HibernateUtil.getSessionFactory();
            sessao = fabrica.openSession();
//            sessao.getTransaction().begin();
//            <<<<<---------->>>>
//            sessao.getTransaction().commit();
            listUser = sessao.createQuery(sql.toString()).list();            
            sessao.close();
            
            if(listUser == null ? true : listUser.isEmpty()){
                FacesContext.getCurrentInstance().addMessage(null, 
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "usuário ou senha incorreto", ""));
                return;
            }
            user = listUser.get(0);
            FacesContext.getCurrentInstance().addMessage(null, 
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Bem vindo, " + user.getNome(), ""));
            
        } catch (HibernateException ex) {
            Logger.getLogger(AcessLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch(Exception ex){
            Logger.getLogger(AcessLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
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
    
}
