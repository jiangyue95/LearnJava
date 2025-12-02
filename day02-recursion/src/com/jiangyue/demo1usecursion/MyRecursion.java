package com.jiangyue.demo1usecursion;

import java.io.File;
import java.io.IOException;

public class MyRecursion {
    public static void main(String[] args) {
        System.out.println(factorial(5));
        String fileName = startFileSearch();
        File dir = new File("resource");
        try {
            searchFile(dir, fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    public static String startFileSearch() {
        System.out.println("请输入要查找的文件名：");
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        return scanner.next();

    }

    public static void searchFile(File dir, String fileName) throws IOException {
        if (dir == null || !dir.exists() || !dir.isDirectory()) return; // 文件不存在
        // 获取目录下的所有一级文件或文件夹对象
        File[] files = dir.listFiles();
        if (files != null && files.length > 0) {
            for (File file : files) {
                if (file.isFile()) {
                    if (file.getName().equals(fileName)) {
                        System.out.println("找到文件：" + file.getAbsolutePath());
                        return;
                    }
                } else {
                    searchFile(file, fileName);
                }
            }
        }
    }
}
