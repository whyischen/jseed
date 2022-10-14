package com.whyischen.springlearn.service;

import com.whyischen.autumn.BeanPostProcessor;
import com.whyischen.autumn.Component;

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
