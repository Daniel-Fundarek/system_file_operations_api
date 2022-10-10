package com.example.assigment.Data;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
@Data
@AllArgsConstructor
public class TestFilePattern {
    private String name;
    private ArrayList<Integer> linesNum = new ArrayList<>();

    public TestFilePattern(String name) {
        this.name = name;
    }
}
