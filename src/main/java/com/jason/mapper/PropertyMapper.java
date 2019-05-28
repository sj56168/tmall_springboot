package com.jason.mapper;

import com.jason.pojo.Property;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 我不管我最帅 on 2019/3/27.
 */
@Repository
public interface PropertyMapper {
    // todo 查询所有
    @Select("select * from property where cid=#{cid}")
/*@Results({
@Result(property = "category",column = "cid",one=@One(select = "com.jason.mapper.CategoryMapper.getOne"))
    })*/
    public List<Property> listByCategory(int cid);
    //todo 增加属性
    @Insert("insert into property(name,cid) values(#{name},#{cid})")
    @SelectKey(statement="SELECT LAST_INSERT_ID() AS id", keyProperty="id", before=false, resultType=int.class)
    public void add(Property property);
    //todo 删除属性
    @Delete("delete from property where id=#{id}")
    public void delete(int id);
    //todo 获取一个属性
    @Select("select * from property where id=#{id}")
    public Property getOne(int id);
    //todo 修改属性
    @Update("update property set name=#{name} where id=#{id}")
    public void update(Property property);

}
