package com.jason.controller;

import com.jason.pojo.Product;
import com.jason.pojo.ProductImage;
import com.jason.service.ProductImageService;
import com.jason.service.ProductService;
import com.jason.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by 我不管我最帅 on 2019/4/1.
 */
@RestController
public class ProductImageController {
    @Autowired
    ProductImageService productImageService;
    @Autowired
    ProductService productService;
    //获取产品图片
    @GetMapping("productImages/{pid}")
    public List<ProductImage> list(@RequestParam("type")String type, @PathVariable(value = "pid")int pid)throws  Exception{
        System.out.println(pid);
        Product product=productService.getOne(pid);
        System.out.println(product);
        if(productImageService.type_single.equals(type)){
            List<ProductImage> singleImages=productImageService.listSingleProductImages(product.getId());
            Iterator<ProductImage> iterator=singleImages.iterator();
            while(iterator.hasNext()){
                ProductImage productImage=iterator.next();
                System.out.println(productImage.toString());
            }
            return singleImages;
        }
        else if(productImageService.type_detail.equals(type)){
            List<ProductImage> detailImages=productImageService.listDetailProductImages(product.getId());
            Iterator<ProductImage> iterator=detailImages.iterator();
            while(iterator.hasNext()){
                ProductImage productImage=iterator.next();
                System.out.println(productImage.toString());
            }
            return detailImages;
        }
        else{
            return new ArrayList<>();
        }
    }
    //增加图片
    @PostMapping("productImages")
    public Object add(@RequestParam("pid") int pid, @RequestParam("type") String type, MultipartFile image, HttpServletRequest request)throws Exception{
        ProductImage productImage=new ProductImage();
       Product product=productService.getOne(pid);
       productImage.setProduct(product);
       productImage.setType(type);
       productImage.setPid(product.getId());
       //放入数据库
        productImageService.add(productImage);
        String folder="static/img/";
        //判断上传的文件是单个还是详情
        if(productImageService.type_single.equals(productImage.getType())){
            //单个图片文件夹
            folder+="productSingle";
        }else{
            //详情图片文件夹
            folder+="productDetail";
        }
        File imageFolder=new File(request.getServletContext().getRealPath(folder));
        File file=new File(imageFolder,productImage.getId()+".jpg");
        String fileName=file.getName();
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        try{
            //从内存复制到文件里面
            image.transferTo(file);
            BufferedImage img= ImageUtil.change2jpg(file);
            //以jpg的格式覆盖原先的图片
            ImageIO.write(img,"jpg",file);

        }catch (IOException e){
            e.printStackTrace();
        }
        //另外生成中小尺寸的图片
        if(productImageService.type_single.equals(productImage.getType())){
            String imageFolder_small="static/img/productSingle/productSingle_small";
            String imageFolder_middle="static/img/productSingle/productSingle_middle";
            File f_small=new File(request.getServletContext().getRealPath(imageFolder_small),fileName);
            File f_middle=new File(request.getServletContext().getRealPath(imageFolder_middle),fileName);
            if (!f_small.getParentFile().exists()) {
                f_small.getParentFile().mkdirs();
            }
            if (!f_middle.getParentFile().exists()) {
                f_middle.getParentFile().mkdirs();
            }
            //改变原图片的尺寸然后复制到f_small和f_middle
            ImageUtil.resizeImage(file,56,56,f_small);
            ImageUtil.resizeImage(file,217,190,f_middle);

        }
        return  productImage;
    }
    //todo 删除
    @DeleteMapping("productImages/{id}")
    public String  delete(@PathVariable("id")int id,HttpServletRequest request)throws Exception{
        ProductImage productImage=productImageService.getOne(id);
        productImageService.delete(id);
        String floder="static/img/";
        if(productImageService.type_single.equals(productImage.getType())){
            floder+="productSingle";
        }else{
            floder+="productDetail";
        }
        File imageFloder=new File(request.getServletContext().getRealPath(floder));
        File file=new File(imageFloder,productImage.getId()+".jpg");
        //获取图片名
        String fileName = file.getName();
        file.delete();
        if(productImageService.type_single.equals(productImage.getType())){
            String imageFolder_small="static/img/productSingle/productSingle_small";
            String imageFolder_middle="static/img/productSingle/productSingle_middle";
            File f_small=new File(request.getServletContext().getRealPath(imageFolder_small),fileName);
            File f_middle=new File(request.getServletContext().getRealPath(imageFolder_middle),fileName);
            f_small.delete();
            f_middle.delete();
        }
        return  null;
    }
}
