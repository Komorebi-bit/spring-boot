package com.ko.service.impl;

import com.ko.service.BookService;
import org.springframework.stereotype.Service;

/**
 * @author Komorebi
 * @date 2022.07.21.21:12
 */

@Service
public class BookServiceImpl implements BookService {
    @Override
    public void save() {
        System.out.println("book service is running ...");
    }
}
