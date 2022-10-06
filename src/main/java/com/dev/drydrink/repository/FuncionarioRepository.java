package com.dev.drydrink.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dev.drydrink.domain.Funcionario;

@Repository
@Transactional
public interface FuncionarioRepository extends CrudRepository<Funcionario, Long> {
	
}
