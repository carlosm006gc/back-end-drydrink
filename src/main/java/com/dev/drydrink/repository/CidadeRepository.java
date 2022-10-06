package com.dev.drydrink.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dev.drydrink.domain.Cidade;

@Repository
@Transactional
public interface CidadeRepository extends CrudRepository<Cidade, Long> {
	
}
