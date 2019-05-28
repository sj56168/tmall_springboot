package com.jason.comparator;

import com.jason.pojo.Product;

import java.util.Comparator;

/**
 *
 *  ProductAllComparator 综合比较器
    把 销量x评价 高的放前面
 */
public class ProductAllComparator implements Comparator<Product>{
    @Override
    public int compare(Product p1, Product p2) {
        return p2.getSaleCount()*p2.getReviewCount()-p1.getSaleCount()*p1.getReviewCount();
    }
}
