package com.ko;

import com.alibaba.druid.pool.DruidDataSource;
import com.ko.config.ServerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @author Komorebi
 */
@SpringBootApplication
@EnableConfigurationProperties(ServerConfig.class)
//告诉spring容器我现在有一组信息要去加载spring管理的配置，如果不是bean怎么能被加载呢，所以这个注解自动帮我们把serverconfig做成了bean
//与component不能同时使用，否则会报bean不唯一错误
public class Application06 {
    @Bean
    @ConfigurationProperties(prefix = "datasource") //注入yml中的数据，kebab-case 模式 支持松散绑定
    public DruidDataSource dataSource(){
        DruidDataSource ds = new DruidDataSource();
        //ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        return ds;
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(Application06.class, args);
        ServerConfig serverConfig = ctx.getBean(ServerConfig.class);
        System.out.println(serverConfig);
        DruidDataSource druidDataSource = ctx.getBean(DruidDataSource.class);
        System.out.println(druidDataSource.getDriverClassName());
    }

}
