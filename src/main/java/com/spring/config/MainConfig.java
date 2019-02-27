package com.spring.config;

import com.spring.annotaion.Person;
import com.spring.service.BookService;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @author chenjunlin
 * @date 2019-02-26
 */
//配置类 ==配置文件
    @Configuration //告诉spring这是一个配置类
    @ComponentScans(
            value = {
                    @ComponentScan(value="com.spring",includeFilters = {
                            /*@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class, Service.class}),
                            @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = {BookService.class}),*/
                            @ComponentScan.Filter(type = FilterType.CUSTOM,classes = {MyTypeFileter.class})
                    },useDefaultFilters = false)
                    })
    //@Componentscan vlaue 指定要扫描的包
    //excludeFilters = Filter[],指定扫描时候按照什么规则排除那些组件
    //includeFilters = Filter[] ：指定扫描的时候只需要包含哪些组件
//FilterType.ANNOTATION：按照注解
//FilterType.ASSIGNABLE_TYPE：按照给定的类型；
//FilterType.ASPECTJ：使用ASPECTJ表达式
//FilterType.REGEX：使用正则指定
//FilterType.CUSTOM：使用自定义规则
public class MainConfig {
        //给容器中注册一个BEAN;类型为返回值的类型，ID为默认是用方法名作为ID；
        @Bean("psersons")
    public Person person(){
            return new Person("zhangsan",32);
        }
}
