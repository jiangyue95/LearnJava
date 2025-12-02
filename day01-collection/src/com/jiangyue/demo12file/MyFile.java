package com.jiangyue.demo12file;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

public class MyFile {
    public static void main(String[] args) {
        getFileInfo();
    }

    private static void getFileInfo() {
        String path = "resource/text.txt";
        String path2 = "resource/notexits.txt";
        showFileBaseInfo(path2);
        System.out.println("==========");
        showFileBaseInfo(path);
        System.out.println("==========");
        System.out.println("Create unexisting file");
        createUnexistingFile(path2);
        System.out.println("==========");
        System.out.println("Create directory");
        createDirectory("resource/demo");
        System.out.println("==========");
        System.out.println("Create multiple level directory");
        createDirectory("resource/demo2/demo2/demo3");
        System.out.println("==========");
        System.out.println("Delete directory");
        deleteDirectory("resource/demo");
//        deleteDirectory("resource/demo2/demo2/demo3");
        getAllFiles("resource");
    }

    private static void getAllFiles(String path) {
        java.io.File[] files = new java.io.File(path).listFiles();
        System.out.println("文件夹下文件个数：" + files.length);
        System.out.println("文件列表：");
        for (java.io.File file : files) {
            System.out.println(file.getName() + ":" + file.getAbsolutePath());
        }
    }

    private static void deleteDirectory(String path) {
        java.io.File file = new java.io.File(path);
        if (file.exists()) {
            file.delete();
        } else {
            System.out.println("Directory not exists");
        }
    }

    private static void createDirectory(String path) {
        java.io.File file = new java.io.File(path);
        if (!file.exists()) {
            file.mkdirs();
        } else {
            System.out.println("Directory exists");
        }
    }

    private static void createUnexistingFile(String path) {
        java.io.File file = new java.io.File(path);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File exists");
        }
    }

    private static void showFileBaseInfo(String path) {
        java.io.File file = new java.io.File(path);
        System.out.println("文件名：" + file.getName());
        System.out.println("文件是否存在：" + file.exists());
        System.out.println("文件是否可读：" + file.canRead());
        System.out.println("文件是否可写：" + file.canWrite());
        System.out.println("文件大小：" + file.length());
        System.out.println("文件大小（KB）：" + new DecimalFormat("0.00").format(file.length()/1024.0) + "KB");
        System.out.println("问价大小（MB）：" + new DecimalFormat("0.00").format(file.length()/1024.0/1024.0) + "MB");
        System.out.println("文件名字：" + file.getName());
        System.out.println("文件父目录：" + file.getParent());
        System.out.println("是不是文件：" + file.isFile());
        System.out.println("是不是目录：" + file.isDirectory());
        System.out.println("获取绝对路径：" + file.getAbsolutePath());
        System.out.println("最后修改时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(file.lastModified()));
    }



}
