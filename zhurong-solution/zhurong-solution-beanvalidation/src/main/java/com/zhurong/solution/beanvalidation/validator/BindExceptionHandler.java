/**
 * @Title: BindExceptionHandler.java
 * @Package: com.zhurong.solution.beanvalidation.validator
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.solution.beanvalidation.validator;

import com.zhurong.utils.response.InfoCoinResponse;
import java.util.List;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @description: 异常捕获类
 * @author LZG
 * @date 2019/3/21
 */
@RestControllerAdvice
public class BindExceptionHandler {

    @ExceptionHandler(BindException.class)
    public InfoCoinResponse handleBindException(BindException ex) {

        // ex.getFieldError():随机返回一个对象属性的异常信息。
        // 如果要一次性返回所有对象属性异常信息，则调用ex.getAllErrors()
        List<FieldError> fieldErrorList = ex.getFieldErrors();

        StringBuilder sb = new StringBuilder();

        for(FieldError fieldError : fieldErrorList) {
            sb.append(fieldError.getField()).append("=[").append(fieldError.getRejectedValue()).append("]")
                .append(fieldError.getDefaultMessage() + " ");
        }

        // 生成返回结果
        return InfoCoinResponse.build("400", sb.toString());
    }

}
