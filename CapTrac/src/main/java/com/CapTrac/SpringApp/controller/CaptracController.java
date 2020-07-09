package com.CapTrac.SpringApp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.CapTrac.SpringApp.model.CredentialManager;
import com.CapTrac.SpringApp.model.ExpenseModel;
import com.CapTrac.SpringApp.service.BusinessLogic;

@Controller
@SessionAttributes("name")
public class CaptracController {

	@Autowired
	BusinessLogic logic;

	@RequestMapping("/logged")
	public ModelAndView AddExpense(CredentialManager creds, HttpSession session) {
		
		
		ModelAndView mv = logic.welset(creds,session);

		return mv;
	}

	
	  @RequestMapping("/addexpense") 
	  public ModelAndView SaveExpense(ExpenseModel model, HttpSession session, CredentialManager creds) {
	   
	  ModelAndView mv = logic.SaveExpense(model, session, creds);
	  
	  
	  return mv; 
	 }
	 
	  @RequestMapping("/register")
		public ModelAndView Register(CredentialManager creds,HttpSession session) {

			ModelAndView mv = logic.Register(creds,session);

			return mv;
		}
	  
	  @RequestMapping("/changepass") 
	  public ModelAndView ChangePassword(CredentialManager creds,HttpSession session) {
	   
	  ModelAndView mv = logic.ChangePassword(creds, session);
	  
	  
	  return mv; 
	 }
	  
	  @RequestMapping("/logout")
		public String logout(HttpSession session) {
		
		session.invalidate();
		  
			return "logout.jsp";
		}
		
}

