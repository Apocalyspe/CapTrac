package com.CapTrac.SpringApp.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.CapTrac.SpringApp.model.UserExpenseInfo;

@Service
@Component
public class UserExpenseInfoService {
	
	@Autowired
	RestTemplate restTemplate = new RestTemplate();
	
	public void postUserExpense(UserExpenseInfo userexpenseinfo, Long userID) {
		
		restTemplate.postForObject("http://localhost:8080/users/expenses/" + userID, userexpenseinfo, UserExpenseInfo.class);

	}

}
