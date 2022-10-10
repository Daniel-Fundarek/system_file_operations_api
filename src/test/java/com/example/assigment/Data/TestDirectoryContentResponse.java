package com.example.assigment.Data;


import lombok.Data;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.ArrayList;

@Data

public class TestDirectoryContentResponse {
    ArrayList<TestFileInfo> content;

    public TestDirectoryContentResponse(File[] files) {
        content = new ArrayList<>();
        for (File file : files) {
            TestFileInfo info;
            if (!file.isDirectory()) {
                info = new TestFileInfo(file.getName(), file.length());
            } else {
                info = new TestFileInfo(file.getName(), FileUtils.sizeOfDirectory(file));
            }

            content.add(info);
        }
    }
}
