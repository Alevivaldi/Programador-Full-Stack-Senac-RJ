package br.com.aplrm.aplrm.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity//@Entity mapeia a entidade User
@Table(name="tb_user")//Permite  customizar o nome da tabela no banco de dados
public class User {
	@Id/*é usada para marcar uma propriedade de uma entidade como a chave primária.*/
	@GeneratedValue(strategy =GenerationType.IDENTITY )/*especifica como a chave primária de uma
	entidade será gerada automaticamente pelo banco de dados*/
	private Integer id;
	private String nome;

	@Column(unique = true)/*Estou impedindo que o atributo email se repita no banco de dados*/
	private String email;

	private String telefone;
	private LocalDate dataNascimento;
	private String senha;
	//private String[] cargo;
	
	@OneToMany(mappedBy="cliente")/*relacionar um para muitos entre a classe cliente e pedido,
	o nome tem que ser o mesmo do atributo na outra tabela*/
	private List<Pedido> pedidos=new ArrayList<>();

	public User(){}
	public User(Integer id, String nome, String email, String telefone, LocalDate dataNascimento, String senha) {

		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
		this.senha = senha;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		User user = (User) o;
		return Objects.equals(id, user.id);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}
}
