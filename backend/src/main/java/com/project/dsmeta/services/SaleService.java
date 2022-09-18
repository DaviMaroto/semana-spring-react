package com.project.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.project.dsmeta.entities.Sale;
import com.project.dsmeta.repositories.SaleRepository;

//Responsavel por fazer operações de negócios com as vendas
@Service
public class SaleService {
	
	@Autowired
	private SaleRepository repository;
	
	public Page<Sale> findSales(String minDate, String maxDate, Pageable pageable) {
		LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		
		LocalDate min = minDate.equals("")? today.minusDays(365) : LocalDate.parse(minDate);
		LocalDate max = maxDate.equals("")? today : LocalDate.parse(maxDate);//Expressão ternária
		
		return repository.findSales(min, max, pageable);
	}
}
