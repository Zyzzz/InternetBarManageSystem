package com.imudges.controller;

import com.imudges.model.CommodityEntity;
import com.imudges.model.ShoppingcarEntity;
import com.imudges.model.UserEntity;
import com.imudges.repository.CommodityRepository;
import com.imudges.repository.ShopCarRepository;
import com.imudges.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.imudges.utils.SHA256Test.SHA256Encrypt;

/**
 * Created by Administrator on 2016/10/26.
 */
@Controller
public class ProductsController {
    @Autowired
    UserRepository userRepository ;
    @Autowired
    CommodityRepository commodityRepository;
    @Autowired
    ShopCarRepository carRepository;
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
            if(user != null){
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
            }else {
                user = new UserEntity();
                modelMap.addAttribute("user", user);
                List<CommodityEntity> commoditys = commodityRepository.findAll();
                for(CommodityEntity commodityEntity : commoditys) {
                    String[] StrArray = commodityEntity.getImageByImageId().getImg().split(";");
                    commodityEntity.getImageByImageId().setImg(StrArray[0]);
                }
                modelMap.addAttribute("commoditys",commoditys);
                return "products";
            }

        }
    }

    @RequestMapping(value = "/single.html", method =  RequestMethod.GET)
    public String single(@CookieValue(value = "userCookie",required  = false) String userCookie,int commodityid, ModelMap modelMap){
        if(userCookie == null) {
            UserEntity user = new UserEntity();
            modelMap.addAttribute("user", user);
            CommodityEntity commodityEntity = commodityRepository.findOne(commodityid);
            modelMap.addAttribute("commodity",commodityEntity);
            return "single";
        }else {
            // UserEntity user = userRepository.findOne(Integer.parseInt(userCookie));
            UserEntity user = userRepository.findByCookie(userCookie);
            //UserEntity user  = (UserEntity) JsonTool.jsonStringOToObj(userCookie,UserEntity.class);
            CommodityEntity commodityEntity = commodityRepository.findOne(commodityid);
            modelMap.addAttribute("commodity",commodityEntity);
            modelMap.addAttribute("user", user);
            return "single";
        }
    }
    @RequestMapping(value = "/addToCart", method =  RequestMethod.GET)
    public String addToCart(@CookieValue(value = "cartCookie",required  = false) String cartCookie, @CookieValue(value = "userCookie",required  = false) String userCookie, HttpServletResponse response, int commodityid, int number, int size, ModelMap modelMap){
        if(userCookie == null) {
            UserEntity user = new UserEntity();
            modelMap.addAttribute("user", user);
            CommodityEntity commodityEntity = commodityRepository.findOne(commodityid);
            modelMap.addAttribute("commodity",commodityEntity);
            modelMap.addAttribute("message","Please Login");
            return "single";
        }else {
            modelMap.addAttribute("message","");
            UserEntity user = userRepository.findByCookie(userCookie);
            //UserEntity user  = (UserEntity) JsonTool.jsonStringOToObj(userCookie,UserEntity.class);
            CommodityEntity commodityEntity = commodityRepository.findOne(commodityid);
            modelMap.addAttribute("commodity",commodityEntity);
            modelMap.addAttribute("user", user);
            Format format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String data = format.format(new Date());
            if(cartCookie==null){
                String cookieencrypt = SHA256Encrypt(user.getUserid()+commodityid+data);
                Cookie cookie = new Cookie("cartCookie",cookieencrypt);
                ShoppingcarEntity shoppingcarEntity = new ShoppingcarEntity();
                shoppingcarEntity.setUserid(user.getUserid());
                shoppingcarEntity.setCookie(cookieencrypt);
                shoppingcarEntity.setCommodityidlist(""+commodityid);
                shoppingcarEntity.setTimelist(data);
                shoppingcarEntity.setPrice(commodityEntity.getPrice()*number);
                shoppingcarEntity.setSizes(""+size);
                shoppingcarEntity.setNumbers(""+number);
                carRepository.saveAndFlush(shoppingcarEntity);
                cookie.setMaxAge(60 * 60 * 24 * 7);//保留7天
                modelMap.addAttribute("shoppingcarEntity",shoppingcarEntity);
                response.addCookie(cookie);
                return "single";
            }else {
                ShoppingcarEntity shoppingcarEntity = carRepository.findByCookie(cartCookie);
                shoppingcarEntity.setSizes(shoppingcarEntity.getSizes()+";"+size);
                shoppingcarEntity.setTimelist(shoppingcarEntity.getTimelist()+";"+data);
                shoppingcarEntity.setPrice(shoppingcarEntity.getPrice()+(commodityEntity.getPrice()*number));
                shoppingcarEntity.setNumbers(shoppingcarEntity.getNumbers()+";"+number);
                carRepository.saveAndFlush(shoppingcarEntity);
                modelMap.addAttribute("shoppingcarEntity",shoppingcarEntity);
                return "single";
            }
        }
    }
}
