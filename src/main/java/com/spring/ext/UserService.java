package com.spring.ext;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * @author chenjunlin
 * @date 2019-03-08
 */
@Service
public class UserService {

    @EventListener(classes = {ApplicationEvent.class})
    public void listen(ApplicationEvent event){
        System.out.println("UserService..监听到的事件"+event);
    }
}
