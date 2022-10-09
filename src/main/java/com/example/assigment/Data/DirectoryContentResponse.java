package com.example.assigment.Data;


import lombok.Data;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.ArrayList;

@Data

public class DirectoryContentResponse {
    ArrayList<FileInfo> content;

    public DirectoryContentResponse(File[] files) {
        content = new ArrayList<>();
        for (File file : files) {
            FileInfo info;
            if (!file.isDirectory()) {
                info = new FileInfo(file.getName(), file.length());
            } else {
                info = new FileInfo(file.getName(), FileUtils.sizeOfDirectory(file));
            }

            content.add(info);
        }
    }
}
