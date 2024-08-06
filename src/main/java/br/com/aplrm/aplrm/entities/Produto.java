package br.com.aplrm.aplrm.entities;

import br.com.aplrm.aplrm.dto.ProdutoDTO;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
@Entity
@Table(name="tb_produto")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;

	private Double preco;
	@Column(columnDefinition = "TEXT")
	private String descricao;
	private String imgUrl;



	@ManyToMany
	@JoinTable(name="tb_produto_categoria",joinColumns = @JoinColumn(name="produto_id"),
	inverseJoinColumns = @JoinColumn(name = "categoria_id"))
	private Set<Categoria> categorias=new HashSet<>();

	@OneToMany(mappedBy = "id.produto")
	private Set<PedidoItem> items=new HashSet<>();

	public Produto(){

	}

	public Produto(Integer id, String nome, String descricao, String imgUrl,Double preco) {
		this.id = id;
		this.nome = nome;
		this.preco=preco;
		this.descricao = descricao;
		this.imgUrl = imgUrl;
	}

    public Produto(ProdutoDTO dto) {
		this.id = dto.getId();
		this.nome = dto.getNome();
		this.preco=dto.getPreco();
		this.descricao = dto.getDescricao();
		this.imgUrl = dto.getImgUrl();
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
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public Double getPreco() {	return preco;}
	public void setPreco(Double preco) {this.preco = preco;	}

	public Set<PedidoItem> getItems(){return items;}
	public List<Pedido> getPedidos(){return items.stream().map(x->x.getPedido()).toList();}

	public Set<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(Set<Categoria> categorias) {
		this.categorias = categorias;
	}

	@Override
	public String toString() {
		return 	"[nome= '" + nome + '\'' +
				", preco= " + preco +
				", descricao= '" + descricao + '\'' +
				", imgUrl= '" + imgUrl + '\''+"]";
	}
}
