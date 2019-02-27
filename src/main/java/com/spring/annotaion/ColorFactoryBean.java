package com.spring.annotaion;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author chenjunlin
 * @date 2019-02-27
 */
//创建一个spring定义的factoryBean
public class ColorFactoryBean implements FactoryBean {
    //返回一个color对象，这个对象会添加到容器中
    @Override
    public Object getObject() throws Exception {
        System.out.println("ColorFactoryBean......objectBean");
        return new Color();
    }

    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }

    //单例模式
    // 如果返回true，这个bean是单例，在容器中保存一份
    // 如果返回false，多实例，每次创建都会创建一个新的Bean
    @Override
    public boolean isSingleton() {
        return false;
    }
}
