package com.CapTrac.SpringApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ViewController {

	@RequestMapping("/")
	@ResponseBody
	public String main() {

		return "Main page";
	}

	@RequestMapping("/loginpage")
	public String login() {

		return "login.jsp";
	}

	@RequestMapping("/welcomepage")
	public String welcome() {

		return "Welcome.jsp";
	}

	
	  @RequestMapping("/registerpage") 
	  public String register() {
	  
	  return "Register.jsp"; 
	  }
	 

	@RequestMapping("/changepage")
	public String changepwd() {

		return "ChangePWD.jsp";
	}
}
