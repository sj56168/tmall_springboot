package com.jason.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jason.pojo.Category;
import com.jason.pojo.Property;
import com.jason.service.CategoryService;
import com.jason.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

/**
 * Created by 我不管我最帅 on 2019/3/27.
 */
@RestController
public class PropertyController {
    @Autowired
    PropertyService propertyService;
    //分页查询
    @GetMapping("/properties/{cid}")
    public PageInfo<Property> list(@PathVariable("cid")int cid,@RequestParam(value = "start",defaultValue = "1")int start,@RequestParam(value = "pageSize",defaultValue = "3")int pageSize)throws Exception{
        PageHelper.startPage(start,pageSize);
          System.out.println(cid+"::::"+start+"::::"+pageSize);
        //根据分类id查询该分类所有属性
        /*  Category category = categoryService.getPropertyByCategory(cid);
        System.out.println("分类ID:::"+category.getId());
        //获取该分类下的所有属性
        List<Property> properties = category.getProperties();*/
        List<Property> properties=propertyService.listByCategory(cid);
        PageInfo<Property> page=new PageInfo<>(properties,3);
        Iterator<Property> iterator=page.getList().iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next().getName());
        }
        return page;
    }
    //新增属性
    @PostMapping("properties")
    public Object add(@RequestBody  Property property) throws Exception{
    propertyService.add(property);
    return property;
    }
    //删除属性
    @DeleteMapping("properties/{id}")
    public String delete(@PathVariable("id") int id) throws Exception{
        propertyService.delete(id);
        return null; //返回空 浏览器会报找不到根元素
    }
    //修改属性 提交的是json数据，必须@RequestBody转成对象
    @PutMapping("properties")
    public Object update(@RequestBody  Property property){
    propertyService.update(property);
    return property;
    }

}
