package com.ko;

import com.ko.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = Application03.class)
//括号里内容一般不用写，当不在同一包下是再加
class Application03Tests {

  @Autowired
  private BookService bookService;

  // @Autowired
  // private String msg;
  @Test
  public void testSave() {
      bookService.save();
      //System.out.println(msg);
  }
}
