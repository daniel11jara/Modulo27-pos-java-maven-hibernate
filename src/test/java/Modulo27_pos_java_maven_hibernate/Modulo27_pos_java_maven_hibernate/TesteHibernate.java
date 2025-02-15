package Modulo27_pos_java_maven_hibernate.Modulo27_pos_java_maven_hibernate;

import java.util.List;

import org.junit.Test;

import dao.DaoGeneric;
import model.TelefoneUser;
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
	
	@Test
	public void testeQueryList() {//aula 27.15
		DaoGeneric<usuarioPessoa> daoGeneric = new DaoGeneric<usuarioPessoa>();
		
		List<usuarioPessoa> list = daoGeneric.getEntityManager().createQuery(" from usuarioPessoa where nome = 'axl'").getResultList();//carregando apenas um nome da lista
		
		for (usuarioPessoa usuarioPessoa : list) {
			System.out.println(usuarioPessoa);
		}
	}
	
	@Test
	public void testeQueryListMaxResult() {//aula 27.16 - ordenando quantidade especifica de resultados - setMaxResul()
		DaoGeneric<usuarioPessoa> daoGeneric = new DaoGeneric<usuarioPessoa>();
		
		List<usuarioPessoa> list = daoGeneric.getEntityManager().createQuery(" from usuarioPessoa order by id").setMaxResults(2).getResultList();//carregando apenas um nome da lista
		
		for (usuarioPessoa usuarioPessoa : list) {
			System.out.println(usuarioPessoa);
		}
	}
	
	@Test
	public void testeQueryListParameter() {//aula 27.17 - trazendo um nome através de parâmetros - colocando um nome ou sobrenome
		DaoGeneric<usuarioPessoa> daoGeneric = new DaoGeneric<usuarioPessoa>();
		
		List<usuarioPessoa> list = daoGeneric.getEntityManager().createQuery(" from usuarioPessoa where nome or sobrenome = : sobrenome").setParameter("nome", "bill").setParameter("sobrenome", "Gates").getResultList();
		
		for (usuarioPessoa usuarioPessoa : list) {
			System.out.println(usuarioPessoa);
		}
	}
	
	@Test
	public void testeQuerySomarIdade() {//aula 27.18
		DaoGeneric<usuarioPessoa> daoGeneric = new DaoGeneric<usuarioPessoa>();
		
		Long somaIdade = (Long) daoGeneric.getEntityManager().createQuery("select sum(u.idade) from usuarioPessoa u").getSingleResult();//somando todas as idades
		
		System.out.println(somaIdade);
	}
	
	@Test
	public void testeNameQuery1() {//aula 27.19 - listando todos
		DaoGeneric<usuarioPessoa> daoGeneric = new DaoGeneric<usuarioPessoa>();
		
		List<usuarioPessoa> list = daoGeneric.getEntityManager().createNamedQuery("usuarioPessoa.todos").getResultList();
		
		for (usuarioPessoa usuarioPessoa : list) {
			System.out.println(usuarioPessoa);
		}
		
	}
	
	@Test
	public void testeNameQuery2() {//aula 27.19 - buscando por nome
		DaoGeneric<usuarioPessoa> daoGeneric = new DaoGeneric<usuarioPessoa>();
		
		List<usuarioPessoa> list = daoGeneric.getEntityManager().createNamedQuery("usuarioPessoa.buscarPorNome").setParameter("nome", "van").getResultList();
		
		for (usuarioPessoa usuarioPessoa : list) {
			System.out.println(usuarioPessoa);
		}
		
	}
	
	@Test
	public void testeGravaTelefone() {//aula 27.21
		DaoGeneric daoGeneric = new DaoGeneric();
		
		usuarioPessoa pessoa =  (usuarioPessoa) daoGeneric.pesquisar(3L, usuarioPessoa.class);
		TelefoneUser telefoneUser = new TelefoneUser();
		
		telefoneUser.setTipo("Casa");
		telefoneUser.setNumero("123-852");
		telefoneUser.setUsuarioPessoa(pessoa);
		
		daoGeneric.salvar(telefoneUser);
	}
	
	@Test
	public void testeConsultaelefones() {//aula 27.21
		DaoGeneric daoGeneric = new DaoGeneric();
		
		usuarioPessoa pessoa =  (usuarioPessoa) daoGeneric.pesquisar(3L, usuarioPessoa.class);
		
		for (TelefoneUser fone : pessoa.getTelefoneUsers()) {
			System.out.println(fone.getNumero());
			System.out.println(fone.getTipo());
			System.out.println(fone.getUsuarioPessoa().getNome());
			System.out.println("-----------------------------------------------");
		}
	}


}
