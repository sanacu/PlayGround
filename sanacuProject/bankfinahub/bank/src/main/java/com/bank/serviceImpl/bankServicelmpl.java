package com.bank.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bank.dao.bankDAO;
//import com.bank.dao.BasicFeeDetailsDAO;
import com.bank.domain.bankInfo;
import com.bank.service.bankService;


@Service(value = "bankService")
public class bankServicelmpl implements bankService{
	@Autowired
	private bankDAO bankDAO;
	public List<Object[]> findBankInfo() {
		 return bankDAO.getBankInfo();		
		
	}
	@Override
	public String savebankDetails(String bankInfo) {
		return bankDAO.saveInBankInfo(bankInfo);	
	}
}
