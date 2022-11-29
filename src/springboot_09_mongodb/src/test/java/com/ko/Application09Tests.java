package com.ko;

import com.ko.pojo.Book;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootTest
class Application09Tests {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    void contextLoads() {
    }

    @Test
    void test1(){
        Book book = new Book();
        book.setId(1);
        book.setName("springboot1");
        book.setType("springboot1");
        book.setDescription("springboot1");
        mongoTemplate.save(book);
    }

    @Test
    void test2(){
        List<Book> all = mongoTemplate.findAll(Book.class);
        System.out.println(all);
    }
}
