package com.CapTrac.SpringApp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

import com.CapTrac.SpringApp.model.UserModel;
import com.CapTrac.SpringApp.repo.UserRepo;

@Controller
public class CaptracController {

	@Autowired
	UserRepo repo;	
	
	@RequestMapping("/")
	public String home() {
		
		return "index.jsp";
	}
	
	@RequestMapping("/addexpense")
	public String AddExpense() {
				
		return "ExpenseAdd.jsp";
	}
	
	@RequestMapping("/submitexpense")
	public String SaveExpense(UserModel model, HttpSession session) {
		
		
		repo.save(model);
		System.out.println(model.getAmount());
		System.out.println(model.getExpenseType());
		System.out.println(model.getAccountid());
		
				
		return "ExpenseAdd.jsp";
	}
}
