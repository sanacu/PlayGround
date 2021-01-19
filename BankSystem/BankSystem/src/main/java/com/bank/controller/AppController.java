package com.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bank.dao.Bank;
import com.bank.service.BankService;

@Controller
public class AppController {

	@Autowired
	private BankService service; 
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<Bank> listBanks = service.listAll();
		model.addAttribute("listBanks", listBanks);
		
		return "index";
	}
	
	@RequestMapping("/new")
	public String newBankDetails(Model model) {
		Bank bank = new Bank();
		model.addAttribute("bank", bank);
		
		return "create_bank";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveBankDetails(@ModelAttribute("bank") Bank bank) {
		service.save(bank);
		
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditBankDetails(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit_bank");
		Bank bank = service.get(id);
		mav.addObject("bank", bank);
		
		return mav;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteBankDetails(@PathVariable(name = "id") int id) {
		service.delete(id);
		return "redirect:/";		
	}
}
