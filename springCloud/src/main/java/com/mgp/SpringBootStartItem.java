package com.mgp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

//@EnableDiscoveryClient
@EnableEurekaServer
@SpringBootApplication
@MapperScan(basePackages="com.mgp.*.dao")
//@EnableConfigurationProperties(value = { DBConfigOne.class, DBConfigTwo.class })
public class SpringBootStartItem {

	public static void main(String[] args) {
        SpringApplication.run(SpringBootStartItem.class, args);
	}

}
