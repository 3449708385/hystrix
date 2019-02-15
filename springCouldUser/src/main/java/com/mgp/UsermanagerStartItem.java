package com.mgp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
@MapperScan(basePackages="com.mgp.*.*.mapper")
public class UsermanagerStartItem {

	public static void main(String[] args) {
        SpringApplication.run(UsermanagerStartItem.class, args);
	}

}
