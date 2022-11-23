package com.ko;

import com.ko.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = Springboot03TestApplication.class)
//括号里内容一般不用写，当不在同一包下是再加
class Springboot03TestApplicationTests {

  @Autowired
  private BookService bookService;

  @Test
  public void testSave() {
      bookService.save();
  }
}
