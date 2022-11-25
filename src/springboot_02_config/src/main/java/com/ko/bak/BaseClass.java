package com.ko.bak;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Komorebi
 * @since 2022.11.25.22:14
 * 创建一个类实现logger的变量创建，这样让其它类继承这个类就可以直接使用logger变量了
 */
public class BaseClass {
    protected Class clazz;
    protected static Logger logger;
    public BaseClass(){
        clazz = this.getClass();
        logger = LoggerFactory.getLogger(clazz);
    }
}
