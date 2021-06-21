package com.whyischen.jseed.springlearn.service;

import com.whyischen.jseed.autumn.Component;

@Component(name = "helloService")
public class HelloService {

    public String hello() {
        return "Hello Autumn!";
    }
}
