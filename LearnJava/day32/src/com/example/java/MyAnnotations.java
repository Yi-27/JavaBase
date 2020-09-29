package com.example.java;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 * @author Yi-27
 * @create 2020-09-29 10:07
 */
@Inherited // MyAnnotation2有该注解的话，要是关联重复注解则需要加上此注解
@Retention(RetentionPolicy.RUNTIME) // 运行时保留，即可通过反射获取到该注解
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE}) // 限制该注解只能使用在这些结构上面
public @interface MyAnnotations {
    // 旧重复注解的写法
    MyAnnotation2[] value(); // 重复注解
//    String value();
}
