package Modulo27_pos_java_maven_hibernate.Modulo27_pos_java_maven_hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {
	
	public static EntityManagerFactory factory = null;
	
	static {
		init();
	}
	
	public static void init() {
		
		try {
			
			if (factory == null) {//fazendo a verificação para o arquivo ser lido apenas 1 vez
				factory = Persistence.createEntityManagerFactory("Modulo27-pos-java-maven-hibernate");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static EntityManager getEntityManager() {
		return factory.createEntityManager();//provem a parte da persistencia
	}

}
