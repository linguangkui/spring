package com.shop.controller;

import com.shop.domain.User;
import com.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;
    @RequestMapping("login")
    public String login(String username, String password, HttpSession session){
        User user = userService.login(username, password);
        if (user!=null){
            session.setAttribute("user",user);
            return "redirect:product";
        }
        return "login";
    }
}
