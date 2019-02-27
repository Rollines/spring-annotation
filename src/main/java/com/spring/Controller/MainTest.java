package com.spring.Controller;

import com.spring.annotaion.Person;
import com.spring.config.MainConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author chenjunlin
 * @date 2019-02-26
 */
public class MainTest {
    public static void main(String[] args) {
        //配置方式
        /*ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        Person bean = (Person) applicationContext.getBean("person");
        System.out.println(bean);*/
        //注解方式
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        Person bean = applicationContext.getBean(Person.class);
        System.out.println(bean);


        String[] namesForType = applicationContext.getBeanNamesForType(Person.class);
        for (String name: namesForType) {
            System.out.println(name);
        }
    }
}
