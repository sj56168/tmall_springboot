package com.jason;

import javafx.application.Application;
import net.bytebuddy.build.ToStringPlugin;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.MultipartConfigElement;

/**
 * 打包成war
 * 1、添加注解@ServletComponentScan
 * 2、 继承SpringBootServletInitializer
 * 3、重写configure
 * 4、修改pom 添加 <packaging>war</packaging>  和spring-boot-starter-tomcat
 *
 */
@SpringBootApplication(scanBasePackages = "com.jason")
@MapperScan("com.jason.mapper")
@EnableCaching   //redis需要开启缓存
/*@EnableJpaRepositories(basePackages = {"com.jason.mapper","com.jason.pojo"})*/
public class SpringbootApplication /*extends SpringBootServletInitializer*/ {
/*  打包war 需要
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(Application.class);
	}
*/

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}

}

