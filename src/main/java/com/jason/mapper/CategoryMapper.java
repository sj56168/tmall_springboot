package com.jason.mapper;

import com.jason.pojo.Category;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 我不管我最帅 on 2019/3/22.
 */
@Repository
public interface CategoryMapper {
    //todo 查询所有
    @Select(" SELECT * from category")
    public List<Category> list();
    //todo 增加 select key 获取自增id
    @Insert("insert into category(name) value(#{name})")
    @SelectKey(statement="SELECT LAST_INSERT_ID() AS id", keyProperty="id", before=false, resultType=int.class)
    public int add(Category category);  //@SelectKey 插入后获取自增id
    //todo 删除
    @Delete("delete from category where id=#{id}")
    public void delete(int id);
    //todo 修改
    @Update("update category set name=#{name} where id=#{id}")
    public void update(Category category);
    //todo 根据id获取分类
    @Select("select * from category where id=#{id}")
    public Category getOne(int id);

    //todo 根据分类id获取该分类所有属性（一对多：一个分类对应对多个属性）但是pageHelper不支持嵌套结果映射（即不支持一对多）
    @Select("select * from category where id=#{id}")
    @Results({
              @Result(property = "id",column = "id"),
              @Result(property = "properties",javaType =List.class,column = "id",many = @Many(select="com.jason.mapper.PropertyMapper.listByCategory"))
    })
    public Category getAllPropertyByCategory(int id);

    //todo 根据分类id获取该分类所有产品（一对多：一个分类对应对多个产品）
    @Select("select * from category where id=#{id}")
    @Results({
              @Result(property = "id",column = "id"),
              @Result(property = "products",javaType =List.class,column = "id",many = @Many(select="com.jason.mapper.ProductMapper.listByCategory"))
    })
    public Category getAllProductsByCategory(int id);

}
