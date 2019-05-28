package com.jason.pojo;

import java.util.Date;

/**
 * Created by 我不管我最帅 on 2019/4/9.
 *     评价表
 */
public class Review {
private int id;//id
private String content;//评论内容
private User user;//用户 外键
private Product product;//产品 外键
private Date createDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
