package com.bank.servicelmpl;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.dao.Bank;

public interface BankServicelmpl extends JpaRepository<Bank, Long> {

}
