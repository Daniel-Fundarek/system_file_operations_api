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


    @Override
    public boolean deleteDirectory(DirectoryRequest body) {
        var path = Paths.get(body.getPath() + "/" + body.getName());
        try {
            FileSystemUtils.deleteRecursively(path);
        } catch (IOException e) {
            return false;
        }
        return true;

    }
}
