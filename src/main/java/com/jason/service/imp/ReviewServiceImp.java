package com.jason.service.imp;

import com.jason.mapper.ReviewMapper;
import com.jason.pojo.Review;
import com.jason.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 我不管我最帅 on 2019/4/9.
 */
@Service
public class ReviewServiceImp implements ReviewService {
    @Autowired
    ReviewMapper reviewMapper;
    //增加评论
    @Override
    public void addReview(Review review) {
        reviewMapper.addReview(review);
    }
    //通过产品获取评价
    @Override
    public List<Review> listReviewByProduct(int pid) {
        return reviewMapper.listReviewByProduct(pid);
    }
    //根据产品获取评价数
    @Override
    public int reviewCounts(int pid) {
        return reviewMapper.reviewCounts(pid);
    }
}
