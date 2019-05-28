package com.jason.controller;

import com.jason.comparator.*;
import com.jason.pojo.*;
import com.jason.service.*;
import com.jason.util.Result;
import com.mysql.jdbc.V1toV2StatementInterceptorAdapter;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by 我不管我最帅 on 2019/4/8.
 * 对应前台路径
 * 1. 查询所有分类
 2. 为这些分类填充产品集合
 3. 为这些分类填充推荐产品集合
 4. 移除产品里的分类信息，以免出现重复递归
 */
@RestController
public class ForeRESTController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;
    @Autowired
    ProductImageService productImageService;
    @Autowired
    ReviewService reviewService;
    @Autowired
    PropertyValueService propertyValueService;
    @Autowired
    OrderItemService orderItemService;
    @Autowired
    OrderService orderService;

    //主页
    @GetMapping("/forehome")
    public Object home(){
        //1、查询所有分类
        List<Category> categories=categoryService.list();
        //2、为这些分类填充产品集合
        productService.fill(categories);
        //3、 为这些分类填充推荐产品集合
        productService.fillByRow(categories);
        //4、移除产品里的分类信息，以免出现重复递归
        categoryService.removeCategoryFromProducts(categories);
        return categories;
    }
    //注册
    @PostMapping("foreRegister")
    public Object register(@RequestBody User user){
        boolean exist = userService.isExist(user.getName());
        if(exist){
        String message="用户名已经被使用,不能使用";
            return  Result.fail(message);
        }
        userService.add(user);
    return  Result.success();
    }
    //登录
    @PostMapping("forelogin")
    public Object login(@RequestBody  User user, HttpSession session){
        User user1 = userService.getUser(user.getName());
        if(user1==null){
            String message="用户不存在";
            return  Result.fail(message);
        }
        if(user1!=null){
            if(!user1.getPassword().equals(user.getPassword())){
                String message="密码错误";
                return Result.fail(message);
            }

        }
        session.setAttribute("user",user);
        return Result.success();
    }
