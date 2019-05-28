package com.jason.service;

import com.jason.pojo.Order;
import com.jason.pojo.OrderItem;
import com.jason.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by 我不管我最帅 on 2019/3/31.
 */
public interface OrderService {
    //订单状态码
    public static final String waitPay = "waitPay";//待支付状态
    public static final String waitDelivery = "waitDelivery";//等待发货状态
    public static final String waitConfirm = "waitConfirm";//确认收获状态
    public static final String waitReview = "waitReview";//待评价状态
    public static final String finish = "finish";//完成状态
    public static final String delete = "delete";//已删除状态
    //todo 查询所有订单
    List<Order> listOrders();
    //todo 获取一个订单
    Order getOne(int id);
    //todo 1、查询所有订单然后遍历每个订单
    //todo 2、根据订单id查询所有订单项
    //todo 3、将查询出来的订单项绑定到Order的List<OrderItem> OrderItems 还有就是计算总价和产品总数 处理多个
    public void fill(List<Order> orderList);
    //todo 将查询出来的订单项绑定到Order的List<OrderItem> OrderItems 还有就是计算总价和产品总数  处理一个
    public void fill(Order order);
    //todo 更新订单状态
    void update(Order order);
    //todo 增加订单 同时修改订单项
    float add(Order order, List<OrderItem> orderItems);
    //todo 仅仅是增加订单
    int add(Order order);
    //todo 获取订单状态fei delete的 所有订单
    public List<Order> listByUserWithoutDelete(User user);

/*    //todo 将orderItem里的order属性置为null，防止出现递归报错 （处理多个order）
    public void removeOrderFromOrderItem(List<Order> orders);
    //todo 将orderItem里的order属性置为null，防止出现递归报错 （处理单个order）
    public void removeOrderFromOrderItem(Order order);
    //根据订单id计算订单总金额
    public void total(Order order);*/

}
