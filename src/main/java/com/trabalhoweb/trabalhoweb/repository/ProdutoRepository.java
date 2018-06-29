package com.trabalhoweb.trabalhoweb.repository;

import org.springframework.data.repository.CrudRepository;

import com.trabalhoweb.trabalhoweb.models.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, String>{
	 
	Produto findById(long id);
}
