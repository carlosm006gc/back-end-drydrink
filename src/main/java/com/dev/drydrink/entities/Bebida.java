package com.dev.drydrink.entities;

import java.util.Objects;

public class Bebida {
	
	private Long id;
	private String descricao;
	private Double preco;
	private Boolean status;
	
	public Bebida() {
		super();
	}

	public Bebida(Long id, String descricao, Double preco, Boolean status) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.preco = preco;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bebida other = (Bebida) obj;
		return Objects.equals(id, other.id);
	}


}

