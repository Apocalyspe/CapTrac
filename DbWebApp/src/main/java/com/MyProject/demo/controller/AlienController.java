package com.MyProject.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.MyProject.demo.dao.AlienRepo;
import com.MyProject.demo.model.Alien;

@Controller
public class AlienController {

	@Autowired
	AlienRepo repo;
	
	@RequestMapping
	public String home() {
		
		return "home.jsp";
	}
	
	@RequestMapping("/addAlien")
	public String addAlien(Alien alien) {
		
		repo.save(alien);
		return "home.jsp";
	}
	
	@RequestMapping("/getAlien")
	public ModelAndView getAlien(@RequestParam("aid") int id) {
		
		ModelAndView mv = new ModelAndView("ShowAlien.jsp");
		Alien alien = repo.findById(id).orElse(null);
		mv.addObject(alien);
		return mv;
		
	}
}
