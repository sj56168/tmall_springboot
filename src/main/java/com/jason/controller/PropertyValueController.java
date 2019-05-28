package com.jason.controller;

import com.jason.pojo.Product;
import com.jason.pojo.PropertyValue;
import com.jason.service.ProductService;
import com.jason.service.PropertyValueService;
import org.apache.shiro.web.session.HttpServletSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

/**
 * Created by 我不管我最帅 on 2019/3/30.
 */
@RestController
public class PropertyValueController {
    @Autowired
    ProductService productService;
    @Autowired
    PropertyValueService propertyValueService;
    //获取某一产品的所有属性值
    @GetMapping("propertyValues/{pid}")
    public List<PropertyValue> list(@PathVariable(value = "pid") int pid) throws Exception{
        System.out.println("pid:::"+pid);
        //1、获取产品
        Product product=productService.getOne(pid);
        System.out.println(product.toString());
        //2、根据产品id 初始化产品属性跟属性值
        propertyValueService.init(product);
        //3、根据产品id获取所有属性值
        List<PropertyValue> propertyValues = propertyValueService.listPropertyValue(pid);
        return propertyValues;
        }
        //todo 修改属性值
        @PutMapping("propertyValues")
    public Object  update(@RequestBody PropertyValue propertyValue) throws Exception{
        propertyValueService.update(propertyValue);
        return propertyValue;
        }

}
