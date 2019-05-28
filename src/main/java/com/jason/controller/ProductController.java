package com.jason.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jason.pojo.Product;
import com.jason.service.ProductImageService;
import com.jason.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

/**
 * Created by 我不管我最帅 on 2019/3/29.
 */
@RestController
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    ProductImageService productImageService;
    //分页查询
    @GetMapping("/products/{cid}")
    public PageInfo<Product> list(@PathVariable("cid")int cid, @RequestParam(value = "start",defaultValue = "1")int start, @RequestParam(value = "pageSize",defaultValue = "3")int pageSize)throws Exception{
        PageHelper.startPage(start,pageSize);
        System.out.println(cid+"::::"+start+"::::"+pageSize);
        //获取该分类下的所有产品
        List<Product> products=productService.listByCategory(cid);
        PageInfo<Product> page=new PageInfo<>(products,3);
        //给产品设置首图
        productImageService.setFirstProdutImages(page.getList());
        Iterator<Product> iterator=page.getList().iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next().getName());
        }
        return page;
    }
    //新增属性
    @PostMapping("products")
    public Object add(@RequestBody  Product product) throws Exception{
        productService.add(product);
        return product;
    }
    //删除属性
    @DeleteMapping("products/{id}")
    public String delete(@PathVariable("id") int id) throws Exception{
        productService.delete(id);
        return null; //返回空 浏览器会报找不到根元素
    }
    //修改属性 提交的是json数据，必须@RequestBody转成对象
    @PutMapping("products")
    public Object update(@RequestBody  Product product){
        productService.update(product);
        return product;
    }
    //根据产品id获取一个产品
    @RequestMapping("products")
    public Product getOne(@RequestParam("id") int id){
        return productService.getOne(id);
    }
}
