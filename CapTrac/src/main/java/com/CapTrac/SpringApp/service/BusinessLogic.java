package com.CapTrac.SpringApp.service;


import java.text.SimpleDateFormat;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.CapTrac.SpringApp.model.CredentialManager;
import com.CapTrac.SpringApp.model.ExpenseModel;
import com.CapTrac.SpringApp.repo.ExpenseRepo;
import com.CapTrac.SpringApp.repo.UserRepo;

@Component
@SessionAttributes("name")
public class BusinessLogic {
	
	@Autowired
	UserRepo repo;
	
	@Autowired
	ExpenseRepo erepo;

	ExpenseModel emodel;

	
	
	public ModelAndView welset(CredentialManager creds, HttpSession session) {
		
		ModelAndView mv = new ModelAndView();
		System.out.println(session.getId());
		
		if(repo.existsByUsername(creds.getUsername())==true && repo.existsByPassword(creds.getPassword())==true) {
			mv.setViewName("Welcome.jsp");
			mv.addObject("name",creds.getUsername());
			
			CredentialManager cred = repo.findByUsername(creds.getUsername());
			
			session.setAttribute("accid", cred.getAccountid());
			
			
		}
		else {
			mv.setViewName("login.jsp");
			mv.addObject("message", "Login failed due to incorrect username or password");
		}
		
		return mv;
	}
	
	
	
	public ModelAndView SaveExpense(ExpenseModel model, HttpSession session, CredentialManager creds) {
		
		ModelAndView mv = new ModelAndView();
		
		//Getting Account ID
		
		int id = (int) session.getAttribute("accid");
		System.out.println(id);
		
		//Setting Transaction ID
		
		String tm = "CT" + id + new SimpleDateFormat("yyyyMMdd").format(model.getDate());
		model.setTransacid(tm);
		System.out.println(tm);
		
		//Saving in repo

		model.setTotalexpense(model.getAmount()+model.getTotalexpense());
		erepo.save(model);
		erepo.saveCredsaccountid(id,tm);
		System.out.println(model.getTotalexpense());
		
		
		
		
		mv.setViewName("Welcome.jsp");
		
		return mv; 
	}
	
	public ModelAndView Register(CredentialManager creds, HttpSession session) {
		
		ModelAndView mv = new ModelAndView();
		
		
		
		return mv; 
	}

	public ModelAndView ChangePassword(CredentialManager creds, HttpSession session) {
		
		return null;
	}
	
}
