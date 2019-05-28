package com.jason.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by 我不管我最帅 on 2019/3/27.
 */
@Controller
public class PageController {
    @RequestMapping("/listProperty")
public  String listProperty(){
        return "admin/listProperty";
    }
    @RequestMapping("/listProduct")
    public String listProduct(){
    return "admin/listProduct";
    }
    @RequestMapping("/editPropertyValue")
    public String listPropertyValue(){
        return "admin/editPropertyValue";
    }
    @RequestMapping("/listUser")
    public String listUser(){
        return "admin/listUser";
    }
    @RequestMapping(value = "/listCategory",method = RequestMethod.GET)
    public ModelAndView listCategory2(){
        ModelAndView mv=new ModelAndView("admin/listCategory");
        return mv;
    }
    @RequestMapping("/listOrder")
    public String listOrder(){
        return "admin/listOrder";
    }
    @RequestMapping("/listProductImage")
    public String listProductImage(){
        return "admin/listProductImage";
    }
}
