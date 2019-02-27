package com.spring.Controller;

import com.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author chenjunlin
 * @date 2019-02-26
 */
@Controller
public class BookController {

    @Autowired
    private BookService bookService;

}
