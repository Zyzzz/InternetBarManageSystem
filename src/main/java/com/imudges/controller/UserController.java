package com.imudges.controller;

import com.imudges.model.UserEntity;
import com.imudges.repository.UserRepository;
import com.imudges.utils.JsonTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by Administrator on 2016/10/19.
 */
@Controller
public class UserController {
    @Autowired
    UserRepository userRepository;
    @RequestMapping(value = "/index.html", method =  RequestMethod.GET)
    public String index(@CookieValue(value = "userCookie",required  = false) String userCookie,ModelMap modelMap) {
        if(userCookie == null) {
            UserEntity user = new UserEntity();
            modelMap.addAttribute("user", user);
            return "index";
        }else {
           // UserEntity user = userRepository.findOne(Integer.parseInt(userCookie));
            UserEntity user  = (UserEntity) JsonTool.jsonStringOToObj(userCookie,UserEntity.class);
            System.out.println("UserId:"+user.getFirstname());
            modelMap.addAttribute("user", user);
            return "index";
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/userlogin", method = RequestMethod.POST)
    public String userlogin(@CookieValue(value = "userCookie",required  = false) String userCookie,HttpServletResponse response, String email, String password, ModelMap modelMap) throws UnsupportedEncodingException {
        UserEntity user = userRepository.findByEmailAndPassword(email, password);
        //userRepository.save();
        if (user==null) {
            String message = " Email or password mistake";
            modelMap.addAttribute("message", message);
            return "login";
        }
        else{
            String Json = JsonTool.objToJsonString(user);
            Cookie cookie = new Cookie("userCookie", URLEncoder.encode(Json,"utf-8"));
            cookie.setMaxAge(60 * 60 * 24 * 7);//保留7天
            response.addCookie(cookie);
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
