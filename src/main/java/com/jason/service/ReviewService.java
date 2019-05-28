package com.jason.service;

import com.jason.pojo.Review;

import java.util.List;

/**
 * Created by 我不管我最帅 on 2019/4/9.
 */
public interface ReviewService {
    //todo 增加评论
    void addReview(Review review);

    //todo 通过产品获取评价
    List<Review> listReviewByProduct(int pid);
    //todo 根据产品获取评价数
    int reviewCounts(int pid);
}
