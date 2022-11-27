package com.ko;

import com.ko.testcase.pojo.BookCase;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Komorebi
 * @since 2022.11.27.12:55
 */
// @SpringBootTest(properties = "test.pro=testArgs1")
//properties属性可以为当前测试用例添加临时属性配置
// @SpringBootTest(args = "--test.pro=testArgs2") //args添加临时命令行参数
@SpringBootTest(properties = "test.pro=testArgs1",args = "--test.pro=testArgs2")
//这两个版本不同，优先级不同
public class PropertiesAndArgsTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(PropertiesAndArgsTest.class);
    @Value("${test.pro}")
    private String msg;

    @Autowired
    private BookCase bookCase;

    @Test
    public void testProperties(){
        System.out.println(msg);
    }

    @Test
    public void testBookCase(){
        System.out.println(bookCase.toString());
    }
}
