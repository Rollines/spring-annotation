package com.spring.annotaion;

import com.spring.aop.MathCalculator;
import com.spring.config.MainConfigOfAOP;
import com.spring.config.MainConifgOfAutowired;
import com.spring.service.BookService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author chenjunlin
 * @date 2019-02-27
 */
public class IOCTest_Aop {

    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAOP.class);

        //1、不要自己创建
        /*MathCalculator mathCalculator = new MathCalculator();
        mathCalculator.div(1,1);*/

        MathCalculator mathCalculator = applicationContext.getBean(MathCalculator.class);
        //System.out.println(mathCalculator);
        mathCalculator.div(1,1);
        applicationContext.close();
    }
}
