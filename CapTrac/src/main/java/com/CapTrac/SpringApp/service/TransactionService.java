package com.CapTrac.SpringApp.service;

import java.sql.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.CapTrac.SpringApp.model.UserExpenseInfo;
import com.CapTrac.SpringApp.model.Users;

@Service
@SessionAttributes({"name","userID"})
public class TransactionService {
	
	@Autowired
	private static UserInfoService userinfoservice;
	
	@Autowired
	private static UserExpenseInfoService userexpenseinfoservice;
	

	public static ModelAndView addExpense(UserExpenseInfo userexpenseinfo, HttpSession session) {
		
		ModelAndView mv = new ModelAndView();
		
		Long userID = (Long)session.getAttribute("userID");
		System.out.println(userID);
		Users user = userinfoservice.getUserInfo(userID);
		
		try {
			UserExpenseInfo userexpense = 
					new UserExpenseInfo((String)userexpenseinfo.getTransacid(), (String)userexpenseinfo.getExpenseType(), (float)userexpenseinfo.getAmount(), 
							(String)userexpenseinfo.getRemark(), (Date)userexpenseinfo.getDate(), user);
			
			userexpenseinfoservice.postUserExpense(userexpense, userID);
			mv.addObject("message","Expense added");
			mv.setViewName("Welcome.jsp");
			
		} catch (Exception e) {
			mv.addObject("message","Cannot add expense");
			e.printStackTrace();
		}
		
		
		
		return mv;
	}
	
	

}
