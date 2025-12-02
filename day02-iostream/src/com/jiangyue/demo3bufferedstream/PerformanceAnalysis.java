package com.jiangyue.demo3bufferedstream;

import java.io.*;

// 性能分析 performance analysis
public class PerformanceAnalysis {
    public static void main(String[] args) {
        // create test file, only run once.
//        generateTestFile();
        // 使用低级字节流一个一个字节的形式复制代码耗时29527ms，能正常打开，如果桶的大小为 8kb，则耗时11ms
//        copyFileByte();
        // 使用低级的字符流耗时 877ms，如使用8192 缓冲则耗时 36ms
        copyFileCharacter();
        // 使用缓冲流复制代码耗时 12ms
        copyFileBuffered();
    }

    // 使用 BufferedWriter 创建测试用文件
    public static void generateTestFile() {
        File file = new File("resource/test.txt");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file));){
            String line = "hello world";
            long bytesWritten = 0;
            long target = 12090L * 1024;
            while (bytesWritten < target) {
                bw.write(line);
                bytesWritten += line.getBytes().length;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("完成，大小：" + file.length() / 1024 + "KB");

    }
    public static void copyFileByte() {
        long start = System.currentTimeMillis();
        try (
                FileInputStream fis = new FileInputStream("resource/test.txt");
                FileOutputStream fos = new FileOutputStream("resource/test_copy.txt");
                ){
            byte[] b = new byte[8192];
            int len;
            while ((len = fis.read(b)) != -1) {
                fos.write(b, 0, len);
            }
            System.out.println("复制完成，耗时：" + (System.currentTimeMillis() - start) + "ms");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void copyFileCharacter() {
        long start = System.currentTimeMillis();
        System.out.println("开始复制");
        try (
                FileReader fr = new FileReader("resource/test.txt");
                FileWriter fw = new FileWriter("resource/test_copyc.txt");
                ){
            char[] c = new char[8192];
            int len;
            while ((len = fr.read(c)) != -1) {
                fw.write(c, 0, len);
            }
            System.out.println("复制完成，耗时：" + (System.currentTimeMillis() - start) + "ms");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void copyFileBuffered() {
        long start = System.currentTimeMillis();
        System.out.println("开始复制");
        try (
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream("resource/test.txt"));
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("resource/test_copyb.txt"));
                ) {
            byte[] b = new byte[8192];
            int len;
            while ((len = bis.read(b)) != -1) {
                bos.write(b, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("复制完成，耗时：" + (System.currentTimeMillis() - start) + "ms");
    }
}
