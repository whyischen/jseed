package com.whyischen.jseed.springlearn.service;

import com.whyischen.jseed.autumn.Autowired;
import com.whyischen.jseed.autumn.Component;

@Component(name = "helloService")
public class HelloService {

    @Autowired
    private OrderService orderService;

    public String hello() {
        return "Hello Autumn!";
    }

    public String helloOrder() {
        orderService.printOrder();
        return "Hello Order!";
    }
}
