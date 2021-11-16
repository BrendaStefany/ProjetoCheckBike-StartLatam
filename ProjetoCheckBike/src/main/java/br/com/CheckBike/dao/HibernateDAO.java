package br.com.CheckBike.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.CheckBike.util.JPAUtil;

public class HibernateDAO<B> {

	public void salvar(B entidade) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin(); 
		entityManager.persist(entidade);
		entityTransaction.commit();
		entityManager.close();
	}
	
}
