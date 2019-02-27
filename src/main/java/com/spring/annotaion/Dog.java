package com.spring.annotaion;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author chenjunlin
 * @date 2019-02-27
 *
 * 可以使用JSR250规范里面的注解；
 *  * 		@PostConstruct：在bean创建完成并且属性赋值完成；来执行初始化方法
 *  * 		@PreDestroy：在容器销毁bean之前通知我们进行清理工作
 */
@Component
public class Dog implements ApplicationContextAware {

    private ApplicationContext applicationContext;
    public Dog(){
        System.out.println("dog constructor.......");
    }

    //对象创建并赋值之后调用
    @PostConstruct
    public void init(){
        System.out.println("Dog.....@PostConstruct......");
    }

    //容器移除之前
    @PreDestroy
    public void detory(){
        System.out.println("Dog.....@PreDestroy.....");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
