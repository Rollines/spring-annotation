package com.spring.annotaion;

import com.spring.config.MainConfigOfLifeCycle;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author chenjunlin
 * @date 2019-02-27
 */
public class IOCTest_LifeCycle {

    @Test
    public void test01(){
        //1、创建ioc容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
        System.out.println("容器创建完成");
       //socpe 多实例容器不会管理bean
       // applicationContext.getBean("car");

        //关闭数据源
        applicationContext.close();
    }
}
