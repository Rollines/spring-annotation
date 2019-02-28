package com.spring.annotaion;

import org.springframework.stereotype.Component;

/**
 * @author chenjunlin
 * @date 2019-02-27
 *
 * 默认加在ioc容器中的组件，容器启动会调用无参构造器创建对象，再进行初始化赋值操作
 */
@Component
public class Car {
    public Car(){
        System.out.println("car constructor....");
    }

    public void init(){
        System.out.println("car .... inti.....");
    }

    public void detory(){
        System.out.println("car .... detory......");
    }


}
