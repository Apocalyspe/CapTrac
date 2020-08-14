package com.CapTrac.SpringApp.service;

import com.CapTrac.SpringApp.model.UserExpenseInfo;
import com.CapTrac.SpringApp.model.UserExpenseInfoList;
import com.CapTrac.SpringApp.model.Users;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
            String CurrentTime = new SimpleDateFormat("yyyyMMddHHmmss").format(timestamp);

            UserExpenseInfoList userExpenseInfoList = userexpenseinfoservice.getUserExpenses(userID);

            //Setting the transaction ID
            String transacid = "CT" + CurrentTime;

            List<UserExpenseInfo> expenseInfoList = new ArrayList<>();

            if (userExpenseInfoList.getUserExpenseInfoList() == null) {

                //Creating a POJO and posting along with userID
                UserExpenseInfo usr = new UserExpenseInfo();
                usr.setAmount(amount);
                usr.setExpenseType(expenseType);
                usr.setRemark(remark);
                usr.setTransacid(transacid);
                usr.setTimestamp(SQLTime);
                usr.setUser(user);
                usr.setTotalexpense(amount);

                expenseInfoList.add(usr);
                userExpenseInfoList.setUserExpenseInfoList(expenseInfoList);

                //Response JSON checkpoint
                System.out.println(expenseInfoList);

                userexpenseinfoservice.postUserExpense(usr, userID);

            } else {

                //Creating a POJO and posting along with userID
                JSONObject jsonObject = new JSONObject(userExpenseInfoList.toString());
                JSONArray jsonArray = new JSONArray("userExpenseInfo");

                JSONObject ListJsonObject = jsonArray.getJSONObject(jsonArray.length() - 1);
                Float totalexpense = (Float) ListJsonObject.get("totalexpense");
                System.out.println(totalexpense);

                if (expenseType == "Debit") {
                    totalexpense += amount;
                } else if (expenseType == "Credit") {

                }

                UserExpenseInfo usr = new UserExpenseInfo();
                usr.setAmount(amount);
                usr.setExpenseType(expenseType);
                usr.setRemark(remark);
                usr.setTransacid(transacid);
                usr.setTimestamp(SQLTime);
                usr.setUser(user);

                expenseInfoList.add(usr);
                userExpenseInfoList.setUserExpenseInfoList(expenseInfoList);
                System.out.println(expenseInfoList);
                System.out.println(userExpenseInfoList);
                userexpenseinfoservice.postUserExpense(usr, userID);

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
