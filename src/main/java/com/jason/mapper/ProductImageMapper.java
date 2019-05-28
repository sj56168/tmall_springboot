package com.jason.mapper;

import com.jason.pojo.Product;
import com.jason.pojo.ProductImage;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 我不管我最帅 on 2019/4/1.
 */
@Repository
public interface ProductImageMapper {
    //todo 获取一个产品图片实体类
    @Select("select * from productimage where id=#{id}")
    ProductImage getOne(int id);
    //todo 增加 自增id
    @Insert("insert into productimage(pid,type) values(#{pid},#{type})")
    @SelectKey(statement="SELECT LAST_INSERT_ID() AS id", keyProperty="id", before=false, resultType=int.class)
    void add(ProductImage productImage);
    //todo 删除
    @Delete("delete from productimage where id=#{id}")
    void delete(int id);
    //todo 根据产品id和图片类型获取该产品的单个图片
    @Select("select * from productimage where pid=#{id} and type=#{single}")
    List<ProductImage> listSingleProductImages(@Param(value = "id")int pid,@Param(value = "single") String type_single);
    //todo 根据产品id和图片类型获取该产品详情图片
    @Select("select * from productimage where pid=#{id} and type=#{detail}")
    List<ProductImage> listDetailProductImages(@Param(value = "id")int pid,@Param(value = "detail") String type_detail);



}
