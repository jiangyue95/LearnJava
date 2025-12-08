package com.jiangyue.demo1annotation;

public class Example {
    @MyC(name="Tom", age=18)
    @My("Jerry")
    public static void main(String[] args) {
        System.out.println("hello world");
    }
}
