package com.springmvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.mvc.Controller;

/**
 * @author chenjunlin
 * @date 2019-03-13
 */

//Spring的容器不扫描controller;父容器
@ComponentScan(value= "com.springmvc",excludeFilters={
        @ComponentScan.Filter(type= FilterType.ANNOTATION,classes={Controller.class})
})
public class RootConfig {
}
