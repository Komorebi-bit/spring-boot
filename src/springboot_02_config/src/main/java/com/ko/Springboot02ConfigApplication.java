package com.ko;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Springboot02ConfigApplication {

  public static void main(String[] args) {
    SpringApplication.run(Springboot02ConfigApplication.class, args);
  }
}

//打包前，先clean一下

//java -jar springboot_02_config-0.0.1-SNAPSHOT.jar --spring.profiles.active=test
//通过这个命令启动springboot jar包 --spring.profiles.active=test选择使用哪个环境
