package Modulo27_pos_java_maven_hibernate.Modulo27_pos_java_maven_hibernate;

import org.junit.Test;

import dao.DaoGeneric;
import model.usuarioPessoa;

public class TesteHibernate {
	
	@Test
	public void testeHibernateUtil() {
		DaoGeneric<usuarioPessoa> daoGeneric = new DaoGeneric<usuarioPessoa>();
		
		usuarioPessoa pessoa = new usuarioPessoa();
		pessoa.setIdade(45);
		pessoa.setLogin("teste");
		pessoa.setNome("Bill");
		pessoa.setSobrenome("Gates");
		pessoa.setEmail("bill@hotmail.com");
		
		daoGeneric.salvar(pessoa);
	}

}
