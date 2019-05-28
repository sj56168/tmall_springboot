package com.jason.comparator;

import com.jason.pojo.Product;

import java.util.Comparator;

/**
 * Created by 我不管我最帅 on 2019/4/10.
 *  销量比较器
 把 销量高的放前面
 */
public class ProductSaleCountComparator implements Comparator<Product> {
    @Override
    public int compare(Product p1, Product p2) {

        return p2.getSaleCount()-p1.getSaleCount();
    }
}
