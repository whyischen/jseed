package com.whyischen.springlearn;

import com.whyischen.autumn.ApplicationContext;
import com.whyischen.springlearn.config.AppConfig;
import com.whyischen.springlearn.service.HelloService;

public class SpringLearnAutumnApplication {

    public static void main(String[] args) {
        ApplicationContext context = new ApplicationContext(AppConfig.class);
        HelloService helloService = (HelloService) context.getBean("helloService");
        System.out.println(helloService.helloOrder());
    }

}
