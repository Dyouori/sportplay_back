package com.deyunjiaoyu.sportplay;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//这行代码的意思是告诉Spring Boot：“请扫描com.deyunjiaoyu.sportplay.dao这个包以及它的子包，找到所有的MyBatis映射器接口，并为它们创建代理对象以供使用。”
@MapperScan("com.deyunjiaoyu.sportplay.dao")
@MapperScan("com.deyunjiaoyu.sportplay.mapper")
@SpringBootApplication

public class SportplayApplication {

    public static void main(String[] args) {

        SpringApplication.run(SportplayApplication.class, args);


    }

}
