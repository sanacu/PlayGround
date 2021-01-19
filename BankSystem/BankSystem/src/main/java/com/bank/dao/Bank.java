package com.bank.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bank {
	private Long id;
	private String name;
	private double credit ;
	private double debit;


	public Bank() {
	}

	protected Bank(Long id, String name, double credit , double debit) {
		super();
		this.id = id;
		this.name = name;
		this.credit  = credit ;
		this.debit = debit;
	
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCredit() {
		return credit ;
	}

	public void setCredit(double credit ) {
		this.credit  = credit ;
	}

	public double getDebit() {
		return debit;
	}

	public void setDebit(double debit) {
		this.debit = debit;
	}


}
