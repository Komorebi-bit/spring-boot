package com.ko.testcase.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Komorebi
 * @since 2022.11.27.15:54
 */
@Data
@Component
@ConfigurationProperties(prefix = "testcase.book")
public class BookCase {
    private int id;
    private String name;
    private String uuid;
    private long publishTime;
}
