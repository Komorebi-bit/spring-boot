package com.ko.dao;

import com.ko.domain.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author Komorebi
 * @date 2022.07.21.23:19
 */

@Mapper
public interface BookDao {

    @Select("select * from book where id = #{id}")
    Book getById(Integer id);
}
