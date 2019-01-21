package com.example.yxw;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.yxw.dao")//与dao层的@Mapper二选一写上即可(主要作用是扫包)
public class YxwApplication {

	public static void main(String[] args) {
		SpringApplication.run(YxwApplication.class, args);
	}

}

