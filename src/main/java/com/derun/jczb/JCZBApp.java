package com.derun.jczb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
//@EnableSwagger2
@SpringBootApplication
@EnableAutoConfiguration
@EnableCaching
@EnableTransactionManagement 
@MapperScan("com.derun.jczb.dao")
public class JCZBApp{
	public static void main(String[] args) {
        SpringApplication.run(JCZBApp.class, args);
    }	 
}
