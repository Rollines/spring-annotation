package com.springmvc.service;

import org.springframework.stereotype.Service;

/**
 * @author chenjunlin
 * @date 2019-03-13
 */

@Service
public class HelloService {
    public String sayHello(String name){

        return "Hello "+name;
    }
}
