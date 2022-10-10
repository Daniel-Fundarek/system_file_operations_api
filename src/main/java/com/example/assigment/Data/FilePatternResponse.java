package com.example.assigment.Data;

import lombok.Data;

import java.util.ArrayList;
@Data
public class FilePatternResponse {

    private ArrayList<FilePattern> patternArrayList;
    public FilePatternResponse(ArrayList<FilePattern> searchForPattern) {
        this.patternArrayList = searchForPattern;
    };

}
