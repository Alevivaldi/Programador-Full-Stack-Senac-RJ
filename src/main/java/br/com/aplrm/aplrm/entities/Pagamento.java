package br.com.aplrm.aplrm.entities;

import jakarta.persistence.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name="tb_pagamento")
public class Pagamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	

	private LocalDateTime momento;
	
	@OneToOne
	@MapsId
	private Pedido pedido;

	public Pagamento(){}
	public Pagamento(Integer id, LocalDateTime momento, Pedido pedido) {
		this.id = id;
		this.momento = momento;
		this.pedido = pedido;
	}

	public LocalDateTime getMomento() {
		return momento;
	}

	public void setMomento(LocalDateTime momento) {
		this.momento = momento;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Pagamento pagamento = (Pagamento) o;
		return Objects.equals(id, pagamento.id);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}
}
