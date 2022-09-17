package com.project.dsmeta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.dsmeta.entities.Sale;

//Responsavel por acessar o banco
public interface SaleRepository extends JpaRepository<Sale, Long>{

}
