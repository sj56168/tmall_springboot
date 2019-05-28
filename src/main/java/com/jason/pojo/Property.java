package com.jason.pojo;

/**
 * Created by 我不管我最帅 on 2019/3/27.
 */
public class Property {
    // 分类跟属性是 一对多 ：即一个分类有多种属性
    private int id;
    private String name;
    private int cid;//外键 即分类的主键
    private Category category;
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

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Property{" +
                  "id=" + id +
                  ", name='" + name + '\'' +
                  ", cid=" + cid +
                  ", category=" + category +
                  '}';
    }
}
