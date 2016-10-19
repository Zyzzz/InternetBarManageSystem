package com.imudges.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2016/10/19.
 */
@Controller
public class UserController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "login";
    }
}
