package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class util {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("revisaoPU");
	
	public static EntityManager criarEntityManager() {
		return emf.createEntityManager();
	}
    
}
