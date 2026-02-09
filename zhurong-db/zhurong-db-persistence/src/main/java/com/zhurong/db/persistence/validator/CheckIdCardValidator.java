package com.zhurong.db.persistence.validator;

import com.zhurong.utils.common.StringUtil;
import com.zhurong.utils.gen.IdCardValidateUtil;
//import javax.validation.ConstraintValidator;
//import javax.validation.ConstraintValidatorContext;

/**
 * @description: 真正校验的类
 * @author LZG
 * @date 2019/3/21
 */
//public class CheckIdCardValidator implements ConstraintValidator<IdCardValidator, String> {
//
//    @Override
//    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
//
//        //如果bean的属性上已经加了@NotNull，此处就不用了
//        if(StringUtil.isBlank(value)) {
//            return false;
//        }
//
//        return  IdCardValidateUtil.validateCard(value);
//    }
//
//}