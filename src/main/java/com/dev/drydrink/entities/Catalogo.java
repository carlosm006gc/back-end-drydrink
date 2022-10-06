package com.dev.drydrink.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Catalogo implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;
	private String descricao;
	private Boolean status;
	
	private List<Bebida> bebidas = new ArrayList<>();

	public Catalogo() {
		super();
	}

	public Catalogo(Long id, String descricao, Boolean status, List<Bebida> bebidas) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.status = status;
		this.bebidas = bebidas;
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

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public List<Bebida> getBebidas() {
		return bebidas;
	}

	public void setBebidas(List<Bebida> bebidas) {
		this.bebidas = bebidas;
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
		Catalogo other = (Catalogo) obj;
		return Objects.equals(id, other.id);
	}

	public Bebida buscarBebida(String descricao) {
		return null;
		
	}
}
