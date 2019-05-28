package com.jason;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jason.mapper.CategoryMapper;
import com.jason.mapper.OrderItemMapper;
import com.jason.mapper.OrderMapper;
import com.jason.mapper.PropertyMapper;
import com.jason.pojo.Category;
import com.jason.pojo.Order;
import com.jason.pojo.OrderItem;
import com.jason.pojo.Property;
import com.jason.service.CategoryService;
import com.jason.service.PropertyService;
import com.jason.service.imp.CategoryServiceImp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootApplicationTests {
	@Autowired
	CategoryMapper categoryMapper;
	@Autowired
	PropertyService propertyService;
	org.slf4j.Logger logger= LoggerFactory.getLogger(SpringbootApplication.class);
	@Test
	public void contextLoads() {
		System.out.println("hello");
	}
	@Test
	public void testLog(){
		logger.trace("trace**********");
		logger.debug("debug**********");
		logger.info("info************");
		logger.warn("warn************");
		logger.error("error**********");
	}
	@Autowired
	CategoryService categoryService;
	@Test
	public void testTmall(){
		List<Category> list = categoryService.list();
		Iterator<Category> iterator=list.iterator();
		while(iterator.hasNext()){
			Category category=iterator.next();
			System.out.println(category.getId()+category.getName());
		}
	}
	@Test
	public void testProperty(){//一对多测试
	/*	Category categorys = categoryMapper.getPropertyByCategory(3);
		System.out.println(categorys.getId()+"::"+categorys.getName()+"::"+categorys.getProperties());
		Iterator<Property> iterator = categorys.getProperties().iterator();
		while(iterator.hasNext()){
			Property property=iterator.next();
			System.out.println(property.getId()+"::"+property.getName());
		}*/
		//Category category = categoryService.getPropertyByCategory(3);
		PageHelper.startPage(1,3);
		List<Property> list = propertyService.listByCategory(3);
		//获取该分类下的所有属性
		//List<Property> p = category.getProperties();
		PageInfo<Property> page=new PageInfo<>(list,2);
		Iterator<Property> iterator=page.getList().iterator();
		while(iterator.hasNext()){
			Property p=iterator.next();
			System.out.println(p.getCategory().getName());
		}

	}
	@Autowired
	OrderMapper orderMapper;
	@Autowired
	OrderItemMapper orderItemMapper;
	@Test
	public void test3(){
		Order order=new Order();
		order.setId(1);
		List<OrderItem> orderItemMappers = orderItemMapper.listOrderItemsByOrder(order);
		Iterator<OrderItem> iterator=orderItemMappers.iterator();
		while(iterator.hasNext()){
			OrderItem orderItem=iterator.next();
			System.out.println("oo::::"+orderItem.toString());
		}

	}


}

