package com.jason.service.imp;

import com.jason.mapper.CategoryMapper;
import com.jason.mapper.PropertyValueMapper;
import com.jason.pojo.Category;
import com.jason.pojo.Product;
import com.jason.pojo.Property;
import com.jason.pojo.PropertyValue;
import com.jason.service.CategoryService;
import com.jason.service.PropertyValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

/**
 * Created by 我不管我最帅 on 2019/3/30.
 */
@Service
public class PropertyValueServiceImp implements PropertyValueService {
    @Autowired
    CategoryMapper categoryMapper;
    @Autowired
    PropertyValueMapper propertyValueMapper;
    //todo 初始化
    @Override
    public void init(Product product) {
        //1、从产品拿到分类id 然后根据分类id 获取该分类下所有属性
        Category category = categoryMapper.getAllPropertyByCategory(product.getCid());
        List<Property> properties=category.getProperties();
        //2、根据属性id 和产品id去查询，属性值表里是否已经存在
        for(Property property:properties){
            PropertyValue propertyValue=propertyValueMapper.getPropertyValue(product.getId(),property.getId());
            if(null==propertyValue){
                //如果不存在则插入
                PropertyValue propertyValue1=new PropertyValue();
                propertyValue1.setPid(product.getId());
                propertyValue1.setPtid(property.getId());
                propertyValue1.setValue("未设置");
                propertyValueMapper.add(propertyValue1);
            }
        }

    }
    //todo 根据产品id 查询所有属性值
    @Override
    public List<PropertyValue> listPropertyValue(int pid) {
        return propertyValueMapper.listPropertyValue(pid);
    }
    //todo 修改
    @Override
    public void update(PropertyValue propertyValue) {
        propertyValueMapper.update(propertyValue);
    }
 /*  //todo 根据属性id和产品id获取单个属性值
    @Override
    public PropertyValue getPropertyValue(int pid, int ptid) {
        return propertyValueMapper.getPropertyValue(pid,ptid);
    }
    */
}
