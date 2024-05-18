package java.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Butil {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Consultas");
	
	public static EntityManager criarEntityManager() {
		return emf.createEntityManager();
	}
    
}
