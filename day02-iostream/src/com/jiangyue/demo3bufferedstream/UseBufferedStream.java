package com.jiangyue.demo3bufferedstream;

import java.io.*;

public class UseBufferedStream {
    public static void main(String[] args) {
        copyFile("resource/example1.txt", "resource/outputbs.txt");
        useBufferedReaderWriter();
    }

    public static void copyFile(String source, String destination) {
        try (// 创建一个文件输入流
             InputStream is = new FileInputStream(source);
             // 创建一个缓冲输入流
             InputStream bis = new BufferedInputStream(is);
             // 创建一个文件输出流
             OutputStream os = new FileOutputStream(destination);
             // 创建一个缓冲输出流
             OutputStream bos = new BufferedOutputStream(os);
             ) {
            byte[] b = new byte[1024];
            int len;
            while ((len = bis.read(b)) != -1) { // 使用缓冲输入字节流读入数据
                bos.write(b, 0, len); // 使用缓冲输出流写出数据
            }
            bos.flush();
            System.out.println("复制完成");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void useBufferedReaderWriter() {
        try (
                BufferedReader br = new BufferedReader(new FileReader("resource/example1.txt"));
                BufferedWriter bw = new BufferedWriter(new FileWriter("resource/outputbs.txt"));
                ){
            String line = null;
            while ((line = br.readLine()) != null) {
                // Buffered.readLine() 读取一行为特有的换行功能，不用多态写法
                // 目前读取文本最优方案
                System.out.println(line);
                bw.write(line); // 复制语句
                bw.newLine(); // 换行功能
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
