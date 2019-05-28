package com.jason.service;

import com.jason.pojo.Category;
import com.jason.pojo.Product;

import java.util.List;

/**
 * Created by 我不管我最帅 on 2019/3/18.
 */
public interface CategoryService {
    public List<Category> list();
    public int add(Category category);
    public void delete(int id);
    public void update(Category category);
    // 根据分类id获取该分类所有属性（一对多：一个分类对应对多个属性）
    public Category getAllPropertyByCategory(int id);
    public Category getOne(int id);
    //todo 删除Product对象上的 分类
    void removeCategoryFromProduct(Category category);
    void removeCategoryFromProducts(List<Category> categories);
}
