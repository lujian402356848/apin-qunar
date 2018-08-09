package com.apin.qunar.app;

import lombok.Data;

import java.util.List;

@Data
public class User {
    private String name;
    private List<Student> students;

    @Data
    public static class Student {
        private int age;
        private Integer sort;
        private String name;
    }
}
