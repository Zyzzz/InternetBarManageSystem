package com.imudges.controller;

import com.imudges.model.UserEntity;
import com.imudges.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2016/10/19.
 */
@Controller
public class UserController {
    @Autowired
    UserRepository userRepository;
    @RequestMapping(value = "/index.html", method = RequestMethod.GET)
    public String index(ModelMap modelMap) {
        UserEntity user = new UserEntity();
        modelMap.addAttribute("user", user);
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/userlogin", method = RequestMethod.POST)
    public String userlogin(String email,String password,ModelMap modelMap) {
        UserEntity user = userRepository.findByEmailAndPassword(email, password);
        //userRepository.save();
        if (user.getEmail() == "")
            return "失败";
        else{
            modelMap.addAttribute("user", user);
            return "index";
        }
        //return "";
    }

    @RequestMapping(value = "/account.html", method = RequestMethod.GET)
    public String account(){
        return "account";
    }

    //@ResponseBody
    @RequestMapping(value = "/submit_account", method = RequestMethod.POST)
    public String submit_account(String firstName,String lastName,String email,String password){
        UserEntity user = new UserEntity();
        user.setFirstname(firstName);
        user.setLastname(lastName);
        user.setEmail(email);
        user.setPassword(password);
        userRepository.save(user);
        return "login";
    }



}
