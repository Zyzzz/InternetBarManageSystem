package com.imudges.controller;

import com.imudges.repository.ShopCarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2016/10/29.
 */
@Controller
public class ShopCarController {
    @Autowired
    ShopCarRepository shopCarRepository;
    @RequestMapping(value = "/checkout.html", method =  RequestMethod.GET)
    public String checkout(){
        return "checkout";
    }
}
