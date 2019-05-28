package com.jason.service;

import com.jason.pojo.OrderItem;
import com.jason.pojo.Product;
import com.jason.pojo.ProductImage;

import java.util.List;

/**
 * Created by 我不管我最帅 on 2019/4/1.
 */
public interface ProductImageService {
    public static final String type_single = "single";
    public static final String type_detail = "detail";
    //todo 获取一个产品图片实体类
   ProductImage getOne(int id);
    //todo 增加 自增id
   void add(ProductImage productImage);
    //todo 删除
   void delete(int id);
    //todo 根据产品id和图片类型获取该产品的单个图片
    List<ProductImage> listSingleProductImages(int id);
    //todo 根据产品id和图片类型获取该产品详情图片
    List<ProductImage> listDetailProductImages(int id);
    //todo 为多个产品设置首图：List<Product> products  从产品图片里取一张 给每个产品设置首图
    public void setFirstProdutImages(List<Product> products);
    //todo 为单个产品设置首图 订单里的订单项显示图片需要用到
    public void setFirstProdutImage(Product product);
    //todo 为订单项设置首图
    public void setFirstProductImageOnOrderItems(List<OrderItem> onOrderItems);

}
