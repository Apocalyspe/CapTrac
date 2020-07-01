package com.CapTrac.SpringApp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.CapTrac.SpringApp.model.CredentialManager;
import com.CapTrac.SpringApp.model.ExpenseModel;
import com.CapTrac.SpringApp.repo.ExpenseRepo;
import com.CapTrac.SpringApp.repo.UserRepo;

@Component
public class BusinessLogic {
	
	@Autowired
	UserRepo repo;
	
	@Autowired
	ExpenseRepo erepo;

	ExpenseModel emodel;

	public ModelAndView welset(CredentialManager creds) {
		
		ModelAndView mv = new ModelAndView();
		
		if(repo.existsByUsername(creds.getUsername())==true && repo.existsByPassword(creds.getPassword())==true) {
			mv.setViewName("Welcome.jsp");
			mv.addObject("name",creds.getUsername());
			
			Optional<ExpenseModel> expensemodel = erepo.findById(creds.getAccountid());
			if(expensemodel.isPresent()) {
				mv.addObject("TotalExpense", erepo.findByCreds(creds.getAccountid()));
			}
			/*
			 * try { if(erepo.findById(creds.getAccountid()).isPresent())
			 * mv.addObject("Balance", erepo.findById(creds.getAccountid())); else {
			 * emodel.setBalance(0); System.out.println(); mv.addObject("Balance", "0"); } }
			 * catch (Exception e) { // TODO Auto-generated catch block e.printStackTrace();
			 * }
			 */
		}
		else {
			mv.setViewName("login.jsp");
			mv.addObject("message", "Login failed due to incorrect username or password");
		}
		
		return mv;
	}
	
	
	
}
