package com.CapTrac.SpringApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.CapTrac.SpringApp.model.Users;

@Service
@Component
public class UserInfoService {
	
	@Autowired
	RestTemplate restTemplate = new RestTemplate();
	
	public Users getUserInfo(Long userID) {

		System.out.println("in getuserinfo service");
		System.out.println(userID);

		Users jsonUser = restTemplate.getForObject("http://Captrac-Backend/users/" + userID, Users.class);
		Users user = new Users(jsonUser.getUserID(), jsonUser.getUsername(), jsonUser.getPassword(), jsonUser.getEmail());

		return user;
	}
}
