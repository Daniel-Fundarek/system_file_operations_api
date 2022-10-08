package com.example.assigment.File.service;


import com.example.assigment.Data.Request;
import com.example.assigment.Data.MoveFileRequest;

import java.io.IOException;
import java.nio.file.Path;

public interface IFileService {

    public boolean createFile(Request body) throws IOException;

    public boolean deleteFile(Request body);

    public boolean copyFile(MoveFileRequest body, boolean move) throws IOException;

    public boolean copyFile(MoveFileRequest body) throws IOException;

    public boolean moveFile(MoveFileRequest body) throws IOException;

    boolean doesFileExists(Path path);

    boolean doesDirectoryExist(Path path);
}
