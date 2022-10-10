package com.example.assigment.Data;

import lombok.Data;

@Data
public class TestPatternRequest extends TestRequest {
    private String pattern;
    public TestPatternRequest(String name, String path, String pattern) {
        super();
        this.setName(name);
        this.setPath(path);
        this.setPattern(pattern);

    }

}
