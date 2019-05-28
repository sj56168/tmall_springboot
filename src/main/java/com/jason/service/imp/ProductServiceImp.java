package com.jason.service.imp;

import com.jason.mapper.CategoryMapper;
import com.jason.mapper.ProductMapper;
import com.jason.pojo.Category;
import com.jason.pojo.Product;
import com.jason.service.OrderItemService;
import com.jason.service.ProductImageService;
import com.jason.service.ProductService;
import com.jason.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 我不管我最帅 on 2019/3/29.
 */
@Service
public class ProductServiceImp implements ProductService {
    @Autowired
    ProductMapper productMapper;
    @Autowired
    CategoryMapper categoryMapper;
    @Autowired
    ProductImageService productImageService;
    @Autowired
    ReviewService reviewService;
    @Autowired
    OrderItemService orderItemService;

    @Override
    public List<Product> listByCategory(int cid) {
        return productMapper.listByCategory(cid);
    }

    @Override
    public void add(Product product) {
        productMapper.add(product);
    }

    @Override
    public void delete(int id) {
    productMapper.delete(id);
    }

    @Override
    public Product getOne(int id) {
        Product product = productMapper.getOne(id);
        Category category = categoryMapper.getOne(product.getCid());
        product.setCategory(category);
        return product;
    }

    @Override
    public void update(Product product) {
    productMapper.update(product);
    }
    //todo 为分类填充产品集合 （处理一个分类）
    @Override
    public void fill(Category category) {
        //查询出该分类的所有产品
        List<Product> products = listByCategory(category.getId());
        //给产品设置首图
        productImageService.setFirstProdutImages(products);
        category.setProducts(products);
    }
    //todo 为分类填充产品集合 （处理多个分类）
    @Override
    public void fill(List<Category> categories) {
    for(Category category:categories){
        fill(category);
    }
    }
    //todo 为多个分类填充推荐产品集合，即把分类下的产品集合，按照8个为一行，拆成多行，以利于后续页面上进行显示
    @Override
    public void fillByRow(List<Category> categories) {
        int productNumberEachRow=8;//每行8个
        for(Category category:categories){
            //获取某一分类下的所有产品
            List<Product> products=category.getProducts();
            List<List<Product>> productsByRow=new ArrayList<>();
            for(int i=0;i<products.size();i+=productNumberEachRow){
            int size=i+productNumberEachRow;

            size=products.size()<size?products.size():size;
            //每行取8个 剩余的不够八个也是一行
            List<Product> productsOfEachRow=products.subList(i,size);
            //加入列表
            productsByRow.add(productsOfEachRow);
            }
        category.setProductByRow(productsByRow);
        }

    }
    //todo 为产品设置销量和评价数 (处理一个产品)
    @Override
    public void setSaleAndReviewNumber(Product product) {
        //获取评价数并设置
        int reviewCounts = reviewService.reviewCounts(product.getId());
        product.setReviewCount(reviewCounts);
        //获取该产品销量并设置
        int saleCounts = orderItemService.getSaleCounts(product);
        product.setSaleCount(saleCounts);

    }
    //todo 为产品设置销量和评价数 (处理多个产品) 注：首页需要这个业务
    @Override
    public void setSaleAndReviewNumber(List<Product> products) {
        for(Product product:products){
            setSaleAndReviewNumber(product);

        }
    }
}
