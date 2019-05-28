package com.jason.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jason.pojo.User;
import com.jason.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by 我不管我最帅 on 2019/3/31.
 */
@RestController
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("users")
    public PageInfo<User> listUsers(@RequestParam(value = "start",defaultValue = "1")int start,@RequestParam(value = "pageSzie",defaultValue = "3")int pageSize)throws  Exception{
        PageHelper.startPage(start,pageSize);
        List<User> userList = userService.list();
        PageInfo<User> page=new PageInfo<>(userList,3);
        return page;

    }
}
