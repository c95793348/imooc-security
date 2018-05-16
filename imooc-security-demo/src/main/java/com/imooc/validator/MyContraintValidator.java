package com.imooc.validator;

import com.imooc.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;

/**
 * Created by wbcaoa on 2018/5/15.
 */
public class MyContraintValidator implements ConstraintValidator<MyContraint,Object> {

    @Autowired private HelloService helloService;

    @Override
    public void initialize(MyContraint myContraint) {
        System.out.println("MyContraintValidator init!");
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        helloService.greeting("coco");

        System.out.println("注解校验器 测试注解不通过! " + o);

        return false;
    }


}
