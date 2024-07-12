package com.rookie.im.user.common.annotation;

import org.springframework.context.annotation.Conditional;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

//注解的作用：校验dto参数是否为手机号码

//一下是一个注解的基本配置
//注解可以用在哪些地方 字段、参数、方法、注解类型
@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)//注解的生命周期，在运行时期
@Documented//注解是否应该被javadoc工具记录
@Constraint(validatedBy = {
        IsMobileValidator.class
}) //注解的校验器，这里是IsMobileValidator
public @interface IsMobile {

    //是否通过
    boolean required() default true; //是否为必填项
    String message() default "手机号码格式错误"; //错误提示信息
    Class<?>[] groups() default {}; //分组
    Class<? extends Payload>[] payload() default {}; //负载
}
