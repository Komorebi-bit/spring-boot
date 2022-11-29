package com.ko;

import com.ko.dao.BookDao;
import com.ko.pojo.Book;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

@SpringBootTest
class Application07Tests {
    //@Autowired
    // private BookDao bookDao;

    @Test
    void contextLoads() {
    }

    @Test
    void test(){
        // bookDao.selectById(1);
    }

    @Test
    void testJdbcTemplate(@Autowired JdbcTemplate jdbcTemplate){
        String sql = "select * from book";
        // List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        // System.out.println(maps);
        RowMapper<Book> rm = new RowMapper<Book>() {
            @Override
            public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
                Book temp = new Book();
                temp.setId(rs.getInt("id"));
                temp.setName(rs.getString("name"));
                temp.setType(rs.getString("type"));
                temp.setDescription(rs.getString("description"));
                return temp;
            }
        };
        List<Book> list = jdbcTemplate.query(sql, rm);
        System.out.println(list);

    }

    @Test
    void testH2(@Autowired JdbcTemplate jdbcTemplate){
        String sql = "insert into book values(3,'springboot3','springboot3','springboot3')";
        int count = jdbcTemplate.update(sql);
        System.out.println(count);

    }
}
