package com.jason.mapper;

import com.jason.pojo.Product;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 我不管我最帅 on 2019/3/29.
 */
@Repository
public interface ProductMapper {
    //todo 根据分类查询产品
    @Select("select * from product where cid=#{cid}")
    @Results({
              @Result(property ="category", column ="cid",one=@One(select = "com.jason.mapper.CategoryMapper.getOne"))
    })
    public List<Product> listByCategory(int cid);
    //todo 增加产品
    @Insert("insert into product(name,subTitle,originalPrice,promotePrice,stock,cid,createDate) values(#{name},#{subTitle},#{originalPrice},#{promotePrice},#{stock},#{cid},#{createDate})")
    @SelectKey(statement="SELECT LAST_INSERT_ID() AS id", keyProperty="id", before=false, resultType=int.class)
    public void add(Product product);
    //todo 删除产品
    @Delete("delete from product where id=#{id}")
    public void delete(int id);
    //todo 获取一个产品
    @Select("select * from product where id=#{id}")
    public Product getOne(int id);
    //todo 修改产品
    @Update("update product set name=#{name},subTitle=#{subTitle},originalPrice=#{originalPrice},promotePrice=#{promotePrice},stock=#{stock},createDate=#{createDate} where id=#{id}")
    public void update(Product product);
}
