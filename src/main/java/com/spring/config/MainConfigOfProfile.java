package com.spring.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.spring.annotaion.Yellow;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @author chenjunlin
 * @date 2019-02-28
 *
 * profile ：
 *       spring提供当前环境，动态的激活和切换一系列组件的功能；
 *
 * 开发环境，测试环境，生成环境；
 * 数据源(A/B/C)
 *
 * @profile，指定组件在那个环境情况下才能被注册到容器中，不指定，仁和环境下不能注册
 * 1）、加了环境标识的bean，只有这个环境被激活的时候才能注册到容器中。默认是default环境
 * 2）、写在配置类上，只有是指定的环境的时候，整个配置类里面的所有配置才能开始生效
 * 3）、没有标注环境标识的bean在，任何环境下都是加载的；
 *
 * @Profile
 */
@PropertySource("classpath:/dbconfig.properties")
@Configuration
public class MainConfigOfProfile implements EmbeddedValueResolverAware {


    private StringValueResolver valueResolver;

    private String driverClass;

    @Bean
    public Yellow yellow(){
        return new Yellow();
    }

   @Value("${db.user}")
   private String user;

   @Profile("test")
    @Bean("testDataSource")
    public DataSource dataSourceTest(@Value("${db.password}")String pwd) throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(pwd);
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/bms");
        dataSource.setDriverClass(driverClass);
        return dataSource;
    }

   @Profile("dev")
    @Bean("devDataSource")
    public DataSource dataSourceDev(@Value("${db.password}")String pwd) throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(pwd);
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/meifa");
        dataSource.setDriverClass(driverClass);
        return dataSource;
    }


    @Profile("prod")
    @Bean("prodDataSource")
    public DataSource dataSourceProd(@Value("${db.password}")String pwd) throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(pwd);
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/meedu");
        dataSource.setDriverClass(driverClass);
        return dataSource;
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        this.valueResolver = resolver;
        driverClass = valueResolver.resolveStringValue("${db.driverClass}");
    }
}
