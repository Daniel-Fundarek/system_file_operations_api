package com.example.assigment.Directory.service;

import com.example.assigment.Directory.Data.DirectoryRequest;

public interface IDirectoryService {
    boolean createDirectory(DirectoryRequest body);

    boolean deleteDirectory(DirectoryRequest body);

}
