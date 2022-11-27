package com.ko.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Komorebi
 * @since 2022.11.27.13:14
 */
//@Configuration //加上他，也不需要import了，所有的测试类都会扫描到
public class MsgConfig {
    @Bean
    public String msg(){
        return "bean msg";
    }
}
