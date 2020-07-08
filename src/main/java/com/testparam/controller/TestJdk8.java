package com.testparam.controller;

import java.util.*;
import java.util.stream.Collectors;

public class TestJdk8 {
    public static void main(String[] args) {
        Student s1 = new Student(1L, "肖战", 15, "浙江");

        Student s2 = new Student(2L, "王一博", 15, "湖北");

        Student s3 = new Student(3L, "杨紫", 19, "北京");

        Student s4 = new Student(4L, "李现", 17, "浙江");

        List<Student> students = new ArrayList<>();

        students.add(s1);

        students.add(s2);

        students.add(s3);

        students.add(s4);

        boolean b = students.stream().allMatch(st1 -> st1.getAge() < 20);
        System.out.println(b);
        boolean b1 = students.stream().anyMatch(st2 -> st2.getAge() >= 29);
        System.out.println(b1);
        boolean b2 = students.stream().noneMatch(st3 -> st3.getAge() > 100);
        System.out.println(b2);

    }
}
