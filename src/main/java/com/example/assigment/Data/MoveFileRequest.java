package com.example.assigment.Data;

import lombok.Data;

@Data
public class MoveFileRequest {
    private String sourcePath;
    private String targetPath;
    private String sourceName;
    private String targetName;
}
