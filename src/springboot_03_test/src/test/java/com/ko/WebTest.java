package com.ko;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.ContentResultMatchers;
import org.springframework.test.web.servlet.result.HeaderResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;

/**
 * @author Komorebi
 * @since 2022.11.27.13:47
 */
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc //开启虚拟mvc的调用
public class WebTest {

    @Test
    public void testRandom(){

    }

    @Test
    public void testWeb(@Autowired MockMvc mvc) throws Exception {
        //创建虚拟请求，当前访问/books
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        //执行对应的请求
        mvc.perform(builder);
    }

    @Test
    public void testStatus(@Autowired MockMvc mvc) throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        ResultActions actions = mvc.perform(builder);

        //设定预期值，与真实值进行比较
        //定义本次调用预期值
        StatusResultMatchers status = MockMvcResultMatchers.status();
        //预计本次调用成功 200
        ResultMatcher ok = status.isOk();

        //比对
        actions.andExpect(ok);
    }

    @Test
    public void testBody(@Autowired MockMvc mvc) throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        ResultActions actions = mvc.perform(builder);

        //设定预期值，与真实值进行比较
        //定义本次调用预期值
        ContentResultMatchers content = MockMvcResultMatchers.content();
        ResultMatcher matcher = content.string("spring boot");

        //比对
        actions.andExpect(matcher);
    }

    @Test
    public void testJson(@Autowired MockMvc mvc) throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        ResultActions actions = mvc.perform(builder);

        //设定预期值，与真实值进行比较
        //定义本次调用预期值
        ContentResultMatchers content = MockMvcResultMatchers.content();
        ResultMatcher body = content.json("{\"id\":1,\"name\":\"222\",\"type\":\"333\","
            + "\"description\":\"5555\"}");

        //比对
        actions.andExpect(body);
    }

    @Test
    public void testHeader(@Autowired MockMvc mvc) throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        ResultActions actions = mvc.perform(builder);

        //设定预期值，与真实值进行比较
        //定义本次调用预期值
        HeaderResultMatchers header = MockMvcResultMatchers.header();
        ResultMatcher contentType = header.string("Content-Type", "application/json");

        //比对
        actions.andExpect(contentType);
    }

    //最终的
    @Test
    public void test(@Autowired MockMvc mvc) throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        ResultActions actions = mvc.perform(builder);

        StatusResultMatchers status = MockMvcResultMatchers.status();
        ResultMatcher ok = status.isOk();
        actions.andExpect(ok);

        HeaderResultMatchers header = MockMvcResultMatchers.header();
        ResultMatcher contentType = header.string("Content-Type", "application/json");
        actions.andExpect(contentType);

        ContentResultMatchers content = MockMvcResultMatchers.content();
        ResultMatcher body = content.json("{\"id\":1,\"name\":\"222\",\"type\":\"333\","
            + "\"description\":\"5555\"}");
        actions.andExpect(body);
    }
}
