package com.spring.annotaion;

import com.spring.tx.TxConfig;
import com.spring.tx.UserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author chenjunlin
 * @date 2019-03-06
 */
public class IOCTest_Tx {
    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(TxConfig.class);
        UserService userService = applicationContext.getBean(UserService.class);
        userService.insertUser();
        applicationContext.close();

    }

    @Test
    public void testPost(){

    }
}
