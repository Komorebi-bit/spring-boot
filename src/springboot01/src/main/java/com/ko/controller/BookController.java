package com.ko.controller;

import com.ko.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Komorebi
 * @since 2022.11.23.15:19
 */

@RestController
@RequestMapping("/books")
public class BookController {

    @Value("${users[0].name}") //读取yml文件数据
    private String name;

    @Value("${java_home}")
    private String java_home;

    @Value("${tempDir}")
    private String tempDir;

    @Value("${temp1}")
    private String temp1;
    @Autowired //自动装配 将所有的数据封装到一个对象中
    private Environment env;

    @Autowired
    private DataSource dataSource;

    @GetMapping("/{id}")
    public String getById(@PathVariable Integer id){
        System.out.println(id);
        System.out.println(name);
        System.out.println(java_home);
        System.out.println(tempDir);
        System.out.println(temp1);
        System.out.println(env.getProperty("likes[2]"));
        System.out.println(dataSource);
        return "<h1>Hello Spring Boot!";
    }
}
