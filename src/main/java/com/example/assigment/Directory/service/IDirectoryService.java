package com.example.assigment.Directory.service;

import com.example.assigment.Data.Request;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

public interface IDirectoryService {
    boolean createDirectory(Request body) throws IOException;

    boolean deleteDirectory(Request body) throws IOException;

    boolean doesDirectoryExist(Path path);

    public ArrayList<String> getContentOfDir(Request body);
}
