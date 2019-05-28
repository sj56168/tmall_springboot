package com.jason.service;

import com.jason.pojo.Order;
import com.jason.pojo.OrderItem;
import com.jason.pojo.Product;
import com.jason.pojo.User;

import java.util.List;

/**
 * Created by 我不管我最帅 on 2019/3/31.
 */
public interface OrderItemService {
    //todo 根据该订单查询所有订单项
    List<OrderItem> listOrderItemsByOrder(Order order);
    //根据产品获取订单项
    List<OrderItem> listOrderItemsByProduct(Product product);
    //获取销售数量
    int getSaleCounts(Product product);
    //根据用户获取订单项
    public List<OrderItem> listByUser(User user);
    //增加订单项
    void add(OrderItem orderItem);
    //获取一个订单项
     OrderItem getOne(int id);
     //修改
     void update(OrderItem orderItem);
     //删除
     void delete(int oiid);
}
