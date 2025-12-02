package com.jiangyue.demo9set;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;
import java.util.Objects;
import java.util.TreeSet;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Comparable<Student> {
    private String name;
    private int age;
    private String gender;

    @Override
    public boolean equals(Object obj) {
        // this 指向当前对象，obj 引用对象，判断是否为同一个对象
        if (this == obj) return true;
        // 判断对象是否为空，并且判断对象类型是否一致
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return age == student.age &&
                name.equals(student.name) &&
                gender.equals(student.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, gender);
    }
    // TreeSet 不能为自定义对象排序，因为不知道大小规则
    // 方案一：对象类实现一个 Comparable 接口，并实现 compareTo 方法，指定大小比较规则
    // Student 类需要继承 Comparable<Student>
    @Override
    public int compareTo(Student o) {
        // 比较者：this
        // 被比较者：o
        // 规则 1:若左边大于右边，返回正整数
        // 规则 2:若左边小于右边，返回负整数
        // 规则 3:若左边等于右边，返回0
        // 年龄升序
        if (this.age != o.age) {
            return 1;
        } else if (this.age < o.age) {
            return -1;
        }
        return 1; // 如果为 0 的话，则会删除二者之一不显示，若为 1 的话返回 this
        // return this.age - o.age; // 升序
        // return o.age - this.age; // 降序
    }

}
