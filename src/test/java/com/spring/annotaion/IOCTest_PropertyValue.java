package com.spring.annotaion;

import com.spring.config.MainConfigOfPropertyValues;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author chenjunlin
 * @date 2019-02-27
 * @value赋值
 */

public class IOCTest_PropertyValue {
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfPropertyValues.class);

    @Test
    public void test01(){

        printBeans(applicationContext);
        System.out.println("========");
        Object person = applicationContext.getBean("person");
        System.out.println(person);

//@vaule赋值
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        String property = environment.getProperty("person.nickName");
        System.out.println(property);
        applicationContext.close();
    }

    private void printBeans(AnnotationConfigApplicationContext applicationContext){
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : definitionNames) {
            System.out.println(name);
        }
    }
}
