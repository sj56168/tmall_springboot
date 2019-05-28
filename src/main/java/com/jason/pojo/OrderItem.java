package com.jason.pojo;

/**
 * Created by 我不管我最帅 on 2019/3/31.
 * 订单项实体类
 */
public class OrderItem {
    private int id;//订单项id
    private Product product;//关联产品
    private User user;//关联用户
    private Order order;//关联订单
    private int number;//产品数量

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                  "id=" + id +
                  ", product=" + product +
                  ", user=" + user +
                  ", order=" + order +
                  ", number=" + number +
                  '}';
    }
}
