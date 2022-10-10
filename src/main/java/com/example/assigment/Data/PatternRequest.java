package com.example.assigment.Data;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class PatternRequest extends Request{
    private String pattern;
    public PatternRequest(String name, String path, String pattern) {
        super();
        this.setName(name);
        this.setPath(path);
        this.setPattern(pattern);

    }

}
