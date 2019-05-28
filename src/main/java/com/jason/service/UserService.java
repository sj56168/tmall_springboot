package com.jason.service;

import com.jason.pojo.User;

import java.util.List;

/**
 * Created by 我不管我最帅 on 2019/3/31.
 */
public interface UserService {
    //todo  查询所有用户
    List<User> list();
    //todo 判断用户是否已存在
    public boolean isExist(String name);
    //todo 增加用户
    int add(User user);
    //todo  根据用户名查询用户
    User getUser(String name);
}
