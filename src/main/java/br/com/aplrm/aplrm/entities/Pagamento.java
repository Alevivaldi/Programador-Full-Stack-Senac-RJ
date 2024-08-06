package br.com.aplrm.aplrm.entities;

import jakarta.persistence.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity/*Mapeia esta Entidade*/
@Table(name="tb_pagamento")/*Permite customizar o nome da entidade na tabela*/
public class Pagamento {
	
	@Id/*é usada para marcar uma propriedade de uma entidade como a chave primária.*/
	@GeneratedValue(strategy = GenerationType.IDENTITY)/*especifica como a chave primária de uma
	entidade será gerada automaticamente pelo banco de dados*/
	private Integer id;
	
	//@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private LocalDateTime momento;
	
	@OneToOne/*é usada para estabelecer um relacionamento um para um entre duas entidades
	em um sistema de persistência de dados*/
	@MapsId/*é usada para mapear uma propriedade de uma entidade que representa uma chave
	estrangeira (foreign key) para o atributo de identificação (ID) de outra entidade.*/
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
