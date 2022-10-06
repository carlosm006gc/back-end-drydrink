package com.dev.drydrink.domain;

import com.dev.drydrink.entities.Bebida;

public class Distribuidora {

	private String nome;
	private String descricao;
	private String hrfuncionamento;

	private Bebida bebida;

	public Distribuidora() {
		super();
	}

	public Distribuidora(String nome, String descricao, String hrfuncionamento) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.hrfuncionamento = hrfuncionamento;
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

	public String getHrfuncionamento() {
		return hrfuncionamento;
	}

	public void setHrfuncionamento(String hrfuncionamento) {
		this.hrfuncionamento = hrfuncionamento;
	}

	public Bebida getBebida() {
		return bebida;
	}

	public void adicionarBebida(Bebida bebida) {
		bebida = new Bebida(null, null, 0.0, false);
	}

	public Boolean aprovarPedido(Long idPedido) {
		return true;
	}

	public void removerBebida(Bebida bebida) {
		bebida = new Bebida();
	}
	public void confirmarEntrega(Long idPedido) {
	}
	public void atualizarStatusPedido(Long idPedido) {
	}

}

