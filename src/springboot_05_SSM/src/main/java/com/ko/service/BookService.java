package com.ko.service;

import com.ko.domain.Book;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Komorebi
 * @date 2022.07.17.22:47
 */

@Transactional
public interface BookService {

    /**
     * 保存
     * @param book
     * @return
     */
    boolean save(Book book);

    /**
     * 修改
     * @param book
     * @return
     */
    boolean update(Book book);

    /**
     * 根据id删除
     * @param id
     * @return
     */
    boolean delete(Integer id);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    Book getById(Integer id);

    /**
     * 查询全部
     * @return
     */
    List<Book> getAll();

}
