package com.jason.pojo;

/**
 * Created by 我不管我最帅 on 2019/4/1.
 */
public class ProductImage {
    private int id;
    private Product product;
    private String type;
    private int pid;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ProductImage{" +
                  "id=" + id +
                  ", product=" + product +
                  ", type='" + type + '\'' +
                  ", pid=" + pid +
                  '}';
    }
}
