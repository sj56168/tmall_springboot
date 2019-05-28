package com.jason.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.javafx.beans.IDProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by 我不管我最帅 on 2019/3/18.
 */
public class Category {
    private int id;
    private String name;
    private List<Property> properties;//一对多（一个分类有多种属性）
    //前台需要
    private List<Product> products;//一对多 一个分类对应多个产品
    private List<List<Product>> productByRow;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<List<Product>> getProductByRow() {
        return productByRow;
    }

    public void setProductByRow(List<List<Product>> productByRow) {
        this.productByRow = productByRow;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "Category{" +
                  "id=" + id +
                  ", name='" + name + '\'' +
                  ", properties=" + properties +
                  '}';
    }
}
