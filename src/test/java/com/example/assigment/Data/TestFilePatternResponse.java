package com.example.assigment.Data;

import lombok.Data;

import java.util.ArrayList;
@Data
public class TestFilePatternResponse {

    private ArrayList<TestFilePattern> patternArrayList;
    public TestFilePatternResponse(ArrayList<TestFilePattern> searchForPattern) {
        this.patternArrayList = searchForPattern;
    };

}
