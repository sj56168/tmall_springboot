package com.jason.pojo;

import java.util.Date;
import java.util.List;

/**
 * Created by 我不管我最帅 on 2019/3/28.
 */
public class Product {
    private int id;
    private String name;
    private String subTitle;
    private float originalPrice;
    private float promotePrice;
    private int stock;
    private Date createDate;
    private Category category; //多对一
    private int cid;
    private ProductImage firstProductImage; //图片首图 主要是获取id
    private List<ProductImage> productSingleImages;//单个产品集合
    private List<ProductImage> productDetailImages;//产品详情图片集合
    private int saleCount;//销量
    private int reviewCount;//累计评价

    public List<ProductImage> getProductSingleImages() {
        return productSingleImages;
    }

    public void setProductSingleImages(List<ProductImage> productSingleImages) {
        this.productSingleImages = productSingleImages;
    }

    public List<ProductImage> getProductDetailImages() {
        return productDetailImages;
    }

    public void setProductDetailImages(List<ProductImage> productDetailImages) {
        this.productDetailImages = productDetailImages;
    }

    public int getSaleCount() {
        return saleCount;
    }

    public void setSaleCount(int saleCount) {
        this.saleCount = saleCount;
    }

    public int getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(int reviewCount) {
        this.reviewCount = reviewCount;
    }

    public ProductImage getFirstProductImage() {
        return firstProductImage;
    }

    public void setFirstProductImage(ProductImage firstProductImage) {
        this.firstProductImage = firstProductImage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public float getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(float originalPrice) {
        this.originalPrice = originalPrice;
    }

    public float getPromotePrice() {
        return promotePrice;
    }

    public void setPromotePrice(float promotePrice) {
        this.promotePrice = promotePrice;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Product{" +
                  "id=" + id +
                  ", name='" + name + '\'' +
                  ", subTitle='" + subTitle + '\'' +
                  ", originalPrice=" + originalPrice +
                  ", promotePrice=" + promotePrice +
                  ", stock=" + stock +
                  ", createDate=" + createDate +
                  ", category=" + category +
                  ", cid=" + cid +
                  ", firstProductImage=" + firstProductImage +
                  '}';
    }
}
