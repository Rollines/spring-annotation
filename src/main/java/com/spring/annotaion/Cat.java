package com.spring.annotaion;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author chenjunlin
 * @date 2019-02-27
 */
@Component
public class Cat implements InitializingBean, DisposableBean {
    public Cat(){
        System.out.println("cat constructor....");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("cat....destory.....");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("cat...afterPropertiesSet...");
    }
}
