package com.example.task2;

import lombok.AllArgsConstructor;
import lombok.Getter;


enum Sex {
    MALE, FEMALE
}

@Getter @AllArgsConstructor
public class Client {
    private int id;
    private String name;
    private int age;
    private Sex sex;
}
