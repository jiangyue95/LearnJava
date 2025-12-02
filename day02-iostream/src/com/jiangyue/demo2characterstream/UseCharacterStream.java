package com.jiangyue.demo2characterstream;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;

public class UseCharacterStream {
    public static void main(String[] args) {
        try {
//            readFile();
            writeFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void readFile() throws Exception {
        // 文件字符输入流读取文件中的字节数组到内存中去
        Reader reader = new FileReader("resource/example1.txt");
        // 创建一个数组，用来存储从文件中读取的字符数组
        char[] chars = new char[10];
        int len = reader.read(chars);
        while (len != -1) {
            System.out.println(new String(chars, 0, len));
            len = reader.read(chars);
        }
    }

    public static void writeFile() throws Exception {
        // 字符输出流, 不覆盖需要加 true
        Writer writer = new FileWriter("resource/output.txt", true);
        writer.write("\n");
        // 写入字符串的一部分
        writer.write("Writer", 1, 2);
        // 刷新缓冲区，写入数据
        writer.flush();
    }
}
