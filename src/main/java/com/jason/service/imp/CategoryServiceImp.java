package com.jason.service.imp;

/*import com.jason.mapper.CategoryDao;*/
import com.jason.mapper.CategoryMapper;
import com.jason.pojo.Category;
import com.jason.pojo.Product;
import com.jason.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 我不管我最帅 on 2019/3/18.
 */
@Service
public class CategoryServiceImp implements CategoryService {
 /*   @Autowired
    CategoryDao categoryDAO;*/
    @Autowired
    CategoryMapper categoryMapper;
    @Override
    public List<Category> list() {
    return categoryMapper.list();
    }

    @Override
    public int add(Category category) {
        return categoryMapper.add(category);
    }

    @Override
    public void delete(int id) {
        categoryMapper.delete(id);
    }

    @Override
    public void update(Category category) {
        categoryMapper.update(category);
    }

    @Override
    public Category getOne(int id) {
        return categoryMapper.getOne(id);
    }
    @Override
    public Category getAllPropertyByCategory(int id) {
        return categoryMapper.getAllPropertyByCategory(id);
    }
    //todo 删除Product对象上的 分类 (处理一个分类)
    @Override
    public void removeCategoryFromProduct(Category category) {
    List<Product> products=category.getProducts();
    if(products!=null){
        for(Product product:products){
            product.setCategory(null);
        }
    }

    List<List<Product>> productsByRow=category.getProductByRow();
    if(productsByRow!=null){
        for(List<Product> productList :productsByRow){
            for(Product product:productList){
                product.setCategory(null);
            }
        }
    }
    }
    //todo 删除Product对象上的 分类 （处理多个分类）
    @Override
    public void removeCategoryFromProducts(List<Category> categories) {
     for(Category category:categories){
         removeCategoryFromProduct(category);
     }
    }

}
