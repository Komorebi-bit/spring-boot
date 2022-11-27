package com.ko.service.impl;

import com.ko.dao.BookDao;
import com.ko.pojo.Book;
import com.ko.service.BookService;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Komorebi
 * @date 2022.07.21.21:12
 */

@Service
public class BookServiceImpl implements BookService {
    @Resource
    private BookDao bookDao;
    @Override
    public void save() {
        System.out.println("book service is running ...");
    }

    @Override
    public boolean save1(Book book) {
        return bookDao.insert(book) == 1;
    }
}
