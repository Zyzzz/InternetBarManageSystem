package com.imudges.controller;

import com.imudges.model.UserEntity;
import com.imudges.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.imudges.utils.SHA256Test.SHA256Encrypt;

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
            modelMap.addAttribute("price","0.00");
            modelMap.addAttribute("user", user);
            return "index";
        }else {
           // UserEntity user = userRepository.findOne(Integer.parseInt(userCookie));
            UserEntity user = userRepository.findByCookie(userCookie);
            //UserEntity user  = (UserEntity) JsonTool.jsonStringOToObj(userCookie,UserEntity.class);
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
    public String userlogin(@CookieValue(value = "userCookie",required  = false) String userCookie,HttpServletResponse response, String email, String password, ModelMap modelMap) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        UserEntity user = userRepository.findByEmailAndPassword(email, password);
        //userRepository.save();
        if (user==null) {
            String message = " Email or password mistake";
            modelMap.addAttribute("message", message);
            modelMap.addAttribute("price","0.00");
            return "login";
        }
        else{
            //String Json = JsonTool.objToJsonString(user);
            Format format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String data = format.format(new Date());
            String cookieencrypt = SHA256Encrypt(user.getUserid()+user.getEmail()+data);
            Cookie cookie = new Cookie("userCookie",cookieencrypt);
            user.setCookie(cookieencrypt);
            userRepository.saveAndFlush(user);
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
    public String submit_account(@CookieValue(value = "userCookie",required  = false) String userCookie,ModelMap modelMap,HttpServletResponse response,String firstName,String lastName,String email,String password,boolean checkbox){
        UserEntity user = new UserEntity();
        user.setFirstname(firstName);
        user.setLastname(lastName);
        user.setEmail(email);
        user.setPassword(password);
        if(!checkbox) {
            userRepository.save(user);

            return "login";
        }else {
            Format format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String data = format.format(new Date());
            String cookieencrypt = SHA256Encrypt(user.getUserid()+user.getEmail()+data);
            Cookie cookie = new Cookie("userCookie",cookieencrypt);
            user.setCookie(cookieencrypt);
            userRepository.saveAndFlush(user);
            cookie.setMaxAge(60 * 60 * 24 * 7);//保留7天
            response.addCookie(cookie);

            modelMap.addAttribute("user", user);
            return "index";
        }
    }

    @RequestMapping(value = "/usermessage.html", method = RequestMethod.GET)
    public String usermessage(@CookieValue(value = "userCookie",required  = false) String userCookie,ModelMap modelMap){
        if(userCookie == null) {
            UserEntity user = new UserEntity();
            modelMap.addAttribute("user", user);
            return "usermessage";
        }else {
            // UserEntity user = userRepository.findOne(Integer.parseInt(userCookie));
            UserEntity user = userRepository.findByCookie(userCookie);
            //UserEntity user  = (UserEntity) JsonTool.jsonStringOToObj(userCookie,UserEntity.class);
            System.out.println("UserId:"+user.getFirstname());
            modelMap.addAttribute("user", user);
            return "usermessage";
        }
    }
    @RequestMapping(value = "/submit_usermessage", method = RequestMethod.POST)
    public String submit_usermessage(@CookieValue(value = "userCookie",required  = false) String userCookie,ModelMap modelMap,String firstName,String lastName,String password){
        UserEntity user = userRepository.findByCookie(userCookie);
        user.setFirstname(firstName);
        user.setLastname(lastName);
        user.setPassword(password);
        userRepository.saveAndFlush(user);
        //UserEntity user  = (UserEntity) JsonTool.jsonStringOToObj(userCookie,UserEntity.class);
        System.out.println("UserId:"+user.getFirstname());
        modelMap.addAttribute("user", user);
        return "index";

    }

}
