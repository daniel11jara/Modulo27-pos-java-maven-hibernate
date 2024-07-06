package dao;

import java.util.List;

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
	
	public E updateMerge(E entidade) {//salvando ou atualiza os dados ao mesmo tempo
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		E entidadeSalva = entityManager.merge(entidade);//salva no banco e retorna
		transaction.commit();//salvando
		
		return entidadeSalva;
	}
	
	public E pesquisar (E entidade) { //pesquisar entidade passando a classe
		Object id = HibernateUtil.getPrimaryKey(entidade);
		
		E e = (E) entityManager.find(entidade.getClass(), id);
		
		return e;
	}
	
	public E pesquisar (Long id, Class<E> entidade) {//pesquisar passando o id e a entidade
			
		E e = (E) entityManager.find(entidade, id);
		
		return e;
	}
	
	public void deletarPorId(E entidade) {//deletar passando a entidade
		Object id = HibernateUtil.getPrimaryKey(entidade);//identificando por id
		
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();//dando o start
		
		entityManager.createNativeQuery("delete from " + entidade.getClass().getSimpleName().toLowerCase() + " where id = " + id).executeUpdate();//deletando
		
		transaction.commit();//grava alteração 
		
	}
	
	public List<E> listar(Class<E> entidade){//consultar todos retornando uma lista - aula 27.14
		EntityTransaction transaction = entityManager.getTransaction();//start na transação
		transaction.begin();
		
		List<E> lista = entityManager.createQuery("from " + entidade.getName()).getResultList();
		transaction.commit();//encerrando o processo
		return lista;
	}

}
