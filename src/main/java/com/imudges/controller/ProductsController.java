package com.imudges.controller;

import com.imudges.model.CommodityEntity;
import com.imudges.model.UserEntity;
import com.imudges.repository.CommodityRepository;
import com.imudges.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Administrator on 2016/10/26.
 */
@Controller
public class ProductsController {
    @Autowired
    UserRepository userRepository ;
    @Autowired
    CommodityRepository commodityRepository;
    @RequestMapping(value = "/products.html", method =  RequestMethod.GET)
    public String product(@CookieValue(value = "userCookie",required  = false) String userCookie, ModelMap modelMap){
        if(userCookie == null) {
            UserEntity user = new UserEntity();
            modelMap.addAttribute("user", user);
            List<CommodityEntity> commoditys = commodityRepository.findAll();
            for(CommodityEntity commodityEntity : commoditys) {
                String[] StrArray = commodityEntity.getImageByImageId().getImg().split(";");
                commodityEntity.getImageByImageId().setImg(StrArray[0]);
            }
            modelMap.addAttribute("commoditys",commoditys);
            return "products";
        }else {
            // UserEntity user = userRepository.findOne(Integer.parseInt(userCookie));
            UserEntity user = userRepository.findByCookie(userCookie);
            //UserEntity user  = (UserEntity) JsonTool.jsonStringOToObj(userCookie,UserEntity.class);
            System.out.println("UserId:"+user.getFirstname());
            List<CommodityEntity> commoditys = commodityRepository.findAll();
            for(CommodityEntity commodityEntity : commoditys) {
                String[] StrArray = commodityEntity.getImageByImageId().getImg().split(";");
                commodityEntity.getImageByImageId().setImg(StrArray[0]);
            }
            modelMap.addAttribute("commoditys",commoditys);
            modelMap.addAttribute("user", user);
            return "products";
        }
    }

    @RequestMapping(value = "/single.html", method =  RequestMethod.GET)
    public String single(int commodityid, ModelMap modelMap){
        CommodityEntity commodityEntity = commodityRepository.findOne(commodityid);
        modelMap.addAttribute("commodity",commodityEntity);
        return "single";
    }

}
