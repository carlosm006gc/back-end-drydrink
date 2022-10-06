package com.dev.drydrink.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.drydrink.domain.Funcionario;
import com.dev.drydrink.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	public Funcionario inserir(Funcionario funcionario) {
		Funcionario funcionarioNovo = funcionarioRepository.save(funcionario);
		return funcionarioNovo;
	}

	public Funcionario alterar(Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}

	public void excluir(Long id) {
		Funcionario funcionario = funcionarioRepository.findById(id).get();
		funcionarioRepository.delete(funcionario);
	}
}
