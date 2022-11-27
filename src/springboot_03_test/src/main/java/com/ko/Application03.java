package com.ko;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * @author Komorebi
 */
@SpringBootApplication
public class Application03 {

  public static void main(String[] args) {
    SpringApplication.run(Application03.class, args);
  }
}
//这个类，会把他所在的包及其子包扫描一遍
