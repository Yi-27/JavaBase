package com.example.java;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

/**
 * @author Yi-27
 * @create 2020-09-29 9:49
 */
@Inherited
@Repeatable(MyAnnotations.class) // 要控制生命两者的 Retention 和 Retention 不起冲突
@Retention(RetentionPolicy.RUNTIME) // 运行时保留，即可通过反射获取到该注解
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, TYPE_PARAMETER, TYPE_USE}) // 限制该注解只能使用在这些结构上面
public @interface MyAnnotation2 {
    String value();
}
