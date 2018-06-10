package com.baizhi.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
//注解使用时机
@Retention(RetentionPolicy.RUNTIME)
public @interface UserAnnonation {
    public String name();
}
