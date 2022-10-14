package com.whyischen.springlearn.service;

import com.whyischen.autumn.Autowired;
import com.whyischen.autumn.Component;

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
