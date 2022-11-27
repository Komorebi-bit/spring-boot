package com.ko.config;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import javax.validation.constraints.Max;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DataSizeUnit;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.stereotype.Component;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;
import org.springframework.validation.annotation.Validated;

/**
 * @author Komorebi
 * @since 2022.11.23.16:25
 */
//定义数据模型封装yml文件中对应的数据
//必须受spring控制才能，才能从spring里读数据，配置为bean
//@Component //不能与@EnableConfigurationProperties(ServerConfig.class)同时使用，否则会报bean不唯一错误
@Data
//指定加载的数据 prefix只能用小写字母，数字，中划线- 区分单词。 支持松散绑定
@ConfigurationProperties(prefix = "servers") //kebab-case 模式

//数据校验，2.开启对当前bean的属性注入校验
@Validated
public class ServerConfig {
    private String idAddress;
    @Max(value = 9000, message = "最大值不能超过9000")
    private String port;

    //jdk8开始支持
    @DurationUnit(ChronoUnit.MINUTES)
    private Duration timeout;

    // @DataSizeUnit(DataUnit.MEGABYTES)
    private DataSize dataSize;
}
