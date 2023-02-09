package com.whyischen.projectwebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class ProjectWebappApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectWebappApplication.class, args);
    }


    @RequestMapping("/ping")
    public String pang() {
        return "pang";
    }


}
