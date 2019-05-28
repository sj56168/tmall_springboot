package com.jason.comparator;

import com.jason.pojo.Product;

import java.util.Comparator;

/**
 * Created by 我不管我最帅 on 2019/4/10.
 *  价格比较器
 把 价格低的放前面
 */
public class ProductPriceComparator implements Comparator<Product> {
    @Override
    public int compare(Product p1, Product p2) {
        /*p1<p2<p3*/
        return (int) (p1.getPromotePrice()-p2.getPromotePrice());
    }
}
