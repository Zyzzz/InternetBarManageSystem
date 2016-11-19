package com.imudges.controller;

import com.imudges.model.IndentEntity;
import com.imudges.model.ShoppingcarEntity;
import com.imudges.model.UserEntity;
import com.imudges.repository.CommodityRepository;
import com.imudges.repository.IndetRepository;
import com.imudges.repository.ShopCarRepository;
import com.imudges.repository.UserRepository;
import com.imudges.utils.ShoppCartEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/29.
 */
@Controller
public class ShopCarController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ShopCarRepository shopCarRepository;
    @Autowired
    CommodityRepository commodityRepository;
    @Autowired
    IndetRepository indetRepository;

    @RequestMapping(value = "/checkindent", method =  RequestMethod.GET)
    public String checkindent(@CookieValue(value = "userCookie",required  = false) String userCookie,ModelMap modelMap){
        UserEntity user = userRepository.findByCookie(userCookie);
        System.out.println("UserId:"+user.getFirstname());
        modelMap.addAttribute("user", user);
        ShoppingcarEntity shoppingcarEntity = shopCarRepository.findByUserid(user.getUserid());
        if(shoppingcarEntity==null){
            modelMap.addAttribute("price","0.00");
            modelMap.addAttribute("message","");
        }
        else {
            modelMap.addAttribute("price", String.valueOf(shoppingcarEntity.getPrice()));
        }
        List<ShoppCartEntry> shoppCartEntries = new ArrayList<ShoppCartEntry>();
        for(IndentEntity indentEntity : user.getIndentByUserid()){
            ShoppCartEntry shoppCartEntry = new ShoppCartEntry();
            shoppCartEntry.setCommodityEntity(indentEntity.getCommodityByCommodityId());
            shoppCartEntry.setSize(String.valueOf(indentEntity.getSize()));
            shoppCartEntry.setNumber(String.valueOf(indentEntity.getNumber()));
            shoppCartEntry.setTime(indentEntity.getTime());
            shoppCartEntries.add(shoppCartEntry);
        }
        modelMap.addAttribute("shoppCartEntries",shoppCartEntries);
        return "indent";
    }
    @RequestMapping(value = "/checkout.html", method =  RequestMethod.GET)
    public String checkout(@CookieValue(value = "cartCookie",required  = false) String cartCookie, @CookieValue(value = "userCookie",required  = false) String userCookie,ModelMap modelMap){
        if(userCookie == null) {
            UserEntity user = new UserEntity();
            modelMap.addAttribute("user", user);
            modelMap.addAttribute("price","0.00");
            List<ShoppCartEntry> shoppCartEntries = new ArrayList<ShoppCartEntry>();
            modelMap.addAttribute("shoppCartEntries",shoppCartEntries);
            modelMap.addAttribute("number",0);
            modelMap.addAttribute("message","");
            return "checkout";
        }else {
            UserEntity user = userRepository.findByCookie(userCookie);
            System.out.println("UserId:"+user.getFirstname());
            modelMap.addAttribute("user", user);
            ShoppingcarEntity shoppingcarEntity = shopCarRepository.findByUserid(user.getUserid());
            if(shoppingcarEntity==null){
                modelMap.addAttribute("price","0.00");
                modelMap.addAttribute("number",0);
                List<ShoppCartEntry> shoppCartEntries = new ArrayList<ShoppCartEntry>();
                modelMap.addAttribute("shoppCartEntries",shoppCartEntries);
                modelMap.addAttribute("message","");
            }
            else{
                modelMap.addAttribute("price",String.valueOf(shoppingcarEntity.getPrice()));
                String[] Commodityids = shoppingcarEntity.getCommodityidlist().split(";");
                String[] TimeList =   shoppingcarEntity.getTimelist().split(";");
                String[] Sizes = shoppingcarEntity.getSizes().split(";");
                String[] Numbers = shoppingcarEntity.getNumbers().split(";");
                List<ShoppCartEntry> shoppCartEntries = new ArrayList<ShoppCartEntry>();
               for(int i = 0;i<Commodityids.length;i++) {
                   ShoppCartEntry shoppCartEntry = new ShoppCartEntry();
                   shoppCartEntry.setCommodityEntity(commodityRepository.findOne(Integer.valueOf(Commodityids[i])));
                   shoppCartEntry.setSize(Sizes[i]);
                   shoppCartEntry.setTime(TimeList[i]);
                   shoppCartEntry.setNumber(Numbers[i]);
                   shoppCartEntries.add(shoppCartEntry);
                }
                modelMap.addAttribute("shoppCartEntries",shoppCartEntries);
                modelMap.addAttribute("number",Commodityids.length);
                modelMap.addAttribute("message","");
            }
            return "checkout";
        }
    }
    @RequestMapping(value = "/emptyCart", method =  RequestMethod.GET)
    public String emptyCart(@CookieValue(value = "userCookie",required  = false) String userCookie,String html, ModelMap modelMap){
        if(userCookie == null) {
            UserEntity user = new UserEntity();
            modelMap.addAttribute("user", user);
            modelMap.addAttribute("price", "0.00");
            List<ShoppCartEntry> shoppCartEntries = new ArrayList<ShoppCartEntry>();
            modelMap.addAttribute("shoppCartEntries",shoppCartEntries);
            modelMap.addAttribute("number",0);
            modelMap.addAttribute("message","");
            return html;
        }else {
            UserEntity userEntity = userRepository.findByCookie(userCookie);
            ShoppingcarEntity shoppingcarEntity = shopCarRepository.findByUserid(userEntity.getUserid());
            if(shoppingcarEntity!=null) {
                shopCarRepository.delete(shoppingcarEntity);
            }
            modelMap.addAttribute("price","0.00");
            List<ShoppCartEntry> shoppCartEntries = new ArrayList<ShoppCartEntry>();
            modelMap.addAttribute("shoppCartEntries",shoppCartEntries);
            modelMap.addAttribute("user", userEntity);
            modelMap.addAttribute("number",0);
            modelMap.addAttribute("message","");
            return html;
        }
    }

    @RequestMapping(value = "/toGenerateOrders", method =  RequestMethod.GET)
    public String toGenerateOrders(@CookieValue(value = "userCookie",required  = false) String userCookie, ModelMap modelMap){
        if(userCookie == null) {
            UserEntity user = new UserEntity();
            modelMap.addAttribute("user", user);
            modelMap.addAttribute("price","0.00");
            List<ShoppCartEntry> shoppCartEntries = new ArrayList<ShoppCartEntry>();
            modelMap.addAttribute("shoppCartEntries",shoppCartEntries);
            modelMap.addAttribute("number",0);
            modelMap.addAttribute("message","请登录");
            return "checkout";
        }else {
            UserEntity user = userRepository.findByCookie(userCookie);
            System.out.println("UserId:"+user.getFirstname());
            modelMap.addAttribute("user", user);
            ShoppingcarEntity shoppingcarEntity = shopCarRepository.findByUserid(user.getUserid());
            if(shoppingcarEntity==null){
                modelMap.addAttribute("price","0.00");
                modelMap.addAttribute("number",0);
                List<ShoppCartEntry> shoppCartEntries = new ArrayList<ShoppCartEntry>();
                modelMap.addAttribute("shoppCartEntries",shoppCartEntries);
                modelMap.addAttribute("message"," 购物车为空，快去选点东西吧！");
            }
            else{
                modelMap.addAttribute("price",String.valueOf(shoppingcarEntity.getPrice()));
                List<ShoppCartEntry> shoppCartEntries = new ArrayList<ShoppCartEntry>();
                modelMap.addAttribute("shoppCartEntries",shoppCartEntries);
                modelMap.addAttribute("number",0);
                String[] Commodityids = shoppingcarEntity.getCommodityidlist().split(";");
                String[] Sizes = shoppingcarEntity.getSizes().split(";");
                String[] Numbers = shoppingcarEntity.getNumbers().split(";");
                for(int i=0;i<Commodityids.length;i++){
                    IndentEntity indentEntity = new IndentEntity();
                    indentEntity.setUserByUserid(user);
                    indentEntity.setCommodityByCommodityId(commodityRepository.findOne(Integer.valueOf(Commodityids[i])));
                    indentEntity.setNumber(Integer.valueOf(Numbers[i]));
                    indentEntity.setSize(Integer.valueOf(Sizes[i]));
                    indetRepository.saveAndFlush(indentEntity);
                }
                shopCarRepository.delete(shoppingcarEntity);
                modelMap.addAttribute("message"," 订单生产成功");
            }
            return "checkout";
        }
    }
    @RequestMapping(value = "/removeGoods", method =  RequestMethod.GET)
    public String romveGood(@CookieValue(value = "userCookie",required  = false) String userCookie, ModelMap modelMap,int number){
        UserEntity user = userRepository.findByCookie(userCookie);
        System.out.println("UserId:"+user.getFirstname());
        modelMap.addAttribute("user", user);
        ShoppingcarEntity shoppingcarEntity = shopCarRepository.findByUserid(user.getUserid());
        String[] Commodityids = shoppingcarEntity.getCommodityidlist().split(";");
        String[] Sizes = shoppingcarEntity.getSizes().split(";");
        String[] Numbers = shoppingcarEntity.getNumbers().split(";");
        String[] Times = shoppingcarEntity.getTimelist().split(";");
        List<ShoppCartEntry> shoppCartEntries = new ArrayList<ShoppCartEntry>();
        if(Commodityids.length==1){
            modelMap.addAttribute("price","0.00");
            modelMap.addAttribute("shoppCartEntries",shoppCartEntries);
            modelMap.addAttribute("user", user);
            modelMap.addAttribute("number",0);
            modelMap.addAttribute("message","");
            shopCarRepository.delete(shoppingcarEntity);
            return "checkout";
        }else {
            String commodityids = "";
            String sizes="";
            String datas = "";
            String numbers = "";
            double Price=0;
            for(int i=0;i<Commodityids.length;i++) {
                if(i != number){
                    ShoppCartEntry shoppCartEntry = new ShoppCartEntry();
                    shoppCartEntry.setCommodityEntity(commodityRepository.findOne(Integer.valueOf(Commodityids[i])));
                    shoppCartEntry.setSize(Sizes[i]);
                    shoppCartEntry.setTime(Times[i]);
                    shoppCartEntry.setNumber(Numbers[i]);
                    shoppCartEntries.add(shoppCartEntry);
                    commodityids=commodityids+ Commodityids[i]+";";
                    sizes =sizes + Sizes[i] +";";
                    datas = datas + Times[i]+";";
                    numbers = numbers + Numbers[i]+";";
                    Price+= commodityRepository.findOne(Integer.valueOf(Commodityids[i])).getPrice() * commodityRepository.findOne(Integer.valueOf(Commodityids[i])).getDiscount();
                }
            }
            if(commodityids.charAt(commodityids.length()-1)==';') {
                commodityids = commodityids.substring(0,commodityids.length()-1);
            }
            if(sizes.charAt(sizes.length()-1)==';') {
                sizes = sizes.substring(0,sizes.length()-1);
            }
            if(datas.charAt(datas.length()-1)==';') {
                datas = datas.substring(0,datas.length()-1);
            }
            if(numbers.charAt(numbers.length()-1)==';') {
                numbers = numbers.substring(0,numbers.length()-1);
            }
            shoppingcarEntity.setCommodityidlist(commodityids);
            shoppingcarEntity.setSizes(sizes);
            shoppingcarEntity.setTimelist(datas);
            shoppingcarEntity.setPrice(Price);
            shoppingcarEntity.setNumbers(numbers);
            shopCarRepository.saveAndFlush(shoppingcarEntity);
            modelMap.addAttribute("price",Price);
            modelMap.addAttribute("shoppCartEntries",shoppCartEntries);
            modelMap.addAttribute("user", user);
            modelMap.addAttribute("number",Commodityids.length-1);
            modelMap.addAttribute("message","");
        }
        return "checkout";
    }
}
