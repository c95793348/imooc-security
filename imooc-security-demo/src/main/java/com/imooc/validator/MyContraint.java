package com.imooc.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by wbcaoa on 2018/5/15.
 */
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MyContraintValidator.class)
public @interface MyContraint {
    String message();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
