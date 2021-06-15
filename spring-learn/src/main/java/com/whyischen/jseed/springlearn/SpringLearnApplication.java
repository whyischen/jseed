package com.whyischen.jseed.springlearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Constructor;

@SpringBootApplication
public class SpringLearnApplication {

    // BeanDefinition 如何加载到 ApplicationContext ?
    // BeanFactoryPostProcessors 如何加载到 ApplicationContext ?

    public static void main(String[] args) {
        SpringApplication.run(SpringLearnApplication.class, args);
    }

}
