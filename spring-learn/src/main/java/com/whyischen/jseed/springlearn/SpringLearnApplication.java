package com.whyischen.jseed.springlearn;

import com.whyischen.jseed.springlearn.model.Hello;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;

@SpringBootApplication
public class SpringLearnApplication {

    @ComponentScan(value = "com.whyischen" )
    @Configuration
    public static class RootConfig {

        @Bean
        public Hello hello() {
            return new Hello();
        }
    }

    public static void main(String[] args) {
        ApplicationContext cxt = new AnnotationConfigApplicationContext(RootConfig.class);
        System.out.println(cxt.getBean(Hello.class));
    }

}
