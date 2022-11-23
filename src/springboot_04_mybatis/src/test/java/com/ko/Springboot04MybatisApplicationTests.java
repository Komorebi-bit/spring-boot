package com.ko;

import com.ko.dao.BookDao;
import com.ko.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot04MybatisApplicationTests {

  @Autowired
  private BookDao bookDao;

  @Test
  void testGetById() {
    Book book = bookDao.getById(1);
    System.out.println(book);
  }
}
