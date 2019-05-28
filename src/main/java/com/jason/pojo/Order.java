package com.jason.pojo;

import com.jason.service.OrderService;

import java.util.Date;
import java.util.List;

/**
 * Created by 我不管我最帅 on 2019/3/31.
 *  订单实体类
 */
public class Order {
private int id;//订单id
    private String orderCode;//订单编号
    private String address;//订单地址
    private String post;//邮编
    private String receiver;//收件人
    private String mobile;//联系电话
    private String userMessage;//备注
    private Date createDate;//创建日期
    private Date payDate;//支付日期
    private Date deliveryDate;//发货日期
    private Date confirmDate;//确认收货日期
    private String status;//订单状态
    private User user;//订单所对应的用户
    private List<OrderItem> orderItems;//该订单下的订单项列表
    private float total;//该订单总计金额
    private int totalNumber;//该订单总计数量
    private String statusDesc;
    private int uid; //用户id 外键
    private int subNum;//记录该订单的订单项数

    public int getSubNum() {
        return subNum;
    }

    public void setSubNum(int subNum) {
        this.subNum = subNum;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Date getConfirmDate() {
        return confirmDate;
    }

    public void setConfirmDate(Date confirmDate) {
        this.confirmDate = confirmDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public int getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(int totalNumber) {
        this.totalNumber = totalNumber;
    }

    //订单状态转成中文提示
    public String getStatusDesc() {
        if(null!=statusDesc)
            return statusDesc;
        String desc ="未知";
        switch(status){
            case OrderService.waitPay:
                desc="待付款";
                break;
            case OrderService.waitDelivery:
                desc="待发货";
                break;
            case OrderService.waitConfirm:
                desc="待收货";
                break;
            case OrderService.waitReview:
                desc="待评价";
                break;
            case OrderService.finish:
                desc="完成";
                break;
            case OrderService.delete:
                desc="刪除";
                break;
            default:
                desc="未知";
        }
        statusDesc = desc;
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    @Override
    public String toString() {
        return "Order{" +
                  "id=" + id +
                  ", orderCode='" + orderCode + '\'' +
                  ", address='" + address + '\'' +
                  ", post='" + post + '\'' +
                  ", receiver='" + receiver + '\'' +
                  ", mobile='" + mobile + '\'' +
                  ", userMessage='" + userMessage + '\'' +
                  ", createDate=" + createDate +
                  ", payDate=" + payDate +
                  ", deliveryDate=" + deliveryDate +
                  ", confirmDate=" + confirmDate +
                  ", status='" + status + '\'' +
                  ", user=" + user +
                  ", orderItems=" + orderItems +
                  ", total=" + total +
                  ", totalNumber=" + totalNumber +
                  '}';
    }
}
