package com.example.task1;

import java.util.List;

import lombok. Singular;
import lombok. ToString;
import lombok. experimental.SuperBuilder;

@SuperBuilder @ToString(callSuper=true)
public class Student extends User{
    @Singular
    public List<Integer> grades;
}
