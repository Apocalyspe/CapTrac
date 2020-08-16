package com.CapTrac.SpringApp.service;


import com.CapTrac.SpringApp.model.UserExpenseInfo;
import com.CapTrac.SpringApp.model.UserExpenseInfoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Service
@Component
public class UserExpenseInfoService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private UserExpenseInfoService userexpenseinfoservice;

    public void postUserExpense(UserExpenseInfo userExpenseInfo, Long userID) {
        System.out.println("maar gaya re!!!");

        restTemplate.postForObject("http://Captrac-Backend/users/expenses/" + userID, userExpenseInfo, UserExpenseInfo.class);

    }

    public UserExpenseInfoList getUserExpenses(Long userID) {

        UserExpenseInfoList userExpenseInfoList = restTemplate.getForObject("http://Captrac-Backend/users/expenses/" + userID,
                UserExpenseInfoList.class);

        return userExpenseInfoList;
    }

    public Float getUserLastexpense(Long userID) {

        ModelAndView mv = new ModelAndView();

        try {

            /*Check if null by surrounding with try/catch... If null set total expense as number 0*/
            UserExpenseInfoList userExpenseInfoList = userexpenseinfoservice.getUserExpenses(userID);
            List<UserExpenseInfo> list = userExpenseInfoList.getUserExpenseInfoList();
            UserExpenseInfo userExpenseInfo = list.get(list.size() - 1);

            Float totalexpense = userExpenseInfo.getTotalexpense();

            System.out.println("HI Im in settotalexpense");

            return totalexpense;

        } catch (Exception e) {
            System.out.println("HI Im in settotalexpense");
            return 0.00f;
        }

    }
}


