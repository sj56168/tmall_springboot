package com.jason.service.imp;

import com.jason.mapper.UserMapper;
import com.jason.pojo.User;
import com.jason.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 我不管我最帅 on 2019/3/31.
 */
@Service
public class UserServiceImp implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public List<User> list() {
        return userMapper.list();
    }

    @Override
    public boolean isExist(String name) {
        User user=userMapper.findByName(name);
        return user!=null; //不为空返回true 即用户名已存在
    }

    @Override
    public int add(User user) {
        return userMapper.add(user);
    }

    @Override
    public User getUser(String name) {
        return userMapper.getUser(name);
    }
}
