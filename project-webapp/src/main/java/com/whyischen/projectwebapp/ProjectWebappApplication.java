package com.whyischen.projectwebapp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

// 可选，jap repositories 路径，不写扫描全部
@EnableJpaRepositories("com.whyischen.projectwebapp.repository")
// mybatis mapper 包路径
@MapperScan("com.whyischen.projectwebapp.mapper")
@SpringBootApplication
public class ProjectWebappApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectWebappApplication.class, args);
    }


}
