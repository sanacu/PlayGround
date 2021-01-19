package com.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.dao.Bank;
import com.bank.servicelmpl.BankServicelmpl;

@Service
@Transactional
public class BankService {

	@Autowired
	private BankServicelmpl repo;
	
	public List<Bank> listAll() {
		return repo.findAll();
	}
	
	public void save(Bank product) {
		repo.save(product);
	}
	
	public Bank get(long id) {
		return repo.findById(id).get();
	}
	
	public void delete(long id) {
		repo.deleteById(id);
	}
}
