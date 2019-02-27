package com.spring.annotaion;

import com.spring.config.MainConifgOfAutowired;
import com.spring.dao.BookDao;
import com.spring.service.BookService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author chenjunlin
 * @date 2019-02-27
 */
public class IOCTest_Autowired {

    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConifgOfAutowired.class);
        BookService bookService = applicationContext.getBean(BookService.class);
        System.out.println(bookService);

        //BookDao bean = applicationContext.getBean(BookDao.class);
        //System.out.println(bean);

        applicationContext.close();
    }
}
