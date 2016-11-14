package com.imudges.controller;

import com.imudges.model.AdminEntity;
import com.imudges.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Created by Administrator on 2016/11/14.
 */


@Controller
@SessionAttributes("admin")
public class AdminController {
    @Autowired
    AdminRepository adminRepository;

    @RequestMapping(value = "/adminlogin.html", method =  RequestMethod.GET)
    public String adminLogin(ModelMap modelMap){
        modelMap.addAttribute("message","");
        return "adminlogin";
    }
    @RequestMapping(value = "/adminsubmit", method =  RequestMethod.POST)
    public String adminsubmit(String adminName, String password,ModelMap modelMap){
        AdminEntity adminEntity = adminRepository.findByAdminname(adminName);
        if(adminEntity==null){
            modelMap.addAttribute("message","请检查用户名");
            return "adminlogin";
        }else if(!adminEntity.getPassword().equals(password)){
            modelMap.addAttribute("message","密码错误");
            return "adminlogin";
        }
        modelMap.addAttribute("admin",adminEntity);
        return "adminindex";
    }
    @RequestMapping(value = "/info.html", method =  RequestMethod.GET)
    public String info(){
       return "info";
    }
    @RequestMapping(value = "/book.html", method =  RequestMethod.GET)
    public String book(){
        return "book";
    }

    @RequestMapping(value = "/pass.html", method =  RequestMethod.GET)
    public String pass(){
        return "pass";
    }

    @RequestMapping(value = "/changepassword", method =  RequestMethod.POST)
    public String changePassword(@ModelAttribute("admin")AdminEntity adminEntity,String newpass){
        adminEntity.setPassword(newpass);
        adminRepository.saveAndFlush(adminEntity);
        return "pass";
    }
}
