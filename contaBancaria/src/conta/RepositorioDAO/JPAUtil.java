/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conta.RepositorioDAO;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author User
 */
public class JPAUtil {
    
//    private static final String PERSISTENCE_UNIT = "contaBancariaPU";    
    //private final Map<String, String> properties = new HashMap();
    
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gerenciador_contas_bancarias");
    
//    public JPAUtil(){ 
//       // getProperties();
//    }
    
//    public final Map<String, String> getProperties(){
//        properties.put("javax.persistence.jdbc.url", "jdbc:mysql://localhost:3306/gerenciador_contas_bancarias?zeroDateTimeBehavior=convertToNull");
//        properties.put("javax.persistence.jdbc.user", "root");
//        properties.put("javax.persistence.jdbc.driver", "com.mysql.jdbc.Driver");
//        properties.put("javax.persistence.jdbc.password", "root");
//        properties.put("hibernate.cache.provider_class", "org.hibernate.cache.NoCacheProvider");
//        properties.put("javax.persistence.schema-generation.database.action", "create");
//        return properties;
//    }
    
    public static EntityManager getEntityManager(){
        return emf.createEntityManager();
    }
}
