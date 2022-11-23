package com.ko.controller;

import com.ko.domain.Enterprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Komorebi
 * @date 2022.07.21.15:46
 */
@RestController
@RequestMapping("/books")
public class BookController {

    //1.0
    @Value("${lesson}")
    private String lesson;

    @Value("${server.port}")
    private Integer port;

    @Value("${enterprise.subject[0]}")
    private String subject_00;

    //2.0自动加载所有的环境变量
    @Autowired
    private Environment environment;

    //3.0
    @Autowired
    private Enterprise enterprise;

    @GetMapping("/{id}")
    public String getById(@PathVariable Integer id){
        System.out.println(lesson);
        System.out.println(port);
        System.out.println(subject_00);

        System.out.println(environment.getProperty("enterprise.age"));
        System.out.println(environment.getProperty("enterprise.subject[2]"));

        System.out.println(enterprise);

        System.out.println("id ---> "+id);
        return "hello, spring boot!";
    }
}
