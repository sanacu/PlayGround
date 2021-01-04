package com.bank.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bank.domain.bankInfo;
@Repository
public interface bankDAO extends JpaRepository<bankInfo ,Integer>{



		@Query(value = "{call getBankInfo()}", nativeQuery = true)
		List<Object[]> getBankInfo();

		
    	@Query(value = "{call saveInBankInfo(:bankInfo)}", nativeQuery = true)
 	 String saveInBankInfo(@Param("bankInfo") String bankInfo);
	
		
		
	}


