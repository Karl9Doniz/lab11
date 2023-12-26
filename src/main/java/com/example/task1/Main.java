package com.example.task1;

public class Main {
    public static void main(String[] args) {
        User user = Student.builder().name("Andrii")
                .age(19)
                .gender(Gender.MALE)
                .grade(120)
                .build();
        System.out.println(user);
    }
}
