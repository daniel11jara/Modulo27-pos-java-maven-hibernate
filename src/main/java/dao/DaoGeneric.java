package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import Modulo27_pos_java_maven_hibernate.Modulo27_pos_java_maven_hibernate.HibernateUtil;

public class DaoGeneric<E> {
	
	private EntityManager entityManager = HibernateUtil.getEntityManager();
	
	public void salvar(E entidade) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(entidade);//persistindo
		transaction.commit();//salvando
	}

}
