package com.example.assigment.Data;

import lombok.Data;

@Data
public class TestRequest {
    private String name;
    private String path;

    public TestRequest() {
    }

    public TestRequest(String name, String path) {
        this.name = name;
        this.path = path;
    }
}
