package com.jiangyue.demo1dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class UserProxy {
    public static <T> T getInstance(T t) {
        T usm = (T) Proxy.newProxyInstance(
                t.getClass().getClassLoader(),
                t.getClass().getInterfaces(),
                new InvocationHandler() {
                    private T target = t;
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        // declare what proxy will do
                        if ("add".equals(method.getName())) {
                            System.out.println("add");
                        } else if ("delete".equals(method.getName())) {
                            System.out.println("delete");
                        } else if ("update".equals(method.getName())) {
                            System.out.println("update");
                        }
                        return method.invoke(t, args);
                    }
                }
        );
        return usm;
    }
}
