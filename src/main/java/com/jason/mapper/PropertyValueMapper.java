package com.jason.mapper;

import com.jason.pojo.Product;
import com.jason.pojo.Property;
import com.jason.pojo.PropertyValue;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 我不管我最帅 on 2019/3/30.
 */
@Repository
public interface PropertyValueMapper {
    //todo 根据产品id查询该产品所有属性值   产品 属性 两个多对一
    @Select("select * from propertyvalue where pid=#{pid}")
    @Results({
              @Result(property = "property", column = "ptid", one = @One(select = "com.jason.mapper.PropertyMapper.getOne")),
              @Result(property = "product", column = "pid", one = @One(select = "com.jason.mapper.ProductMapper.getOne"))
    })
    List<PropertyValue> listPropertyValue(int pid);

    //todo 根据属性id 和产品id 获取一个属性值
    @Select("select * from propertyvalue where pid=#{pid} and ptid=#{ptid}")
    PropertyValue getPropertyValue(@Param(value = "pid") int pid, @Param(value = "ptid") int ptid);

    //todo 增加 初始化需要用到
    @Insert("insert into propertyvalue(pid,ptid,value) values(#{pid},#{ptid},#{value})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID() AS id", keyProperty = "id", before = false, resultType = int.class)
    void add(PropertyValue propertyValue);

    //todo 修改
    @Update("update propertyvalue set value=#{value} where id=#{id}")
    void update(PropertyValue propertyValue);


}
