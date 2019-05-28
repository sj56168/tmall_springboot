package com.jason.mapper;

import com.jason.pojo.Review;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 我不管我最帅 on 2019/4/9.
 */
@Repository
public interface ReviewMapper {
    //todo 根据产品id 查询所有评价
    @Select("select * from review where pid=#{pid}")
    @Results({
              @Result(property = "product",column = "pid",one = @One(select = "com.jason.mapper.ProductMapper.getOne"))
    })
    public List<Review> listReviewByProduct(int pid);
    //todo 累计评价数
    @Select("select count(*) from review where pid=#{pid}")
    int reviewCounts(int pid);
    //todo 发布评价
    @Insert("insert into review(content,uid,pid,createDate) values(#{content},#{user.id},#{product.id},#{createDate})")
    void addReview(Review review);
}
