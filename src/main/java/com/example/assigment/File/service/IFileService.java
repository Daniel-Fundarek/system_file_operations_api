package com.example.assigment.File.service;


import com.example.assigment.Data.FilePattern;
import com.example.assigment.Data.PatternRequest;
import com.example.assigment.Data.Request;
import com.example.assigment.Data.MoveFileRequest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

public interface IFileService {

    public boolean createFile(Request body) throws IOException;

    public boolean deleteFile(Request body);

    public boolean copyFile(MoveFileRequest body, boolean move) throws IOException;

    public boolean copyFile(MoveFileRequest body) throws IOException;

    public boolean moveFile(MoveFileRequest body) throws IOException;

    public boolean doesFileExists(Path path);

    public String getFileContent(Request body) throws IOException;


    public ArrayList<FilePattern> searchForPattern(PatternRequest body) throws FileNotFoundException;


}
