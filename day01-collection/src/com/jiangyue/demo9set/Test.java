package com.jiangyue.demo9set;

import java.util.Comparator;
import java.util.TreeSet;

public class Test {
    public static void main(String[] args) {
        // 方案二：public TreeSet(Comparator c) 集合自带比较器 Comparator 对象，指定比较规则
        TreeSet<Student> s2 = new TreeSet<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
//                return o1.getAge() - o2.getAge(); // 若为 double 则强转有风险
//                return Double.compare(o1.getAge(), o2.getAge()) // 使用封装函数
                if (o1.getAge() > o2.getAge()) return 1;
                else if (o1.getAge() < o2.getAge()) return -1;
                else return 1; // 这样写更保险并且操作性更高，可以免掉去重
            }
        });
        // Lambda 表达式简化
        TreeSet<Student> s3 = new TreeSet<>((o1, o2) -> Double.compare(o1.getAge(), o2.getAge()));
        // 方法引用简化
        TreeSet<Student> s4 = new TreeSet<>(Comparator.comparingInt(Student::getAge));
    }
}
