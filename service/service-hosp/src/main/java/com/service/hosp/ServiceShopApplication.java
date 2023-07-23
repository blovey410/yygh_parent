package com.service.hosp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 12444
 * @version v1.0
 * @description
 * @since 2023/7/20 19:33
 */
@SpringBootApplication
@MapperScan("com.service.hosp.mapper")
public class ServiceShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceShopApplication.class, args);
	}
}
