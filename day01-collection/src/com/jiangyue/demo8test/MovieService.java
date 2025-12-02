package com.jiangyue.demo8test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieService {
    // 4. 准备一个集合容器：存储全部上架的电影数据。
    private static List<Movie> movies = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    public void start() {
        // 1. 准备操作界面
        while (true) {
            System.out.println("----------电影管理系统----------");
            System.out.println("1. 添加电影");
            System.out.println("2. 删除电影");
            System.out.println("3. 查询电影");
            System.out.println("4. 封杀某个明星");
            System.out.println("5. 显示所有电影");
            System.out.println("0. 退出系统");
            System.out.println("请输入您的选择：");
            String command = sc.next();
            switch (command) {
                case "1":
                    addMovie();
                    break;
                case "2":
                    removeMovie();
                    break;
                case "3":
                    queryMovie();
                    break;
                case "4":
                    killActor();
                    break;
                case "5":
                    showAllMovies();
                    break;
                case "0":
                    System.out.println("感谢使用！");
                    System.exit(0);
                default:
                    System.out.println("输入有误！请重新输入！");

            }
        }
    }

    /**
     * 显示所有电影
     */
    private void showAllMovies() {
        System.out.println("=======所有电影列表=======");
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    /**
     * 封杀某个明星：
     * 1. 输入要封杀的明星名称
     * 2. 遍历集合，判断集合中是否有此明星
     * 3. 删除此明星
     */
    private void killActor() {
        System.out.println("=======封杀某个明星=======");
        System.out.println("请输入要封杀的明星：");
        String name = sc.next();
        for (int i = 0; i < movies.size(); i++) {
            Movie movie = movies.get(i);
            if (movie.getActor().contains(name)) {
                movies.remove(movie);
                System.out.println("封杀成功！");
                i--;
            }
        }
    }

    /**
     * 查询电影：根据电影名称查询电影对象
     */
    private void queryMovie() {
        System.out.println("=======查询电影名称=======");
        System.out.println("请输入电影名称：");
        String name = sc.next();
        // 根据电影名称查询电影对象返回，展示这个对象数据。
        Movie movie = queryMovieByName(name);
        if (movie != null) {
            System.out.println(movie);
        } else {
            System.out.println("没有此电影！");
        }
    }

    // 根据电影名称查询电影对象返回
    public Movie queryMovieByName(String name) {
        for (Movie movie : movies) {
            if (movie.getName().equals(name)) {
                return movie;
            }
        }
        return null;
    }

    private void removeMovie() {
        System.out.println("=======删除电影名称=======");
        System.out.println("请输入电影名称：");
        String name = sc.next();
        Movie movie = queryMovieByName(name);
        if (movie != null) {
            movies.remove(movie);
        } else {
            System.out.println("没有此电影！");
        }
    }

    /**
     * 添加电影
     */
    private void addMovie() {
        // 分析：每点击一次上架电影，其实就是新增一部电影。每部电影是一个电影对象封装数据的
        // 1. 创建一个电影对象，封装这部电影信息
        Movie movie = new Movie();
        // 2. 给电影对象注入数据
        System.out.println("请输入电影名称：");
        movie.setName(sc.next());
        System.out.println("请输入电影评分：");
        movie.setScore(sc.nextDouble());
        System.out.println("请输入主演：");
        movie.setActor(sc.next());
        System.out.println("请输入价格：");
        movie.setPrice(sc.nextDouble());
        // 3. 把电影对象添加到集合中
        movies.add(movie);
    }
}
