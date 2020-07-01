package com.CapTrac.SpringApp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.CapTrac.SpringApp.model.CredentialManager;
import com.CapTrac.SpringApp.service.BusinessLogic;

@Controller
public class CaptracController {


	
	@Autowired
	BusinessLogic logic;
	
	
	@RequestMapping("/logged")
	public ModelAndView AddExpense(CredentialManager creds) {
		
		ModelAndView mv = logic.welset(creds);
			
		return mv;
	}
	
	/*
	 * @RequestMapping("/submitexpense") public String SaveExpense(ExpenseModel
	 * model, HttpSession session) {
	 * 
	 * 
	 * repo.save(model); System.out.println(model.getAmount());
	 * System.out.println(model.getExpenseType());
	 * 
	 * 
	 * return "ExpenseAdd.jsp"; }
	 */
	}
