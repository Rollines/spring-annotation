package com.spring.condition;

import com.spring.annotaion.Person;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author chenjunlin
 * @date 2019-02-26
 */
public class LinuxCondition  implements Condition {
    /**
     *
     * ConditionContext 判断条件能使用的上下文环境
     * annotatedTypeMetadata：注释信息
     * @return
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata annotatedTypeMetadata) {
        //TODO 是否linux系统
        //1、能获取到ioc使用的BeanFactory
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        //2、获取类加载器
        ClassLoader classLoader = context.getClassLoader();
        //3、获取当前环境信息
        Environment environment = context.getEnvironment();
        //4、获取到bean定义的注册类
        BeanDefinitionRegistry registry = context.getRegistry();
        String property = environment.getProperty("os.name");
         //容器中bean注册情况,也可以给容器中注册情况
        boolean definition = registry.containsBeanDefinition("person");

        if (property.contains("Linux")){
            return true;
        }

        return false;
    }
}
