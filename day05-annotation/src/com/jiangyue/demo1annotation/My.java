package com.jiangyue.demo1annotation;

public @interface My {
    String value();
    int age() default 18;
}
