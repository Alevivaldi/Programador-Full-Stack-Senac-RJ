package br.com.aplrm.aplrm.entities;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name="tb_pedido_item")
public class PedidoItem {
	@EmbeddedId
	private PedidoItemPK id=new PedidoItemPK();
	private Integer quantidade;
	private Double preco;


	public PedidoItem() {
	}

	public PedidoItem(Pedido pedido, Produto produto, Integer quantidade, Double preco) {
		id.setPedido(pedido);
		id.setProduto(produto);
		this.quantidade = quantidade;
		this.preco = preco;
	}
	public Produto getProduto(){return id.getProduto();}
	public void setProduto(Produto produto){id.setProduto(produto);}
	public Pedido getPedido(){return id.getPedido();}
	public void setPedido(Pedido pedido){id.setPedido(pedido);}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		PedidoItem that = (PedidoItem) o;
		return Objects.equals(id, that.id);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}
}
























