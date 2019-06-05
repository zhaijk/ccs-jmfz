package com.derun.ccs.jmfz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@SpringBootApplication
@EnableAutoConfiguration
@EnableCaching
@EnableTransactionManagement 
@MapperScan("com.derun.ccs.jmfz.dao")
/**
 * info 车船税减免政策审核辅助系统
 * @author Administrator
 *
 */
public class JMFZApp{
	public static void main(String[] args) {
        SpringApplication.run(JMFZApp.class, args);
    }	 
}
