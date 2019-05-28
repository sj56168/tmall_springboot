package com.jason.config;

import com.github.pagehelper.PageHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * Created by 我不管我最帅 on 2019/2/24.
 */
//表示 该类是配置类
@Configuration
public class PageHelperConfig {
    //相当于配置文件xml 的<bean>
    @Bean
    public PageHelper pageHelper(){
        PageHelper pageHelper=new PageHelper();
        Properties p=new Properties();
        //offsetAsPageNum:设置为true时，会将RowBounds第一个参数offset当成pageNum页码使用.
        p.setProperty("offsetAsPageNum","true");
        //rowBoundsWithCount:设置为true时，使用RowBounds分页会进行count查询.
        p.setProperty("rowBoundsWithCount","true");
        //reasonable：启用合理化时，如果pageNum<1会查询第一页，如果pageNum>pages会查询最后一页。
        p.setProperty("reasonable","true");
        pageHelper.setProperties(p);
        return pageHelper;

    }
}
