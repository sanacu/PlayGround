package com.bank.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bank_info")
public class bankInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idBank", nullable = false, length = 11)
	private long id;
	
	@Column(name = "Bank" , nullable = false)
	private String bank;
	
	@Column(name = "Crebit_Card_Count" , nullable = false)
	private long crebitCardCount;
	
	@Column(name = "Debit_Card_Count")
	private long debitCardCount;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public long getCrebitCardCount() {
		return crebitCardCount;
	}

	public void setCrebitCardCount(long crebitCardCount) {
		this.crebitCardCount = crebitCardCount;
	}

	public long getDebitCardCount() {
		return debitCardCount;
	}

	public void setDebitCardCount(long debitCardCount) {
		this.debitCardCount = debitCardCount;
	}
	
}