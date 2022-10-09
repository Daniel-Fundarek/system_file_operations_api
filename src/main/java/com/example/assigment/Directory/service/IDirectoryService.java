package com.example.assigment.Directory.service;

import com.example.assigment.Data.Request;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public interface IDirectoryService {
    public boolean createDirectory(Request body) throws IOException;

    public boolean deleteDirectory(Request body) throws IOException;

    public boolean doesDirectoryExist(Path path);

    public File[] getContentOfDir(Request body);
}
