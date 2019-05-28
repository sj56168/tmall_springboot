package com.jason.service.imp;

import com.jason.mapper.OrderItemMapper;
import com.jason.mapper.OrderMapper;
import com.jason.mapper.UserMapper;
import com.jason.pojo.Order;
import com.jason.pojo.OrderItem;
import com.jason.pojo.User;
import com.jason.service.OrderItemService;
import com.jason.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 我不管我最帅 on 2019/3/31.
 */
@Service
public class OrderServiceImp implements OrderService {

    @Autowired
    OrderMapper orderMapper;
    @Autowired
    OrderItemMapper orderItemMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    OrderItemService orderItemService;
    //todo 查询所有订单
    @Override
    public List<Order> listOrders() {
        return orderMapper.listOrders();
    }
    //todo 获取一个订单
    @Override
    public Order getOne(int id) {
        return orderMapper.getOne(id);
    }
    //更新订单状态
    @Override
    public void update(Order order) {
        orderMapper.update(order);
    }
    //仅仅是增加订单 返回的是自增id
    @Override
    public int add(Order order) {
        return orderMapper.add(order);
    }


    //增加订单（同时修改订单项里oid的值）
    @Override
    public float add(Order order,List<OrderItem> orderItems) {
        float total=0;//订单总额
        //返回1则表示插入成功
        int num =add(order);
        //只有订单添加成功才会去修改订单项里的oid
        if(num>0){
            for(OrderItem orderItem:orderItems){
                orderItem.setOrder(order);
                orderItemService.update(orderItem);
                total+=orderItem.getProduct().getPromotePrice()*orderItem.getNumber();
            }
        }
        //返回订单总价
        return total;
    }

    //todo 1、查询所有订单然后遍历每个订单
    //todo 2、根据订单id查询所有订单项
    //todo 3、将查询出来的订单项绑定到Order的List<OrderItem> OrderItems
    @Override
    public void fill(List<Order> orderList) {
        for(Order order: orderList){
            fill(order);
        }

    }


    //步骤3 封装成方法 将查询出来的订单项绑定到Order的List<OrderItem> OrderItems
    //还有就是计算总价和产品总数
    public void fill(Order order){
        //根据该订单查询所有订单项
    List<OrderItem> orderItems=orderItemMapper.listOrderItemsByOrder(order);
        //因为查询所有订单时，每个订单实体类里的属性User是空的，所以需要查询该订单的用户绑定到 订单类的user
        User user = userMapper.getOne(order.getUid());
        order.setUser(user);
    float total=0;
    int totalNumber=0;
    int subNum=0;
    //遍历订单项 计算总价和总数  并且记录该订单有多少个订单项
    for(OrderItem orderItem:orderItems){
        //总计价格
        total+=orderItem.getNumber()*orderItem.getProduct().getPromotePrice();
        //总计数量
        totalNumber+=orderItem.getNumber();
        subNum++;
        //作用是把订单里的订单项的订单属性设置为空。
        //因为SpingMVC ( springboot 里内置的mvc框架是 这个东西)的 RESTFUL 注解，在把一个Order转换为json的同时，会把其对应的 orderItems 转换为 json数组，而 orderItem对象上有 order属性， 这个order 属性又会被转换为 json对象，然后这个 order 下又有 orderItems 。。。就这样就会产生无穷递归，系统就会报错了。
         orderItem.setOrder(null);
    }   //赋值给订单里的总价和总数
        order.setTotal(total);
        order.setTotalNumber(totalNumber);
        //该订单包含订单项数
        order.setSubNum(subNum);
        //订单与订单项绑定
        order.setOrderItems(orderItems);
    }


    //获取订单状态非 delete的 所有订单
    @Override
    public List<Order> listByUserWithoutDelete(User user) {
        //查询该用户的所有订单
        List<Order> orders = orderMapper.listOrdersByUserAndStatus(user.getId(), OrderService.delete);
        //1、遍历每个订单
        //2、根据订单id查询所有订单项
        //3、将查询出来的订单项绑定到Order的List<OrderItem> OrderItems
        fill(orders);
        return orders;
    }
   /* //将orderItem里的order属性置为null，防止出现递归报错 （处理多个order）
    @Override
    public void removeOrderFromOrderItem(List<Order> orders) {
        for(Order order:orders){
            removeOrderFromOrderItem(order);
        }
    }
    //将orderItem里的order属性置为null，防止出现递归报错 （处理单个order）
    @Override
    public void removeOrderFromOrderItem(Order order) {
        List<OrderItem> orderItems=order.getOrderItems();
        for(OrderItem orderItem:orderItems){
            orderItem.setOrder(null);
        }
    }
    //根据订单id计算订单总金额
    @Override
    public void total(Order order) {
        float total=0;
        List<OrderItem> orderItems = orderItemService.listOrderItemsByOrder(order);
        for(OrderItem orderItem:orderItems){
            total+=orderItem.getNumber()*orderItem.getProduct().getPromotePrice();
        }
        order.setTotal(total);
    }*/

}
