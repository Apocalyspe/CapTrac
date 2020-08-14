package com.CapTrac.SpringApp.service;


import com.CapTrac.SpringApp.model.UserExpenseInfo;
import com.CapTrac.SpringApp.model.UserExpenseInfoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Component
public class UserExpenseInfoService {

    @Autowired
    RestTemplate restTemplate = new RestTemplate();

    public void postUserExpense(UserExpenseInfo userExpenseInfo, Long userID) {
        System.out.println("maar gaya re!!!");

        restTemplate.postForObject("http://Captrac-Backend/users/expenses/" + userID, userExpenseInfo, UserExpenseInfo.class);

    }

    public UserExpenseInfoList getUserExpenses(Long userID) {

        UserExpenseInfoList userExpenseInfoList = restTemplate.getForObject("http://Captrac-Backend/users/expenses/" + userID, UserExpenseInfoList.class);

        return userExpenseInfoList;
    }
}


