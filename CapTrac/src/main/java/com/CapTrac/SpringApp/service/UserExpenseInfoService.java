package com.CapTrac.SpringApp.service;


import com.CapTrac.SpringApp.model.UserExpenseInfoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.CapTrac.SpringApp.model.UserExpenseInfo;

import java.util.List;

@Service
@Component
public class UserExpenseInfoService {
	
	@Autowired
	RestTemplate restTemplate = new RestTemplate();
	
	public void postUserExpense(List<UserExpenseInfo> userExpenseInfoList, Long userID) {
		System.out.println("maar gaya re!!!");
		
		restTemplate.postForObject("http://Captrac-Backend/users/expenses/" + userID, new UserExpenseInfoList(userExpenseInfoList), UserExpenseInfoList.class);

	}

	public UserExpenseInfoList getUserExpenses(Long userID){

		UserExpenseInfoList userExpenseInfoList =restTemplate.getForObject("http://Captrac-Backend/users/expenses/" + userID, UserExpenseInfoList.class);

		if(userExpenseInfoList.getUserExpenseInfo() == null){
			System.out.println("No contents in the List");
			return null;
		}else{
			return userExpenseInfoList;
		}
	}

}
