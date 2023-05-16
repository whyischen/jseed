package com.whyischen.projectwebapp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan("com.whyischen.projectwebapp.mapper")
@SpringBootApplication
public class ProjectWebappApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectWebappApplication.class, args);
    }


}
