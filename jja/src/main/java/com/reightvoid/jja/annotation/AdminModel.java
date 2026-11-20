package com.reightvoid.jja.annotation;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface AdminModel{
    Class<?> value();
    String name();
    String path();
} 