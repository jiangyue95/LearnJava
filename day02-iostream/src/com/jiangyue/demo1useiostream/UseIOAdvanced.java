package com.jiangyue.demo1useiostream;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class UseIOAdvanced {
    public static void main(String[] args) {

        try {
//            readFileBySingleByte();
//            readFileByMultipleByte();
            writeFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeFile() throws Exception {
        // 字节输出流，不覆盖需要加 true
        // 文件字节输出流将字节数组写入文件中，当文件字节流输出后，文件原本的内容会被覆盖
        // 1、创建文件字节输出流对象，覆盖掉原文件
        FileOutputStream fos = new FileOutputStream("resource/output.txt");
        // 2、将字节数组写入文件中
        fos.write(new byte[]{'a', 100, 'A', 54, 64});
        byte[] bytes = "hello world".getBytes();
        fos.write(bytes);
        // 3、关闭流
        fos.close();

        // 追加数据
        FileOutputStream addfos = new FileOutputStream("resource/output.txt", true);
        addfos.write("hello world".getBytes());
        addfos.close();
    }

    public static void readFileByMultipleByte() throws  Exception {
        // 文件字节输出流
        // 1、创建文件字节输入流对象
        FileInputStream fis = new FileInputStream("resource/example1.txt");
        // 每次读取多个字节
//        byte[] b = new byte[7];
//        // 定义一个变量存储每次读取的字节个数
//        int len;
//        // 每次读取多个字节，与文件交互少，单读汉字有可能被截断
//        while ((len = fis.read(b)) != -1) {
//            System.out.println(new String(b, 0, len));
//        }
        // 定义一个与文件一样大的字节数组，这样用字节读取汉字就不会乱码，只适合读小文件
        System.out.println(new String(fis.readAllBytes()));
        fis.close();
    }

    public static void readFileBySingleByte() throws Exception {
        // 文件字节输出流
        // 1、创建文件字节输入流对象
        FileInputStream fis = new FileInputStream("resource/example1.txt");

        // 2、读取文件中字节并输出
        int a;
        while ((a = fis.read()) != -1) {
            System.out.print((char) a);
        }
    }
}
