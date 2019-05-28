package com.jason.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jason.pojo.Category;
import com.jason.service.CategoryService;

import com.jason.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * Created by 我不管我最帅 on 2019/3/18.
 */
@RestController
public class CategoryController {
    @Autowired
    CategoryService categoryService;
/*    @RequestMapping("/category")
    public List<Category> listCategory(){
        List<Category> categories = categoryService.list();
        return categories;
    }*/
@GetMapping("categories/{id}")
public Category getOne(@PathVariable(value = "id") int id){
    return categoryService.getOne(id);
}
    //todo 分页查询
    @GetMapping("/categories")
    public PageInfo<Category> list(@RequestParam(value = "start",defaultValue = "1") int start, @RequestParam(value="pageSize",defaultValue = "3") int pageSize)throws Exception{
        PageHelper.startPage(start,pageSize,"id desc");
        List<Category> list=categoryService.list();
        PageInfo<Category> page=new PageInfo<>(list,3);
        Iterator<Category> iterator=page.getList().iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next().getName());
        }
        return page;
    }
    //todo 增加分类
    @PostMapping("categories")
    public Object add(Category category,MultipartFile image, HttpServletRequest request) throws Exception{
        System.out.println("image::::"+image);
        //存入数据库
        if(image!=null){
            //刚开始id是null 插入成功后自动获取id
            categoryService.add(category);
            //图片传到文件夹 并且转格式
            saveOrUpdateImageFile(category,image,request);
        }
        return  category;
    }
    //上传或修改图片
    public void saveOrUpdateImageFile(Category category, MultipartFile image,HttpServletRequest request) throws IOException {
        File imageFolder=new File(request.getServletContext().getRealPath("static/img/category"));
        System.out.println("imgage::::"+image);
        System.out.println("ID:::"+category.getId());
        if(image==null){
            return;
        }
        else {
            //文件名称
            File file = new File(imageFolder,  category.getId() + ".jpg");
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            //springboot把浏览器上传的文件放到临时文件夹，transferTo就是把这个临时文件复制到file这个位置,该方法结束临时文件自动被删除掉
            image.transferTo(file);
            //运用工具类转换成jpg格式
            BufferedImage img = ImageUtil.change2jpg(file);
            ImageIO.write(img, "jpg", file);
        }
    }
    //todo 删除分类
    @DeleteMapping("categories/{id}")
    public String deleteCategory(@PathVariable("id")int id,HttpServletRequest request){
        //删除分类
        categoryService.delete(id);
        File imageFolder=new File(request.getServletContext().getRealPath("static/img/category"));
        File file=new File(imageFolder,id+".jpg");
        file.delete();
        //删除图片图片
        return null; //return null浏览器控制台会报错：xml解析错误
    }
    //todo 修改分类
    @PutMapping("/categories/{id}")
    public String updateCategory(Category category,MultipartFile image,HttpServletRequest request) throws Exception{
        System.out.println(category.getId()+"：：："+category.getName());
        categoryService.update(category);
        System.out.println("imgae::::"+image);
        //如果有传入图片则更新
        if(image!=null){
            saveOrUpdateImageFile(category,image,request);
        }
        return "redirect:listCategory";
    }

}
