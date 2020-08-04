package com.CapTrac.SpringApp.service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.CapTrac.SpringApp.model.UserExpenseInfoList;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.CapTrac.SpringApp.model.UserExpenseInfo;
import com.CapTrac.SpringApp.model.Users;

@Service
@SessionAttributes({"name", "userID"})
public class TransactionService {
	
	@Autowired
	private UserInfoService userinfoservice;
	
	@Autowired
	private UserExpenseInfoService userexpenseinfoservice;

	@Autowired
	private RestTemplate restTemplate;


	public ModelAndView addExpense(String timestamp, String expenseType, float amount,
								   String remark, HttpSession session) {
		
		ModelAndView mv = new ModelAndView();

		Long userID = (Long)session.getAttribute("userID");
		System.out.println(userID);
		Users user = userinfoservice.getUserInfo(userID);


		try {
			System.out.println("In try");
			String newTimestamp = timestamp.replace("T", " ");
			System.out.println(newTimestamp);														//checkpoint

			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			Date parseDate = dateFormat.parse(newTimestamp);
			Timestamp ts = new Timestamp(parseDate.getTime());
			System.out.println(ts);																	//checkpoint

			UserExpenseInfoList userExpenseInfoList = userexpenseinfoservice.getUserExpenses(userID);

			if(userExpenseInfoList.getUserExpenseInfo()==null) {
				//Setting the transaction ID
				String transacid = "CT" + ts + "8595";

				System.out.println("In if statement");
				//checkpoint
				//Creating a POJO and posting along with userID
				List<UserExpenseInfo> expenseInfoList = new ArrayList<>();

				UserExpenseInfo usr = new UserExpenseInfo();
				usr.setAmount(amount);
				usr.setExpenseType(expenseType);
				usr.setRemark(remark);
				usr.setTransacid(transacid);
				usr.setTimestamp(ts);
				usr.setUser(user);

				expenseInfoList.add(usr);
				userExpenseInfoList.setUserExpenseInfo(expenseInfoList);
				System.out.println(expenseInfoList);
				System.out.println(userExpenseInfoList);
				userexpenseinfoservice.postUserExpense(expenseInfoList,userID);

			}else {
				//Setting the transaction ID
				String transacid = "CT" + ts + "8596";

				//Creating a POJO and posting along with userID
				List<UserExpenseInfo> expenseInfoList = new ArrayList<>();
				UserExpenseInfo usr = new UserExpenseInfo();
				usr.setAmount(amount);
				usr.setExpenseType(expenseType);
				usr.setRemark(remark);
				usr.setTransacid(transacid);
				usr.setTimestamp(ts);
				usr.setUser(user);

				expenseInfoList.add(usr);
				userExpenseInfoList.setUserExpenseInfo(expenseInfoList);
				System.out.println(expenseInfoList);
				System.out.println(userExpenseInfoList);
				userexpenseinfoservice.postUserExpense(expenseInfoList,userID);

			}

		} catch (ParseException parseException) {
			mv.addObject("message", "Expense cannot be added");
			System.out.println("In catch statement");
			mv.setViewName("Welcome.jsp");
			System.out.println("Exception :" + parseException);
			return null;
		}

		System.out.println("In the end");
		mv.addObject("message", "Expense added Successfully");
		mv.setViewName("Welcome.jsp");


		return mv;
	}
	
	

}
