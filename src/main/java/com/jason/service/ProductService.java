package com.jason.service;

import com.jason.pojo.Category;
import com.jason.pojo.Product;

import java.util.List;

/**
 * Created by 我不管我最帅 on 2019/3/29.
 */
public interface ProductService {
    // todo 根据分类id查询该分类所有产品
    public List<Product> listByCategory(int cid);
    //todo 增加产品
    public void add(Product product);
    //todo 删除产品
    public void delete(int id);
    //todo 获取一个产品
    public Product getOne(int id);
    //todo 修改产品
    public void update(Product product);
    //todo 为分类填充产品集合 （处理一个分类）
    void fill(Category category);
    //todo 为分类填充产品集合 （处理多个分类）
    void fill(List<Category> categories);
    //todo 为多个分类填充推荐产品集合，即把分类下的产品集合，按照8个为一行，拆成多行，以利于后续页面上进行显示
    void fillByRow(List<Category> categories);
    //todo 为产品设置销量和评价数 (处理一个产品)
    void setSaleAndReviewNumber(Product product);
    //todo 为产品设置销量和评价数 (处理多个产品) 注：首页需要这个业务
    void setSaleAndReviewNumber(List<Product> products);
}
