package com.mywork.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@MapperScan("com.mywork.springboot.mapper")
@SpringBootApplication
public class SpringBootLibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootLibraryApplication.class, args);
    }

}
