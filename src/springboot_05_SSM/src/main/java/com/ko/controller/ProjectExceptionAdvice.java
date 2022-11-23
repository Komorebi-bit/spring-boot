package com.ko.controller;

import com.ko.exception.BusinessException;
import com.ko.exception.SystemException;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Komorebi
 * @date 2022.07.18.21:32
 */
@RestControllerAdvice // 要被加载到
// rest风格开发使用这个  @ControllerAdvice 非rest风格用这个
// 自带@ResponseBody,@Component

// 异常处理器集中的，统一的处理项目中出现的异常
public class ProjectExceptionAdvice {

    @ExceptionHandler(SystemException.class)
    //拦截异常 设置指定异常的处理方案，功能等同于控制器方法，出现异常后终止原始控制器执行，并转入当前方法执行
    public Result doSystemException(SystemException e){
        //记录日志
        //发送消息给运维
        //发送邮件给开发人员,e对象发送给开发人员
        return new Result(e.getCode(), null, e.getMessage());
    }

    @ExceptionHandler(BusinessException.class)
    public Result doBusinessException(BusinessException e){
        return new Result(e.getCode(), null, e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Result doException(Exception e){
        //记录日志
        //发送消息给运维
        //发送邮件给开发人员,e对象发送给开发人员
        return new Result(Code.SYSTEM_UNKNOW_ERR,null,"系统繁忙，请稍后再试！");
    }
}
