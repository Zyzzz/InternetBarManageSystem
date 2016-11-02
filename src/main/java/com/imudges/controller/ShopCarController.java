package com.imudges.controller;

import com.imudges.model.UserEntity;
import com.imudges.repository.ShopCarRepository;
import com.imudges.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2016/10/29.
 */
@Controller
public class ShopCarController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ShopCarRepository shopCarRepository;
    @RequestMapping(value = "/checkout.html", method =  RequestMethod.GET)
    public String checkout(@CookieValue(value = "cartCookie",required  = false) String cartCookie, @CookieValue(value = "userCookie",required  = false) String userCookie,ModelMap modelMap){
        if(userCookie == null) {
            UserEntity user = new UserEntity();
            modelMap.addAttribute("user", user);
            modelMap.addAttribute("price","0.00");
            return "checkout";
        }else {
            // UserEntity user = userRepository.findOne(Integer.parseInt(userCookie));
            UserEntity user = userRepository.findByCookie(userCookie);
            //UserEntity user  = (UserEntity) JsonTool.jsonStringOToObj(userCookie,UserEntity.class);
            System.out.println("UserId:"+user.getFirstname());
            modelMap.addAttribute("user", user);
           // modelMap.addAttribute("shoppingcarEntity",shoppingcarEntity);
            return "checkout";
        }


    }

}
