package com.jason.interceptor;

import com.jason.pojo.User;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by 我不管我最帅 on 2019/4/13.
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        String contextPath = session.getServletContext().getContextPath();
        String[] requireAuthPages = new String[]{
                  "buy",
                  "alipay",
                  "payed",
                  "cart",
                  "bought",
                  "confirmPay",
                  "orderConfirmed",

                  "forebuyone",
                  "forebuy",
                  "foreaddCart",
                  "forecart",
                  "forechangeOrderItem",
                  "foredeleteOrderItem",
                  "forecreateOrder",
                  "forepayed",
                  "forebought",
                  "foreconfirmPay",
                  "foreorderConfirmed",
                  "foredeleteOrder",
                  "forereview",
                  "foredoreview"
        };
        String uri = request.getRequestURI();
        /*uri 获取到的是/cart  需要去掉‘/’     */
        uri=StringUtils.remove(uri,"/");
        System.out.println("uri:::" + uri);
        //如果访问的是需要登录才能访问的页面
        if (begingWith(uri, requireAuthPages)) {
            //获取用户
            User user = (User) session.getAttribute("user");
            //如果未登录，则需要先跳转到登录页面登录
            if (user == null) {
                System.out.println("未登录");
                response.sendRedirect("/login");
                return false;
            }
        }
        return true;
    }
    //判断当前访问的页面是否是需要登录权限的页面
    private boolean begingWith(String page,String []requireAuthPages){
        boolean result = false;
        for (String requireAuthPage : requireAuthPages) {
            //如果访问的需要登录的界面  则result为true
            if (StringUtils.startsWith(page, requireAuthPage)) {
                result = true;
                break;
            }
        }
        return result;
    }
}
