package com.CapTrac.SpringApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ViewController{
	
	@RequestMapping("/")
	@ResponseBody
	public String main() {
		
		return "Main page";
	}
	
	@RequestMapping("/login")
	public String login() {
		
		return "login.jsp";
	}
	
	
	@RequestMapping("/welcome")
	public String welcome() {
		
		return "Welcome.jsp";
	}
	
	/*
	 * @RequestMapping("/register") public String register() {
	 * 
	 * return "Register.jsp"; }
	 */
	
	@RequestMapping("/changepwd")
	public String changepwd() {
		
		return "ChangePWD.jsp";
	}
}
