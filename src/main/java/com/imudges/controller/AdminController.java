package com.imudges.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2016/11/14.
 */


@Controller
public class AdminController {
    @RequestMapping(value = "/adminlogin.html", method =  RequestMethod.GET)
    public String adminLogin(){
        return "adminlogin";
    }

}
