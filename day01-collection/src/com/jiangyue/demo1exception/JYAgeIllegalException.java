package com.jiangyue.demo1exception;

/**
 * 自定义的编译时异常
 * 1. 继承 Exception
 * 2. 重写 Exception 的构造器
 * 3. 哪里需要用这个异常，哪里就 throw
 */

public class JYAgeIllegalException extends Exception {
    public JYAgeIllegalException() {
    }

    public JYAgeIllegalException(String message) {
        super(message);
    }
}
