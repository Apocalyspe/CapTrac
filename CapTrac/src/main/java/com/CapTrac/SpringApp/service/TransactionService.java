package com.CapTrac.SpringApp.service;

import com.CapTrac.SpringApp.model.UserExpenseInfo;
import com.CapTrac.SpringApp.model.UserExpenseInfoList;
import com.CapTrac.SpringApp.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@SessionAttributes({"name", "userID"})
public class TransactionService {

    @Autowired
    private UserInfoService userinfoservice;

    @Autowired
    private UserExpenseInfoService userexpenseinfoservice;


    public ModelAndView addExpense(String timestamp, String expenseType, float amount,
                                   String remark, HttpSession session) {

        ModelAndView mv = new ModelAndView();

        Long userID = (Long) session.getAttribute("userID");
        System.out.println(userID);
        Users user = userinfoservice.getUserInfo(userID);


        try {

            //Database storage object - SQLTime
            String newTimestamp = timestamp.replace("T", " ");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Date parseDate = dateFormat.parse(newTimestamp);
            Timestamp SQLTime = new Timestamp(parseDate.getTime());

            //TransacId storage object - CurrentTime
            Timestamp ts = new Timestamp(System.currentTimeMillis());
            String CurrentTime = new SimpleDateFormat("yyyyMMddHHmmss").format(ts);

            /* Making a call to get user transaction details if any */
            UserExpenseInfoList userExpenseInfoList = userexpenseinfoservice.getUserExpenses(userID);

            //Setting the transaction ID
            String transacid = "CT" + CurrentTime;

            if (userExpenseInfoList.getUserExpenseInfoList() == null) {

                Float totalexpense = 0f;

                if (expenseType == "Debit") {
                    totalexpense -= amount;
                } else if (expenseType == "Credit") {
                    totalexpense += amount;
                }

                if (totalexpense < 0) {
                    mv.addObject("totalexpense", "<p3 style=\"color: red;\">" + totalexpense + "</p3>");
                } else if (totalexpense > 0) {
                    mv.addObject("totalexpense", "<p3 style=\"color: green;\">" + totalexpense + "</p3>");
                } else {
                    mv.addObject("totalexpense", "<p3 style=\"color: red;\">" + 0 + "</p3>");
                }

                //Creating a POJO and posting along with userID
                UserExpenseInfo usr = new UserExpenseInfo(transacid, expenseType, amount, remark, SQLTime, totalexpense, user);

                //Posting the transaction
                userexpenseinfoservice.postUserExpense(usr, userID);

            } else {

                //Creating a POJO and posting along with userID
                Float totalexpense = userexpenseinfoservice.getUserLastexpense(userID);

                System.out.println(totalexpense);

                if (expenseType.equals("Debit")) {
                    totalexpense -= amount;
                    System.out.println(totalexpense);
                } else if (expenseType.equals("Credit")) {
                    totalexpense += amount;
                    System.out.println(totalexpense);
                }

                System.out.println(amount);
                System.out.println(totalexpense);

                if (totalexpense < 0) {
                    mv.addObject("totalexpense", "<p3 style=\"color: red;\">Your net outlay" + -(totalexpense) + "</p3>");

                } else if (totalexpense > 0) {
                    mv.addObject("totalexpense", "<p3 style=\"color: green;\">Your net gain" + totalexpense + "</p3>");

                } else {
                    mv.addObject("totalexpense", "<p3>" + 0 + "</p3>");

                }

                //Expense POJO
                UserExpenseInfo usr = new UserExpenseInfo(transacid, expenseType, amount, remark, SQLTime, totalexpense, user);

                userexpenseinfoservice.postUserExpense(usr, userID);

            }

        } catch (ParseException parseException) {
            mv.addObject("message", "Expense cannot be added");
            System.out.println("In catch statement");
            mv.setViewName("Welcome.jsp");
            System.out.println("Exception :" + parseException);
            return null;
        }

        mv.addObject("message", "Expense added Successfully");
        mv.setViewName("Welcome.jsp");
        System.out.println("In the end");
        return mv;
    }


}
