package com.jiangyue.demo1dynamicproxy;

public interface UserMapper {
    User add(User user);
    void delete(String email);
    void update(User user);
}
