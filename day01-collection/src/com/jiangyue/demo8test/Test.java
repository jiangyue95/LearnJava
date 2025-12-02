package com.jiangyue.demo8test;

public class Test {
    public static void main(String[] args) {
        // 目标：完成电影案例
        // 1. 创建电影对象：定义电影类
        // 2. 创建一个电影操作对象，专门负责电影的CRUD
        MovieService movieService = new MovieService();
        movieService.start();
    }
}
