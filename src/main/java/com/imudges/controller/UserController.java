package com.imudges.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2016/10/19.
 */
@Controller
public class UserController {
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String index() {
        return "login";
    }

    @ResponseBody
    @RequestMapping(value = "/userlogin", method = RequestMethod.POST)
    public String login(String email,String password){
        return email;
    }


    @RequestMapping(value = "/account.html", method = RequestMethod.GET)
    public String account(){
        return "account";
    }

}
