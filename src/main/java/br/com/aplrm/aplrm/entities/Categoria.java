package br.com.aplrm.aplrm.entities;

import jakarta.persistence.*;

import java.util.*;

@Entity/*Mapeia esta Entidade*/
@Table(name="tb_categoria")/*Permite customizar o nome da entidade na tabela*/
public class Categoria {

	@Id/*é usada para marcar uma propriedade de uma entidade como a chave primária.*/
	@GeneratedValue(strategy = GenerationType.IDENTITY)/*especifica como a chave primária de uma
	entidade será gerada automaticamente pelo banco de dados*/
	private Integer id;
	private String nome;
	
	@ManyToMany(mappedBy="categorias")/*é usada para definir um relacionamento muitos para muitos
	entre duas entidades, onde a entidade atual (categoria neste caso) não é a entidade proprietária
	do relacionamento.*/
	private Set<Produto> produtos=new HashSet<>();

	public Categoria(){}
	public Categoria(Integer id, String nome) {
		
		this.id = id;
		this.nome = nome;
		
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

	public Set<Produto> getProduto() {
		return produtos;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Categoria categoria = (Categoria) o;
		return Objects.equals(id, categoria.id);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}
}
