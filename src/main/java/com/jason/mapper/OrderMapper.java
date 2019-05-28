package com.jason.mapper;

import com.jason.pojo.Order;
import com.jason.pojo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 我不管我最帅 on 2019/3/31.
 */
@Repository
public interface OrderMapper {
    //todo 查询所有订单
    @Select("select * from order_")
    List<Order> listOrders();
    //todo 获取一个订单
    @Select("select * from order_ where id=#{id}")
    Order getOne(int id);
    //todo 更新订单状态
    @Update("update order_ set status=#{status},deliveryDate=#{deliveryDate} where id=#{id}")
    void update(Order order);
    //todo 增加
    @Insert("insert into order_(orderCode,address,post,receiver,mobile,userMessage,createDate,payDate,deliveryDate,confirmDate,uid,status) values(#{orderCode},#{address},#{post},#{receiver},#{mobile},#{userMessage},#{createDate},#{payDate},#{deliveryDate},#{confirmDate},#{user.id},#{status})")
    @SelectKey(statement="SELECT LAST_INSERT_ID() AS id", keyProperty="id", before=false, resultType=int.class)
    int add(Order order);//返回自增id
    //todo 获取那些某个用户的订单，而且是 不在（not IN ） 某个订单状态的订单
    @Select("select * from order_ where uid=#{uid} and status not IN (#{status})")
    List<Order> listOrdersByUserAndStatus(@Param(value = "uid") int uid,@Param(value = "status") String status);

}
