package com.dev.drydrink.services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.dev.drydrink.entities.Bebida;
import com.dev.drydrink.entities.Catalogo;

public class Pedidos implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long id;

	private List<Bebida> bebidas = new ArrayList<>();

	private Catalogo catalogo;

	public Pedidos() {
		super();
	}

	public Pedidos(Long id, List<Bebida> bebidas) {
		super();
		this.id = id;
		this.bebidas = bebidas;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Bebida> getBebidas() {
		return bebidas;
	}

	public void setBebidas(List<Bebida> bebidas) {
		this.bebidas = bebidas;
	}

	public Catalogo getCatalogo() {
		return catalogo;
	}

	public void setCatalogo(Catalogo catalogo) {
		this.catalogo = catalogo;
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
		Pedidos other = (Pedidos) obj;
		return Objects.equals(id, other.id);
	}

}