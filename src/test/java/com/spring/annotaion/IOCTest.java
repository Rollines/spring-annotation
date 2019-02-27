package com.spring.annotaion;

import com.spring.config.MainConfig;
import com.spring.config.MainConfig2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

/**
 * @author chenjunlin
 * @date 2019-02-26
 */
public class IOCTest {
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);

    @Test
    public void testImport(){
        printBeans(applicationContext);
        Blue bean = applicationContext.getBean(Blue.class);
        System.out.println(bean);

    }
    private void printBeans(AnnotationConfigApplicationContext annotationConfigApplicationContext){
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for (String name:definitionNames){
            System.out.println(name);
        }
    }


    @Test
    public void test03(){
        String[] namesForType = applicationContext.getBeanNamesForType(Person.class);
        ConfigurableEnvironment environment = (ConfigurableEnvironment) applicationContext.getEnvironment();
        //动态获取环境变量的值
        String property = environment.getProperty("os.name");
        System.out.println(property);

        for (String name:namesForType){
            System.out.println(name);
        }
        Map<String, Person> ofType = applicationContext.getBeansOfType(Person.class);
        System.out.println(ofType);

    }

    @Test
    public void test02(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        /*String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for (String name: definitionNames) {
            System.out.println(name);
        }*/
        System.out.println("容器创建完成....");
        Object bean = applicationContext.getBean("person");
        Object bean2 = applicationContext.getBean("person");
        System.out.println(bean == bean2);

    }
    @SuppressWarnings("resource")
    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for (String name: definitionNames) {
            System.out.println(name);
        }

    }
}
