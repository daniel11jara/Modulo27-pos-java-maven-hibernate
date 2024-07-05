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
	
	public E updateMerge(E entidade) {//salvando ou atualiza os dados
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		E entidadeSalva = entityManager.merge(entidade);//salva no banco e retorna
		transaction.commit();//salvando
		
		return entidadeSalva;
	}
	
	public E pesquisar (E entidade) {
		Object id = HibernateUtil.getPrimaryKey(entidade);
		
		E e = (E) entityManager.find(entidade.getClass(), id);
		
		return e;
	}
	
	public E pesquisar (Long id, Class<E> entidade) {
			
		E e = (E) entityManager.find(entidade, id);
		
		return e;
	}
	
	public void deletarPorId(E entidade) {
		Object id = HibernateUtil.getPrimaryKey(entidade);//identificando por id
		
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();//dando o start
		
		entityManager.createNativeQuery("delete from " + entidade.getClass().getSimpleName().toLowerCase() + " where id = " + id).executeUpdate();//deletando
		
		transaction.commit();//grava alteração 
		
	}

}
