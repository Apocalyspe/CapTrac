package com.CapTrac.SpringApp.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.CapTrac.SpringApp.model.UserExpenseInfo;
import com.CapTrac.SpringApp.model.Users;
import com.CapTrac.SpringApp.service.ApplicationService;
import com.CapTrac.SpringApp.service.TransactionService;

@Controller
@SessionAttributes("name")
public class CaptracController {

	
	
	@Autowired
	ApplicationService applicationService;

	@Autowired
	TransactionService transactionService;
	
	@RequestMapping("/login")
	public ModelAndView loginCheck(Users formUser, HttpSession session) {
		
		ModelAndView mv = applicationService.loginCheck(formUser, session);
		
		return mv;
	}
	
	
	@RequestMapping("/register")
	public ModelAndView registerUser(Users user) {
		
		ModelAndView mv = applicationService.registerUser(user);
		
		return mv;
	}
	
	
	  @RequestMapping("/changereq") 
	  public ModelAndView changePwd(Users users, HttpSession session) {
	  
	  ModelAndView mv = applicationService.changeReq(users, session);
	  
	  return mv; }
	 
	
	@RequestMapping("/checkuser")
	public ModelAndView verifyEmail(@RequestParam("userID") Long userID, HttpSession session) {
		
		ModelAndView mv = applicationService.verifyEmail(userID, session);
		
		return mv;
	}
	
	@RequestMapping("/addexpense")
	public ModelAndView addTrasaction(@RequestParam("timestamp") String timestamp, @RequestParam("ExpenseType") String expenseType,
									  @RequestParam("amount") float amount, @RequestParam("Remark") String remark,
									  HttpSession session) {
		
		ModelAndView mv = transactionService.addExpense(timestamp, expenseType, amount,remark, session);

		return mv;
	}
}

