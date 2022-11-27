package com.ko.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ko.pojo.Book;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Komorebi
 * @since 2022.11.27.15:27
 */

@Mapper
public interface BookDao extends BaseMapper<Book> {

}
