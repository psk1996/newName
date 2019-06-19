package com.poortom.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.poortom.springboot.dao")
@SpringBootApplication
public class PoortomApplication {

	public static void main(String[] args) {
		SpringApplication.run(PoortomApplication.class, args);
	}

}
