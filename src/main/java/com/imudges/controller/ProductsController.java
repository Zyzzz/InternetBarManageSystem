package com.imudges.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2016/10/26.
 */
@Controller
public class ProductsController {

    @RequestMapping(value = "/products.html", method =  RequestMethod.GET)
    public String product(){
        return "products";
    }
}
