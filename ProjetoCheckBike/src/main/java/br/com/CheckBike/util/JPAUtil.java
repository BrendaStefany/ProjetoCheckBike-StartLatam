package br.com.CheckBike.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory factory;

	static {
		if (factory == null) {
			factory = Persistence.createEntityManagerFactory("ProjetoCheckBike");
		}
	}

	public static  EntityManager getEntityManager () {
		return factory.createEntityManager();
	}
	
}
