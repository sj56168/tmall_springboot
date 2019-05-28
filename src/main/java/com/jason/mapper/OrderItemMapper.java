package com.jason.mapper;

import com.jason.pojo.Order;
import com.jason.pojo.OrderItem;
import com.jason.pojo.Product;
import com.jason.pojo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 我不管我最帅 on 2019/3/31.
 */
@Repository
public interface OrderItemMapper {
    //TODO 根据订单获取该订单下的所有订单项
    // 多对一查询 （查询的每个订单项结果都包含一个订单类，一个产品类，一个用户类）
    @Select("select * from orderitem where oid=#{id}")
    @Results({
              @Result(property = "order",column = "oid",one=@One(select = "com.jason.mapper.OrderMapper.getOne")),
              @Result(property = "product",column = "pid",one=@One(select = "com.jason.mapper.ProductMapper.getOne")),
              @Result(property = "user",column = "uid",one=@One(select = "com.jason.mapper.UserMapper.getOne"))
    })
    List<OrderItem> listOrderItemsByOrder(Order order);
    //todo 根据产品获取订单项
    @Select("select * from orderitem where pid=#{id}")
    @Results({
              @Result(property = "order",column = "oid",one=@One(select = "com.jason.mapper.OrderMapper.getOne")),
              @Result(property = "product",column = "pid",one=@One(select = "com.jason.mapper.ProductMapper.getOne")),
              @Result(property = "user",column = "uid",one=@One(select = "com.jason.mapper.UserMapper.getOne"))

    })
    List<OrderItem> listOrderItemsByProduct(Product product);
    //todo 根据用户获取产订单项
    @Select("select * from orderitem where uid=#{id} and oid is null")
    @Results({
              @Result(property = "order",column = "oid",one=@One(select = "com.jason.mapper.OrderMapper.getOne")),
              @Result(property = "product",column = "pid",one=@One(select = "com.jason.mapper.ProductMapper.getOne")),
              @Result(property = "user",column = "uid",one=@One(select = "com.jason.mapper.UserMapper.getOne"))

    })
    List<OrderItem> listByUser(User user);
    //todo 增加一个订单项
    @Insert("insert into orderitem(pid,oid,uid,number) values(#{product.id},#{order.id},#{user.id},#{number})")
    void add(OrderItem orderItem);
    //todo 根据订单项id获取订单项
    @Select("select * from orderitem where id=#{id}")
    @Results({
              @Result(property = "order",column = "oid",one=@One(select = "com.jason.mapper.OrderMapper.getOne")),
              @Result(property = "product",column = "pid",one=@One(select = "com.jason.mapper.ProductMapper.getOne")),
              @Result(property = "user",column = "uid",one=@One(select = "com.jason.mapper.UserMapper.getOne"))

    })
    OrderItem getOne(int id);
    //todo 修改
    @Update("update orderitem set oid=#{order.id},number=#{number} where id=#{id}")
    void update(OrderItem orderItem);
    //todo 删除
    @Delete("delete from orderitem where id=#{oiid}")
    void delete(int oiid);
}
