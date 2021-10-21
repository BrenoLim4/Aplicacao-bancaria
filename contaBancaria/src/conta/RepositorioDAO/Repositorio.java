package conta.RepositorioDAO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author User
 */

public class Repositorio {

    private final EntityManager en;
    private final JPAUtil jpa;
    
    public Repositorio() {
        jpa = new JPAUtil();
        en = jpa.getEntityManager();
    }

    public void salvar(Object obj){
        en.getTransaction().begin();        
        en.persist(obj);
        en.getTransaction().commit();        
    }

    public void excluir(Object obj) {
        en.getTransaction().begin();        
        en.remove(obj);
        en.getTransaction().commit();
    }

    public int update(String sql, Class<?> model) {
        en.getTransaction().begin();        
        int rowsAfecteds = en.createNativeQuery(sql, model).executeUpdate();
        en.getTransaction().commit();
        return rowsAfecteds;
    }

    public List<?> consultar(String sql, Class<?> model) {      
        return en.createNativeQuery(sql, model) == null ? 
                new ArrayList<>() : en.createNativeQuery(sql, model).getResultList();
    }

    public EntityManager getEntityManager() {
        return en;
    }
    
}
