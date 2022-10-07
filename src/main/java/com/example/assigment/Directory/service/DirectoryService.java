package com.example.assigment.Directory.service;

import com.example.assigment.Directory.Data.DirectoryRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class DirectoryService implements IDirectoryService {


    @Override
    public boolean createDirectory(DirectoryRequest body) {
        var path = Paths.get(body.getPath() + "/" + body.getName());
        try {
            Files.createDirectories(path);
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    public boolean deleteDirectory(File directoryToBeDeleted) {

        File[] allContents = directoryToBeDeleted.listFiles();
        if (allContents != null) {
            for (File file : allContents) {
                deleteDirectory(file);
            }
        }
        return directoryToBeDeleted.delete();
    }

    @Override
    public boolean deleteDirectory(DirectoryRequest body) {

        File dir = new File(body.getPath() + "/" + body.getName());
        return deleteDirectory(dir);

    }
}
