package com.ko;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Application06Tests {
    // @Value("${servers.idAddress}")//不支持松散绑定
    // private String msg;
    @Value("${datasource.password}")
    private String password;

    @Test
    void contextLoads() {
        System.out.println(password);
    }

}
