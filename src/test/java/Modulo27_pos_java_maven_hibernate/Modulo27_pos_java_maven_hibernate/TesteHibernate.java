package Modulo27_pos_java_maven_hibernate.Modulo27_pos_java_maven_hibernate;

import java.util.List;

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
		pessoa.setNome("axl");
		pessoa.setSobrenome("rose");
		pessoa.setEmail("axl@hotmail.com");
		
		daoGeneric.salvar(pessoa);
	}
	
	@Test
	public void testeBuscar() {//consultando
		DaoGeneric<usuarioPessoa> daoGeneric = new DaoGeneric<usuarioPessoa>();
		usuarioPessoa pessoa = new usuarioPessoa();
		pessoa.setId(1L);
		
		pessoa  = daoGeneric.pesquisar(pessoa);
		
		System.out.println(pessoa);
		
	}
	
	@Test
	public void testeUpdate() {
		DaoGeneric<usuarioPessoa> daoGeneric = new DaoGeneric<usuarioPessoa>();
		usuarioPessoa pessoa = daoGeneric.pesquisar(1L, usuarioPessoa.class);
		
		pessoa.setIdade(99);
		pessoa.setNome("Nome atualizado Hibernate");
		pessoa.setLogin("999");
		
		pessoa = daoGeneric.updateMerge(pessoa);
		
		System.out.println(pessoa);
	}
	
	@Test
	public void testeDelete() {
		DaoGeneric<usuarioPessoa> daoGeneric = new DaoGeneric<usuarioPessoa>();
		
		usuarioPessoa pessoa = daoGeneric.pesquisar(2L, usuarioPessoa.class);
		
		daoGeneric.deletarPorId(pessoa);
		
	}
	
	@Test
	public void testeConsultar() {//aula 27.14
		DaoGeneric<usuarioPessoa> daoGeneric = new DaoGeneric<usuarioPessoa>();
		
		List<usuarioPessoa> list = daoGeneric.listar(usuarioPessoa.class);
		
		for (usuarioPessoa usuarioPessoa : list) {
			System.out.println(usuarioPessoa);
			System.out.println("------------------------------------------------------------");
		}
		
	}

}
