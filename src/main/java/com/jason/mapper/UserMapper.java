package com.jason.mapper;

import com.jason.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 我不管我最帅 on 2019/3/31.
 * 增加交由前台用户注册功能
 删除不提供（用户信息是最重要的资料）
 修改不提供，应该由前台用户自己完成
 */
@Repository
public interface UserMapper {
    //todo 查询所有用户
    @Select("select * from user")
    List<User> list();
    //todo  根据用户id查询一个用户
    @Select("select * from user where id=#{id}")
    User getOne(int id);
    @Select("select * from user where name=#{name}")
    User findByName(String name);
    //todo 增加用户
    @Insert("insert into user(name,password) values(#{name},#{password})")
    int add(User user);
    //todo  根据用户名查询用户
    @Select("select * from user where name=#{name}")
    User getUser(String name);

}
