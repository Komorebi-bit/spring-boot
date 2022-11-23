package com.ko;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Springboot03TestApplication {

  public static void main(String[] args) {
    SpringApplication.run(Springboot03TestApplication.class, args);
  }
}
//这个类，会把他所在的包及其子包扫描一遍
