package hibernate;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import conta.entidadesBanco.ChavesPix;
import conta.entidadesBanco.Conta;
import conta.entidadesBanco.TipoConta;
import conta.entidadesBanco.Usuario;
import java.io.File;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author User
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            File file = new File("C:\\Users\\User\\OneDrive\\Área de Trabalho\\Atividades da faculdade\\3semestre\\POO1\\AplicacaoBancaria\\aplicacaoBancaria\\src\\java\\hibernate\\hibernate.cfg.xml");            
            sessionFactory = new AnnotationConfiguration().addAnnotatedClass(TipoConta.class)
                    .addAnnotatedClass(Conta.class)
                    .addAnnotatedClass(Usuario.class)
                    .addAnnotatedClass(ChavesPix.class)
                    .configure(file).buildSessionFactory();
        } catch (HibernateException ex) {
            // Log the exception. 
            System.err.println("Erro ao iniciar sessão." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
