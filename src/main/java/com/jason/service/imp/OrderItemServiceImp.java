package com.jason.service.imp;

import com.jason.mapper.OrderItemMapper;
import com.jason.pojo.Order;
import com.jason.pojo.OrderItem;
import com.jason.pojo.Product;
import com.jason.pojo.User;
import com.jason.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 我不管我最帅 on 2019/3/31.
 */
@Service
public class OrderItemServiceImp implements OrderItemService {
    @Autowired
    OrderItemMapper orderItemMapper;
    //todo 根据该订单查询所有订单项
    @Override
    public List<OrderItem> listOrderItemsByOrder(Order order) {
    return  orderItemMapper.listOrderItemsByOrder(order);
    }
    //todo 根据产品获取订单项
    @Override
    public List<OrderItem> listOrderItemsByProduct(Product product) {
        return orderItemMapper.listOrderItemsByProduct(product);
    }
    //todo 获取销量 ：即累加该产品每个订单项中该产品的购买数量即可算出该产品的销量
    @Override
    public int getSaleCounts(Product product) {
        //根据产品获取所有订单项
        List<OrderItem> list=listOrderItemsByProduct(product);
        int saleCounts=0;
        for(OrderItem item:list){
            if(null!=item.getOrder()){ //该订单必须存在
                if(item.getOrder().getPayDate()!=null){//并且完成支付
                    saleCounts+=item.getNumber();
                }
            }
        }
        return saleCounts;
    }
    //todo  根据用户获取订单项
    @Override
    public List<OrderItem> listByUser(User user) {
        return orderItemMapper.listByUser(user);
    }
    //增加订单项
    @Override
    public void add(OrderItem orderItem) {
        orderItemMapper.add(orderItem);
    }

    @Override
    public OrderItem getOne(int id) {
        return orderItemMapper.getOne(id);
    }
    //todo 修改(产品数跟订单id)
    @Override
    public void update(OrderItem orderItem) {
        orderItemMapper.update(orderItem);
    }

    @Override
    public void delete(int oiid) {
        orderItemMapper.delete(oiid);
    }
}
