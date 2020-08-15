package com.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DispatcherController {

    @RequestMapping("tologin")
    public String toLogin(){
        return "login";
    }
}
