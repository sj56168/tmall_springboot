package com.jason.pojo;

/**
 * Created by 我不管我最帅 on 2019/3/30.
 */
public class PropertyValue {
    private int id;//主键
    private String value;
    private int pid; //产品id 外键
    private int ptid;//属性id 外键
    private Product product;
    private Property property;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getPtid() {
        return ptid;
    }

    public void setPtid(int ptid) {
        this.ptid = ptid;
    }
}
