package com.example.assigment.Data;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Request {
    private String name;
    private String path;

    public Request() {
    }

    public Request(String name, String path) {
        this.name = name;
        this.path = path;
    }
}
