package com.luxin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.luxin.mapper")
public class CmsApplication {
    public static void main(String[] args) {
        SpringApplication.run( CmsApplication.class, args );
    }
}
