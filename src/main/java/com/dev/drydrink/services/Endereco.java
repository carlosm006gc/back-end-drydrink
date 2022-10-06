package com.dev.drydrink.services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.dev.drydrink.domain.Cliente;


public class Endereco implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String cep;
	private String cidade;
	private String bairro;
	private String numero;
	private String logradouro;
	private String complemento;
	
	private List<Cliente> clientes = new ArrayList<>();

	public Endereco() {
	}

	public Endereco(Long id, String cep, String cidade, String bairro, String numero, String logradouro, String complemento) {
		super();
		this.id = id;
		this.cep = cep;
		this.cidade = cidade;
		this.bairro = bairro;
		this.numero = numero;
		this.logradouro = logradouro;
		this.complemento = complemento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
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
		Endereco other = (Endereco) obj;
		return Objects.equals(id, other.id);
	}
}