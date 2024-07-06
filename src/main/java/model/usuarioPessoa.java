package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity//vai gerar a tabela no banco de dados
@NamedQueries({//aula 27.19
	
	@NamedQuery(name = "usuarioPessoa.todos", query = "select u from usuarioPessoa u"),
	@NamedQuery(name = "usuarioPessoa.buscarPorNome", query = "select u from usuarioPessoa u where u.nome = :nome")
})
public class usuarioPessoa {
	
	@Id//gera o primary key
	@GeneratedValue(strategy = GenerationType.AUTO)//vai gerar a sequencia para todos os registros
	private Long id;
	private String nome;
	private String sobrenome;
	private String email;
	private String login;
	private int idade;
	
	//um para muitos - um usuario tem muitos telefones
	@OneToMany(mappedBy = "usuarioPessoa", fetch = FetchType.EAGER)
	private List<TelefoneUser> TelefoneUsers;//aula 27.19
	
	
	
	public List<TelefoneUser> getTelefoneUsers() {
		return TelefoneUsers;
	}
	public void setTelefoneUsers(List<TelefoneUser> telefoneUsers) {
		TelefoneUsers = telefoneUsers;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	@Override
	public String toString() {
		return "usuarioPessoa [id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + ", email=" + email
				+ ", login=" + login + ", idade=" + idade + "]";
	}
	
	
	
	

}
