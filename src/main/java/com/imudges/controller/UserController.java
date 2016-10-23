package com.imudges.controller;

import com.imudges.model.UserEntity;
import com.imudges.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2016/10/19.
 */
@Controller
public class UserController {
    @Autowired
    UserRepository userRepository;
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String index() {

        return "login";
    }

    @ResponseBody
    @RequestMapping(value = "/userlogin", method = RequestMethod.POST)
    public String login(String email,String password){
        List<UserEntity> userList = userRepository.findByEmailAndPassword(email, password);

        //userRepository.save()
        if(userList.size()==0)
            return "失败";
        else
            return email;
    }

    @RequestMapping(value = "/account.html", method = RequestMethod.GET)
    public String account(){
        return "account";
    }
    @ResponseBody
    @RequestMapping(value = "/submit_account", method = RequestMethod.POST)
    public String submit_account(String firstName,String lastName,String emal,String password){
        UserEntity user = new UserEntity();
        user.setFirstname(firstName);
        return "Success";
    }


}
