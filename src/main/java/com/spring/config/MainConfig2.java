package com.spring.config;

import com.spring.annotaion.Color;
import com.spring.annotaion.ColorFactoryBean;
import com.spring.annotaion.Person;
import com.spring.annotaion.Red;
import com.spring.condition.LinuxCondition;
import com.spring.condition.MyImportBeanDefinitionRegistrar;
import com.spring.condition.MyImportSelector;
import com.spring.condition.WindowsCondition;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

/**
 * @author chenjunlin
 * @date 2019-02-26
 */
//@Conditional({LinuxCondition.class})
@Configuration
@Import({Color.class, Red.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
//导入ID默认是组件的全类名
public class MainConfig2 {

    //单实例对象
    /**
     * ConfigurableBeanFactory#SCOPE_PROTOTYPE
     * @see ConfigurableBeanFactory#SCOPE_SINGLETON
     * @see org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST  request
     * @see org.springframework.web.context.WebApplicationContext#SCOPE_SESSION	 sesssion
     * @return\
     * @Scope:调整作用域
     * prototype：多实例的：ioc容器启动并不会去调用方法创建对象放在容器中。
     * 					每次获取的时候才会调用方法创建对象；
     * singleton：单实例的（默认值）：ioc容器启动会调用方法创建对象放到ioc容器中。
     * 			以后每次获取就是直接从容器（map.get()）中拿，
     * request：同一次请求创建一个实例
     * session：同一个session创建一个实例
     *
     * 懒加载：
     * 		单实例bean：默认在容器启动的时候创建对象；
     * 		懒加载：容器启动不创建对象。第一次使用(获取)Bean创建对象，并初始化；
     *
     */
    //@Scope("prototype")
    @Lazy //懒加载
    @Bean("person")
    public Person person(){
        System.out.println("给容器中添加Person....");
        return new Person("张三",25);
    }


    /**
     * @Conditional（{Condition}） ：按照一定的条件进行判断，满足条件给容器中注册bean
     *如果系统是windows,给容器注册bill
     * 如果是linux系统，给容器注册linux
     */
   @Conditional({WindowsCondition.class})
    @Bean("bill")
    public Person person01(){
        return new Person("Bill Gates",63);
    }

    @Conditional(LinuxCondition.class)
    @Bean("Linus")
    public Person person02(){
        return new Person("Linus",48);
    }

    /**
     * 给容器中注册组件
     * 1、包扫描+组件标注注解（@controller）
     * 2、@Bean[导入第三方包里面的组件]
     * 3、@Import[快速给容器中导入一个组件]
     *        1）、@Import 要导入到容器中的组件，ID默认是全类名
     *        2）、ImportSelector：返回需要导入的组件的全类名数组
     *        3）、ImportBeanDefinitionRegistrar:手动注册bean到容器中
     *4、使用Spring提供的FactoryBean（工厂BEAN）
     *      1)、默认获取到的是工厂bean调用getobject创建的对象
     *      2)、获取工厂bean本身，我们需要给ID前面加一个&符号
     *
     */
    @Bean
    public ColorFactoryBean colorFactoryBean(){

        return new ColorFactoryBean();
    }
}
