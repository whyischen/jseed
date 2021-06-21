package com.whyischen.jseed.springlearn;

import com.whyischen.jseed.autumn.ApplicationContext;
import com.whyischen.jseed.springlearn.config.AppConfig;
import com.whyischen.jseed.springlearn.service.HelloService;

public class SpringLearnAutumnApplication {

    public static void main(String[] args) {
        ApplicationContext context = new ApplicationContext(AppConfig.class);
        HelloService helloService = (HelloService) context.getBean("helloService");
        System.out.println(helloService.hello());
    }

}
