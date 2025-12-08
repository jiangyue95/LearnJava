package com.jiangyue.demo1dynamicproxy;

public class User implements UserMapper {
    private String name;
    private String password;
    private String email;

    public User() {
    }

    public User(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }

    @Override
    public User add(User user) {
        System.out.println("Add user successfully.");
        return user;
    }

    @Override
    public void delete(String email) {
        System.out.println("Delete user successfully.");
    }

    @Override
    public void update(User user) {
        System.out.println("Update user successfully.");
    }
}
