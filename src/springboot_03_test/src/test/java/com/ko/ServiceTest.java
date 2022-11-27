package com.ko;

import com.ko.pojo.Book;
import com.ko.service.BookService;
import javax.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Komorebi
 * @since 2022.11.27.15:39
 */
@SpringBootTest
@Transactional //默认回滚
@Rollback(true)
public class ServiceTest {
    @Resource
    private BookService bookService;

    @Test
    public void testSave1(){
        Book book = new Book();
        book.setId(100);
        book.setName("222");
        book.setType("333");
        book.setDescription("5555");
        bookService.save1(book);
    }
}
