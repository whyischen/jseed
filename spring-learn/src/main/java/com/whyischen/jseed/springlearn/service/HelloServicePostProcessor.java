package com.whyischen.jseed.springlearn.service;

import com.whyischen.jseed.autumn.BeanPostProcessor;
import com.whyischen.jseed.autumn.Component;

@Component
public class HelloServicePostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        if ("helloService".equals(beanName)) {
            System.out.println("> helloService postProcessBeforeInitialization");
        }

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        if ("helloService".equals(beanName)) {
            System.out.println("> helloService postProcessAfterInitialization");
        }
        return bean;
    }
}
