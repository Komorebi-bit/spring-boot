package com.ko.controller;

import com.ko.bak.BaseClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Komorebi
 * @date 2022.07.21.15:46
 */

//使用lombok包下的注解直接使用log
@Slf4j
@RestController
@RequestMapping("/books")
public class BookController{

    @GetMapping("/{id}")
    public String getById(@PathVariable Integer id){
        log.debug("debug....");
        log.info("info....");
        log.warn("warn....");
        log.error("error......");
        System.out.println("id ---> "+id);
        return "hello, spring boot!";
    }
}
//2022-11-25 22:22:42.081  INFO 18944 --- [           main] o.a.catalina.core.AprLifecycleListener   : APR/OpenSSL configuration: useAprConnector [false], useOpenSSL [true]
//                               PID                  线程       所属类接口名