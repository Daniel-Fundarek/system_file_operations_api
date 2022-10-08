package com.example.assigment.File.service;

import com.example.assigment.Data.Request;
import com.example.assigment.Data.MoveFileRequest;
import com.example.assigment.Exceptions.BadRequestException;
import com.example.assigment.Exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileService implements IFileService {

    @Override
    public boolean createFile(Request body) throws IOException {
        Path path = Paths.get(body.getPath() + "/" + body.getName());
        if (doesFileExists(path)) {
            throw new BadRequestException();
        }
        File file = new File(path.toUri());
        return file.createNewFile();

    }


    @Override
    public boolean deleteFile(Request body) {
        Path path = Paths.get(body.getPath() + "/" + body.getName());
        if (!doesFileExists(path)) {
            throw new NotFoundException();
        }
        File file = new File(path.toUri());
        return file.delete();

    }
    @Override
    public boolean copyFile(MoveFileRequest body) throws IOException {
        return copyFile(body, false);
    }
    @Override
    public boolean moveFile(MoveFileRequest body) throws IOException {
        return copyFile(body,true);
    }
    @Override
    public boolean copyFile(MoveFileRequest body, boolean move) throws IOException {
        Path source = Paths.get(body.getSourcePath() + "/" + body.getSourceName());
        Path target = Paths.get(body.getTargetPath() + "/" + body.getTargetName());
        if(!doesFileExists(source) || !doesDirectoryExist(Paths.get(body.getTargetPath()))){
            throw new NotFoundException();
        }
        if(move){
            Files.move(source,target);
        }else{
            Files.copy(source,target);
        }
        return true;
    }

    @Override
    public boolean doesFileExists(Path path) {
        File file = new File(path.toUri());
        return file.isFile();
    }

    @Override
    public boolean doesDirectoryExist(Path path) {
        File file = new File(path.toUri());
        return file.isDirectory();
    }

}
