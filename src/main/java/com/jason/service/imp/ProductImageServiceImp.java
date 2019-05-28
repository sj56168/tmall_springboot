package com.jason.service.imp;

import com.jason.mapper.ProductImageMapper;
import com.jason.pojo.OrderItem;
import com.jason.pojo.Product;
import com.jason.pojo.ProductImage;
import com.jason.service.ProductImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 我不管我最帅 on 2019/4/1.
 */
@Service
public class ProductImageServiceImp implements ProductImageService {

    @Autowired
    ProductImageMapper productImageMapper;
    //todo 获取一个产品图片实体类
    @Override
    public ProductImage getOne(int id) {
        return productImageMapper.getOne(id);
    }

    @Override
    public void add(ProductImage productImage) {
    productImageMapper.add(productImage);
    }

    @Override
    public void delete(int id) {
        productImageMapper.delete(id);
    }
    //todo 根据产品id和图片类型获取该产品的单个图片
    @Override
    public List<ProductImage> listSingleProductImages(int id) {
        return productImageMapper.listSingleProductImages(id,type_single);
    }
    //todo 根据产品id和图片类型获取该产品详情图片
    @Override
    public List<ProductImage> listDetailProductImages(int id) {
        return productImageMapper.listDetailProductImages(id,type_detail);
    }
    //todo  为多个产品设置首图：从该产品的产品图片里取出一张当作产品的首图
    public void setFirstProdutImages(List<Product> products){
        for(Product product:products){
            setFirstProdutImage(product);
        }
    }
    //todo 为单个产品设置首图
    @Override
    public void setFirstProdutImage(Product product){
        //根据产品id查询该产品的所有单个图片
    List<ProductImage> singleImages=listSingleProductImages(product.getId());
    //选取第一张作为产品首图
    if(!singleImages.isEmpty()){
        //productImage类里只存放图片id 和 产品id和图片类型，页面显示图片是路径拼 图片id的方式来显示的
        //setFirstProductImage的目的就是在里面存放图片的id
        product.setFirstProductImage(singleImages.get(0));
    }
    else{
        product.setFirstProductImage(new ProductImage());
    }
    }
    //todo 为订单项设置首图
    @Override
    public void setFirstProductImageOnOrderItems(List<OrderItem> orderItems) {
        for(OrderItem orderItem:orderItems){
            setFirstProdutImage(orderItem.getProduct());
        }
    }
}
