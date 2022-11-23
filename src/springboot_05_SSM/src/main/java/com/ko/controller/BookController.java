package com.ko.controller;

import com.ko.domain.Book;
import com.ko.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Komorebi
 * @date 2022.07.17.22:48
 */

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public Result save(@RequestBody Book book) {
        boolean flag = bookService.save(book);
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR, flag);
    }

    @PutMapping
    public Result update(@RequestBody Book book) {
        boolean flag = bookService.update(book);
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        boolean flag = bookService.delete(id);
        return new Result(flag ? Code.DELETE_OK : Code.DELETE_ERR, flag);
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        // int i = 1/0;
        Book book = bookService.getById(id);
        Integer code;
        String msg;
        if(book!=null){
            code = Code.GET_OK;
            msg = "";
        }else{
            code = Code.GET_ERR;
            msg = "数据查询失败，请重试";
        }
        return new Result(code,book,msg);
    }

    @GetMapping
    public Result getAll() {
        List<Book> all = bookService.getAll();
        Integer code;
        String msg;
        if(all != null){
            code = Code.GET_OK;
            msg = "";
        }else{
            code = Code.GET_ERR;
            msg = "数据查询失败，请重试";
        }
        return new Result(code,all,msg);
    }
}
