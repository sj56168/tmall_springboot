package com.jason.controller;

import org.apache.shiro.web.session.HttpServletSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by 我不管我最帅 on 2019/4/4.
 *  专门做页面跳转
 */
@Controller
public class ForePageController {
    @GetMapping(value="/")
    public String index(){
        return "redirect:home";
    }
    @GetMapping(value="/home")
    public String home(){
        return "fore/home";
    }
    //注册
    @GetMapping(value="/register")
    public String register(){
        return "fore/register";
    }
    //注册成功
    @GetMapping(value="/registerSuccess")
    public String registerSuccess(){
        return "fore/registerSuccess";
    }
    @GetMapping(value="/login")
    public String login(){
        return "fore/login";
    }
    //退出
    @GetMapping("forelogout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:home";
    }
    //访问产品页
    @GetMapping("product")
    public String product(){
        return "fore/product";
    }
    //访问分类页
    @GetMapping("category")
    public String category(){
        return "fore/category";
    }
    //访问搜索结果页
    @GetMapping("search")
    public String searchResult(){
        return "fore/search";
    }
    //访问结算页面
    @GetMapping("buy")
    public String buy(){
        return "fore/buy";
    }
    //进入购物车页面
    @GetMapping("cart")
    public String cart(){
        return "fore/cart";
    }
    //进入付款页面
    @GetMapping("alipay")
    public String alipay(){
        return "fore/alipay";
    }
    //付款成功页面
    @GetMapping("payed")
    public String payed(){
        return "fore/payed";
    }

    //我的订单页面
    @GetMapping("bought")
    public String bought(){
        return "fore/bought";
    }
    //进入确认支付页面
    @GetMapping("confirmPay")
    public String confirmPay(){
        return "fore/confirmPay";
    }
    //确认收货支付成功页面
    @GetMapping("orderConfirmed")
    public String orderConfirmed(){
        return "fore/orderConfirmed";
    }
    //进入评价页面
    @GetMapping("review")
    public String review(){
        return "fore/review";
    }
}
