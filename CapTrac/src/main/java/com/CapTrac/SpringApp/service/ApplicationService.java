package com.CapTrac.SpringApp.service;

import com.CapTrac.SpringApp.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Component
@Service
@SessionAttributes({"name", "userID"})
public class ApplicationService {

    @Autowired
    RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private UserInfoService userinfoservice;


    public ModelAndView loginCheck(Users formUser, HttpSession session) {

        ModelAndView mv = new ModelAndView();

        Users user = userinfoservice.getUserInfo(formUser.getUserID());


        try {
            if (user.getUserID().equals(formUser.getUserID()) && formUser.getPassword().equals(user.getPassword())) {
                System.out.println("I am in true condition");
                mv.setViewName("Welcome.jsp");
                session.setAttribute("name", user.getUsername());
                session.setAttribute("userID", user.getUserID());
                //mv.addObject("userID", user.getUserID());
                System.out.println(user.getUserID());
                System.out.println(session.getId());

            } else {
                mv.setViewName("login.jsp");
                mv.addObject("message", "Incorrect username or password");
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return mv;
    }


    public ModelAndView registerUser(Users user) {

        ModelAndView mv = new ModelAndView();


        return mv;
    }


    public ModelAndView verifyEmail(Long userID, HttpSession session) {

        ModelAndView mv = new ModelAndView();
        session.setAttribute("userID", userID);

        Boolean response = restTemplate.getForObject("http://Captrac-Backend/users/check/" + userID, Boolean.class);

        if (response == true) {
            mv.addObject("message", "Number verified successfully");
            mv.addObject("code", "<form name = 'form2'  action = '/changereq'>\r\n" +
                    "            <label>Type New Password:  </label><input type='password' name='password'><br><br>\r\n" +
                    "            <label>Re-Type Password:    </label><input type='password' name = 're-pwd'><br><br>\r\n" +
                    "            <input type='submit' id='submit' value='Change Password'></p2>\r\n" +
                    "            </form>");
            mv.setViewName("ChangePWD.jsp");
        } else {
            mv.addObject("message", "Number not registered");
            mv.setViewName("ChangePWD.jsp");
        }

        return mv;
    }


    public ModelAndView changeReq(Users users, HttpSession session) {

        ModelAndView mv = new ModelAndView();
        Long userID = (Long) session.getAttribute("userID");

        Users jsonUser = userinfoservice.getUserInfo(userID);

        Users postUser = new Users(jsonUser.getUserID(), jsonUser.getUsername(), users.getPassword(), jsonUser.getEmail());

        try {
            restTemplate.postForObject("http://Captrac-Backend/users/" + userID, postUser, Users.class);
            mv.addObject("changeMessage", "Password changed successfully");
            session.invalidate();
            mv.setViewName("ChangePWD.jsp");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return mv;
    }

}
