package com.jason.service;

import com.jason.pojo.Property;

import java.util.List;

/**
 * Created by 我不管我最帅 on 2019/3/27.
 */
public interface PropertyService {
    // todo 根据分类id查询该分类所有属性
    public List<Property> listByCategory(int cid);
    //todo 增加属性
    public void add(Property property);
    //todo 删除属性
    public void delete(int id);
    //todo 获取一个属性
    public Property getOne(int id);
    //todo 修改属性
    public void update(Property property);
}
