package br.com.aplrm.aplrm.entities;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name="tb_categoria")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	
	@ManyToMany(mappedBy="categorias")
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
