package com.jiangyue.demo4printstream;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

public class UsePrintStream {
    public static void main(String[] args){
        printStream();
    }

    public static void printStream(){
        try (
                PrintStream ps = new PrintStream(new FileOutputStream("resource/example.txt", true));
                PrintWriter pw = new PrintWriter(new FileOutputStream("resource/example.txt", true));
        ) {
            ps.println("hello world");
            ps.println(99);
            ps.println("你好");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
