package com.spring.annotaion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author chenjunlin
 * @date 2019-02-28
 */
@Component
public class Boss {
    private Car car;

    public Car getCar() {
        return car;
    }

    @Autowired //标注在方法上,spring容器创建当前对象，就会调用方法，完成赋值
    //方法使用参数，自定义类型的值从IOC容器中获取
    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Boss{" +
                "car=" + car +
                '}';
    }

    //构造器要用的组件，都是从容器中获取
   // @Autowired
    public Boss(Car car) {
        this.car = car;
        System.out.println("Boss......有参数构造");
    }
}