//访问产品页
    @GetMapping("/foreproduct/{pid}")
    public Object product(@PathVariable(value = "pid") int pid){
        /*1、产品部分*/
        Product product = productService.getOne(pid);
        //获取单个图片并设置
        List<ProductImage> singleProductImages = productImageService.listSingleProductImages(product.getId());
        product.setProductSingleImages(singleProductImages);
        //获取详情图片并设置
        List<ProductImage> detailProductImages = productImageService.listDetailProductImages(product.getId());
        product.setProductDetailImages(detailProductImages);
        //获取累计销量和评价并设置
        productService.setSaleAndReviewNumber(product);
        //设置产品首图
        productImageService.setFirstProdutImage(product);
        /*2、评价部分*/
        //获取该产品的所有评价
        List<Review> reviews = reviewService.listReviewByProduct(product.getId());
        /*3、产品属性值部分*/
        //获取该产品的所有属性值（属性值表里包含了属性字段）
        List<PropertyValue> propertyValues = propertyValueService.listPropertyValue(product.getId());
        Map<String,Object> map=new HashMap<>();
        map.put("product",product);
        map.put("reviews",reviews);
        map.put("propertyValues",propertyValues);
        return  map;
    }
    //检查是否登录
    @GetMapping("forecheckLogin")
    public Object checkLogin(HttpSession session){
        User user = (User) session.getAttribute("user");
    if(user!=null){
        return Result.success();
    }
    return Result.fail("未登录");
    }

    //访问分类页（显示该分类下的所有产品）
    @GetMapping("forecategory/{cid}")
    public Object category(@PathVariable(value = "cid")int cid,@RequestParam(value = "sort") String sort){
        //获取该类
        Category category = categoryService.getOne(cid);
        //为分类填充所有产品
        productService.fill(category);
        //为该类的所有产品填充销量和评价数
        productService.setSaleAndReviewNumber(category.getProducts());
        //将product里的category属性值置为null 防止后台数据返回前台转成json时出现递归
        categoryService.removeCategoryFromProduct(category);
        if (sort != null) {
            switch (sort) {
                //人气（根据评价数）
                case "review":
                    Collections.sort(category.getProducts(), new ProductReviewComparator());
                    break;
                //新品（根据新建日期）
                case "date":
                    Collections.sort(category.getProducts(), new ProductDateComparator());
                    break;
                //销量（根据产品销售量）
                case "saleCount":
                    Collections.sort(category.getProducts(), new ProductSaleCountComparator());
                    break;
                //价格（根据产品价格）
                case "price":
                    Collections.sort(category.getProducts(), new ProductPriceComparator());
                    break;
                //综合（根据 销量*评价）
                case "all":
                    Collections.sort(category.getProducts(), new ProductAllComparator());
                    break;
            }
        }
        return category;

    }
    //立即购买
    @GetMapping("forebuyone")
    public Object buyone(@RequestParam(value = "pid")int pid,@RequestParam(value = "num")int num,HttpSession session){
        System.out.println("pid::"+pid+"::::"+num);
        return  buyoneAndAddCart(pid,num,session);
    }

    //加入购物车
    @GetMapping("foreaddCart")
    public Object addCart(@RequestParam(value = "pid") int pid,@RequestParam(value = "num") int num,HttpSession session){
    buyoneAndAddCart(pid,num,session);
    return Result.success();
    }
    //todo 立即购买或加入购物车(新增订单项OrderItem，新增订单项要考虑两个情况
    //a. 如果已经存在这个产品对应的OrderItem，并且还没有生成订单，即还在购物车中。 那么就应该在对应的OrderItem基础上，调整数量
    //b. 如果不存在对应的OrderItem,那么就新增一个订单项OrderItem
    private int buyoneAndAddCart(int pid,int num,HttpSession session){
        //根据产品id 获取该产品
        Product product = productService.getOne(pid);
        //订单项id
        int oiid = 0;
        //session中获取用户
        User user = (User) session.getAttribute("user");
        boolean found = false;
        //根据用户查询该用户所有订单项
        List<OrderItem> ois = orderItemService.listByUser(user);
        for (OrderItem oi : ois) {
            if (oi.getProduct().getId() == product.getId()) {
                //如果该订单项已存在则产品数加
                oi.setNumber(oi.getNumber() + 1);
                orderItemService.update(oi);
                found = true;
                oiid = oi.getId();
                break;
            }
        }
        //如果订单项不存在，则直接添加
        if (!found) {
            OrderItem orderItem = new OrderItem();
            //用户
            orderItem.setUser(user);
            //产品
            orderItem.setProduct(product);
            //产品数
            orderItem.setNumber(num);
            System.out.println(orderItem.toString());
            orderItemService.add(orderItem);
            oiid=orderItem.getId();
        }
        //返回订单项id
        return oiid;
    }

    //进入结算页面(注：从购物车选中产品进入结算页面将会有多个订单项id)
    @GetMapping("forebuy")
    public Object buy(@RequestParam(value = "oiid") String[] oiid,HttpSession session){
        List<OrderItem> orderItems=new ArrayList<>();
        float total=0;
        for(String strid:oiid){
            int id=Integer.parseInt(strid);
            //根据订单项id获取该订单项
            OrderItem orderItem=orderItemService.getOne(id);
            System.out.println(orderItem.toString());
            //计算总额
            total+=orderItem.getProduct().getPromotePrice()*orderItem.getNumber();
            orderItems.add(orderItem);
        }
        //为订单项设置图片
        productImageService.setFirstProductImageOnOrderItems(orderItems);
        //把订单项放进session
        session.setAttribute("ois",orderItems);
        Map<String,Object> map=new HashMap<>();
        map.put("orderItems",orderItems);
        map.put("total",total);
        return Result.success(map);
    }
    //进入购物车
    @GetMapping("forecart")
    public Object cart(HttpSession session){
        User user = (User) session.getAttribute("user");
        System.out.println("user::::"+user);
        List<OrderItem> orderItems=null;
        if(user!=null){
            orderItems= orderItemService.listByUser(user);
            //给订单项设置图片（即给product里的属性firstImage设置值）
            productImageService.setFirstProductImageOnOrderItems(orderItems);

        }
        return orderItems;
    }
    //改变购物车里产品数量
    @GetMapping("forechangeOrderItem")
    public Object changeOrderItem( HttpSession session,@RequestParam(value = "pid") int pid,@RequestParam(value = "num") int num) {
        User user =(User)  session.getAttribute("user");
        if(null==user)
            return Result.fail("未登录");
        //查询该用户购物车里的所有订单项
        List<OrderItem> ois = orderItemService.listByUser(user);
        //遍历所有订单项
        for (OrderItem oi : ois) {
            //找到需要变更产品数量的订单项
            if(oi.getProduct().getId()==pid){
                oi.setNumber(num);
                //更新订单项的产品数
                orderItemService.update(oi);
                break;
            }
        }
        return Result.success();
    }
    //删除订单项
    @GetMapping("foredeleteOrderItem")
    public Object deleteOrderItem(HttpSession session,@RequestParam(value = "oiid") int oiid){
        User user =(User)  session.getAttribute("user");
        if(null==user)
            return Result.fail("未登录");
        orderItemService.delete(oiid);
        return Result.success();
    }
    //生成订单
    @PostMapping("forecreateOrder")
    public Object createOrder(@RequestBody Order order,HttpSession session){
        User user = (User) session.getAttribute("user");
        if(user==null){
            return Result.fail("未登录");
        }
        //生成订单编号
        String orderCode=new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())+ RandomUtils.nextInt(10000);
        order.setOrderCode(orderCode);
        order.setCreateDate(new Date());
        order.setUser(user);
        order.setStatus(OrderService.waitPay);
        //在进入结算页面的时候已经把订单项放进了session中
        List<OrderItem> orderItems= (List<OrderItem>) session.getAttribute("ois");
        //进行订单增加和更新订单项（要么全成功要么全失败）
        float total = orderService.add(order, orderItems);
        Map<String ,Object> map=new HashMap<>();
        map.put("oid",order.getId());
        map.put("total",total);
        return Result.success(map);
    }
    //支付页面根据订单id计算订单总额
    @GetMapping("forepaying")
    public float paying(@RequestParam(value = "oid")int oid){
        Order order = orderService.getOne(oid);
        //fill里面有计算订单总金额功能
         orderService.fill(order);
        return order.getTotal();
    }

    //完成支付(修改订单状态)
    @GetMapping("forepayed")
    public Object payed(@RequestParam(value = "oid") int oid){
        Order order = orderService.getOne(oid);
        //改变订单状态
        order.setStatus(OrderService.waitDelivery);
        //设置付款日期
        order.setPayDate(new Date());
        orderService.update(order);
        return order;
    }

    //查看我的订单(根据用户)
    @GetMapping("forebought")
    public Object bought(HttpSession session){
        User user = (User) session.getAttribute("user");
        if(user==null)Result.fail("未登录");
        //查询所有订单
        List<Order> orders = orderService.listByUserWithoutDelete(user);
        //遍历订单
        for(Order order:orders){
            //为订单项设置图片
            productImageService.setFirstProductImageOnOrderItems(order.getOrderItems());
        }
        return orders;
    }
    //进入确认支付页面（货已经收到）
    @GetMapping("foreconfirmPay")
    public Object confirmPay(@RequestParam(value = "oid") int oid){
        Order order = orderService.getOne(oid);
        //给订单填充订单项 并且计算总金额（已经set到 属性total）同时将orderItem里的order属性置为null，防止出现递归报错
        orderService.fill(order);
        //设置图片
        productImageService.setFirstProductImageOnOrderItems(order.getOrderItems());
        return  order;
    }
    //确认收货成功 1、订单状态改为待评价 2、设置确认收货日期
    @GetMapping("foreorderConfirmed")
    public Object orderConfirmed(@RequestParam(value = "oid") int oid){
        Order order = orderService.getOne(oid);
        //订单状态改为待评价
        order.setStatus(OrderService.waitReview);
        //设置确认收货日期
        order.setConfirmDate(new Date());
        orderService.update(order);
        return Result.success();
    }
    //进入评价页面
    @GetMapping("forereview")
    public Object reviews(@RequestParam(value = "oid") int oid,HttpSession session){
        Order order = orderService.getOne(oid);
        //给订单填充订单项 并且计算总金额（已经set到 属性total）同时将orderItem里的order属性置为null，防止出现递归报错
        orderService.fill(order);
        //如果订单里有多个产品，那么默认只对第一个做出评价
        Product product=order.getOrderItems().get(0).getProduct();
        //填充图片
        productImageService.setFirstProdutImage(product);
        //查询该产品所有评价
        List<Review> reviews=reviewService.listReviewByProduct(product.getId());

        //拿到该产品的销量和评价数
        productService.setSaleAndReviewNumber(product);
        Map<String,Object> map=new HashMap<>();
        map.put("product",product);
        map.put("order",order);
        map.put("reviews",reviews);
        return Result.success(map);
    }
    //完成评价
    @PostMapping("foredoreview")
    public Object doreview( HttpSession session,int oid,int pid,String content) {
        //根据id获取订单
        Order o = orderService.getOne(oid);
        //修改订单状态
        o.setStatus(OrderService.finish);
        orderService.update(o);
        //获取产品
        Product p = productService.getOne(pid);
        User user =(User)  session.getAttribute("user");
        Review review = new Review();
        review.setContent(content);//评价内容
        review.setProduct(p);
        review.setCreateDate(new Date());//评价日期
        review.setUser(user);
        reviewService.addReview(review);
        return Result.success();
    }

}
