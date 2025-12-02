package com.jiangyue.demo1useiostream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class UseIO {
    public static void main(String[] args) {
        copyFile();
        copyFile2();
    }

    private static void copyFile2() {
        try (
                FileInputStream fis = new FileInputStream("resource/example.jpeg");
                FileOutputStream fos = new FileOutputStream("resource/example_copy2.jpeg");)
        {
            byte[] b = new byte[1024];
            int len;
            while ((len = fis.read(b)) != -1) {
                fos.write(b, 0, len);
            }
            System.out.println("copy2 复制完成");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void copyFile() {
        // 复制文件流程：
        // 文件-> 创建字节输入流管道 -> read -> 字节数组 -> write -> 创建字节输出流 -> 另一个文件

        // 创建字节流管道
        // 定义流为空，确保 finally 内部能够使用
        FileOutputStream fos =  null;
        FileInputStream fis = null;
        try {
            // read
            fis = new FileInputStream("resource/example.jpeg");
            fos = new FileOutputStream("resource/example_copy.jpeg");
            // 字节数组
            byte[] b = new byte[1024];
            int len;
            while ((len = fis.read(b)) != -1) {
                // write
                fos.write(b, 0, len);
            }
            System.out.println("copy 复制成功");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
                if (fis != null) {
                    fis.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
