package com.whyischen.jseed.springlearn.service;

import com.whyischen.jseed.autumn.Autowired;
import com.whyischen.jseed.autumn.Component;

@Component("helloService")
public class HelloService {

    @Autowired
    private OrderService orderService;

    public String hello() {
        return "Hello Autumn!";
    }

    public String helloOrder() {
        orderService.printOrder();
        return "This is helloOrder();";
    }
}
