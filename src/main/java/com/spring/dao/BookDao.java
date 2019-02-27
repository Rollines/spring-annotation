package com.spring.dao;

import com.spring.service.BookService;
import org.springframework.stereotype.Repository;

/**
 * @author chenjunlin
 * @date 2019-02-26
 */
@Repository
public class BookDao {

    public String lable = "1";

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable;
    }

    @Override
    public String toString() {
        return "BookDao{" +
                "lable='" + lable + '\'' +
                '}';
    }
}
