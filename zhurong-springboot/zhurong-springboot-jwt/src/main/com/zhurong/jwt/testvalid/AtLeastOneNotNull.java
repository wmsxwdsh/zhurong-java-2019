package com.zhurong.jwt.testvalid;

import org.yaml.snakeyaml.introspector.PropertyUtils;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 验证至少有一个不能为空
 *
 * @author admin
 */
@Target({TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = AtLeastOneNotNull.AtLeastOneNotNullValidator.class)
@Documented
public @interface AtLeastOneNotNull {

    String message() default "at least one not null";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String[] fieldNames();

    class AtLeastOneNotNullValidator implements ConstraintValidator<AtLeastOneNotNull, Object> {

        private String[] fieldNames;

        @Override
        public void initialize(AtLeastOneNotNull constraintAnnotation) {
            this.fieldNames = constraintAnnotation.fieldNames();
        }

        @Override
        public boolean isValid(Object object, ConstraintValidatorContext constraintContext) {

            if (object == null) {
                return true;
            }
            try {
                for (String fieldName : fieldNames) {
                    Object property = new PropertyUtils().getProperty(object.getClass(), fieldName);
                    if (property != null) {
                        return true;
                    }
                }
                return false;
            } catch (Exception e) {
                return false;
            }
        }
    }


}
