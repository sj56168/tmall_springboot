package com.jason.service;

import com.jason.pojo.Product;
import com.jason.pojo.PropertyValue;
import org.apache.ibatis.annotations.Param;
import java.util.List;
/**
 * Created by 我不管我最帅 on 2019/3/30.
 */
public interface PropertyValueService {
    //todo 初始化
    public void init(Product product);
  /*  //todo 获取一个属性值
    PropertyValue getPropertyValue(int pid,int ptid);*/
    //todo 根据产品id 查询所有属性
    List<PropertyValue> listPropertyValue(int pid);
    //todo 修改
     void update(PropertyValue propertyValue);

}
