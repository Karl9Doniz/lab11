package com.example.task1;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

enum Gender {
    MALE, FEMALE
}

@Data
@SuperBuilder
public class User {
    private String name;
    private int age;
    private Gender gender;
    private double weight;
    private double height;
}