/**
 * @Title: CheckIdCardValidator.java
 * @Package: com.zhurong.solution.beanvalidation.validator
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 https://onezg.cnblogs.com
 */
package com.zhurong.db.persistence.validator;

import com.zhurong.utils.general.IdCardUtil;
import com.zhurong.utils.general.StringUtil;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @description: 真正校验的类
 * @author LZG
 * @date 2019/3/21
 */
public class CheckIdCardValidator implements ConstraintValidator<IdCardValidator, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {

        //如果bean的属性上已经加了@NotNull，此处就不用了
        if(StringUtil.isBlank(value)) {
            return false;
        }

        return  IdCardUtil.validateCard(value);
    }

}