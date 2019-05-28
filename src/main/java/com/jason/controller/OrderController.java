package com.jason.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jason.pojo.Order;
import com.jason.pojo.OrderItem;
import com.jason.service.OrderItemService;
import com.jason.service.OrderService;
import com.jason.service.ProductImageService;
import com.jason.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by 我不管我最帅 on 2019/3/31.
 */
@RestController
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    OrderItemService orderItemService;
    @Autowired
    ProductImageService productImageService;
    @GetMapping("/orders")
    public PageInfo<Order> list(@RequestParam(value = "start",defaultValue = "1")int start,@RequestParam(value = "pageSize",defaultValue = "3")int pageSize)throws Exception{
        PageHelper.startPage(start,pageSize);
        List<Order> orderList = orderService.listOrders();
        //给订单类的List<OrderItem> orderitems绑定数据
        orderService.fill(orderList);
        PageInfo<Order> page=new PageInfo<>(orderList,3);
        //为每个订单的订单项设置图片
        for(int i=0;i<page.getSize();i++){//遍历当前页的每个订单，page.getSize()返回的是当前页加载出来的数据的条数
        for(int j=0;j<page.getList().get(i).getSubNum();j++){//遍历该订单的所有订单项，getSubNum()是记录该订单所包含的订单项数
            //调用service层 给当前订单项里的product里的firstProdutImage属性设值
            productImageService.setFirstProdutImage(page.getList().get(i).getOrderItems().get(j).getProduct());
        }
        }
        if(page.getList().get(0).getOrderItems()!=null){

        Iterator<OrderItem> iterator = page.getList().get(0).getOrderItems().iterator();
        while(iterator.hasNext()){
            OrderItem orderItem=iterator.next();
            System.out.println(orderItem.toString());
        }

        }
        return page;
    }
    //订单发货：获取订单id 然后修改订单状态
    @PutMapping("deliverOrder/{oid}")
    public Object deliveryOrder(@PathVariable("oid")int oid) throws Exception{
    Order order=orderService.getOne(oid);
    order.setDeliveryDate(new Date());
    //订单状态设置为待收货
    order.setStatus(orderService.waitConfirm);
    orderService.update(order);
    return Result.success();
    }
}
