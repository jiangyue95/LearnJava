package com.jiangyue.demotest3;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        String info = "10001, 张无忌, 男, 2023-07-22 11:11:12, 东湖-黄鹤楼" +
                "#10002, 赵敏, 女, 2023-07-22 09:11:21, 黄鹤楼-归元禅寺" +
                "#10003, 周芷若, 女, 2023-07-22 04:11:21, 木兰文化区-东湖" +
                "#10004, 小昭, 女, 2023-07-22 08:11:21, 东湖" +
                "#10005, 灭绝, 女, 2023-07-22 17:11:21, 归元禅寺";
        List<Student> students = new ArrayList();
        students = parseInfo(info);
        showStudentInfo(students);
        Map<String, Integer> locationCount = caculateLocation(students);
        System.out.println(locationCount);
        String maxLocation = getMaxLocation(locationCount);
        System.out.println("Max Location: " + maxLocation);
        List<Student> notSelectStudents = checkSelectLocation(students, maxLocation);
        showStudentInfo(notSelectStudents);

    }

    private static void showStudentInfo(List<Student> students) {
        for (Student student : students) {
            System.out.println(
                    student.getId()
                            + " "
                            + student.getName()
                            + " "
                            + student.getGender()
                            + " "
                            + student.getSelectDateTime()
                            + " "
                            + student.getSelectLocations());
        }
    }

    private static List<Student> checkSelectLocation(List<Student> students, String maxLocation) {
        List<Student> notSelectStudents = new ArrayList();
        for (Student student : students) {
            if (!student.getSelectLocations().contains(maxLocation)) {
                notSelectStudents.add(student);
            }
        }
        return notSelectStudents;
    }

    private static String getMaxLocation(Map<String, Integer> locationCount) {
        String maxKey = null;
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : locationCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxKey = entry.getKey();
                maxCount = entry.getValue();
            }
        }
        return maxKey;
    }

    private static Map<String, Integer> caculateLocation(List<Student> students) {
        Map<String, Integer> locationCount = new HashMap();
        for(Student student : students) {
            for (String location : student.getSelectLocations()) {
                if (locationCount.containsKey(location)) {
                    locationCount.put(location, locationCount.get(location) + 1);
                } else {
                    locationCount.put(location, 1);
                }
            }
        }
        return locationCount;
    }



    private static List<Student> parseInfo(String info) {
        String[] studentsInfo = info.split("#");
        List<Student> students = new ArrayList();
        for (String studentInfo : studentsInfo) {
            Student student = parseStudentInfo(studentInfo);
            students.add(student);
        }
        return students;
    }

    private static Student parseStudentInfo(String studentInfo) {
        String[] studentInfoArray = studentInfo.split(",");
        Student student = new Student();
        for (int i = 0; i < studentInfoArray.length; i++) {
            if (i == 0) {
                student.setId(Integer.parseInt(studentInfoArray[i].trim()));
            } else if (i == 1) {
                student.setName(studentInfoArray[i].trim());
            } else if (i == 2) {
                student.setGender(studentInfoArray[i].trim());
            } else if (i == 3) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                student.setSelectDateTime(LocalDateTime.parse(studentInfoArray[i].trim(), formatter));
            } else if (i == 4) {
                String rawString = studentInfoArray[i].trim();
                student.setSelectLocations(List.of(rawString.split("-")));
            }
        }
        return student;
    }
}
