package com.example.assigment.Directory.service;

import com.example.assigment.Data.Request;
import com.example.assigment.Exceptions.BadRequestException;
import com.example.assigment.Exceptions.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

@Service
public class DirectoryService implements IDirectoryService {


    @Override
    public boolean createDirectory(Request body) throws IOException {
        Path path = Paths.get(body.getPath() + "/" + body.getName());
        if (doesDirectoryExist(path)) {
            throw new BadRequestException();
        }
        Files.createDirectories(path);
        return true;
    }


    @Override
    public boolean deleteDirectory(Request body) throws IOException {
        Path path = Paths.get(body.getPath() + "/" + body.getName());
        if (!doesDirectoryExist(path)) {
            throw new NotFoundException();
        }
        return FileSystemUtils.deleteRecursively(path);

    }


    @Override
    public boolean doesDirectoryExist(Path path) {
        File file = new File(path.toUri());
        return file.isDirectory();
    }

    @Override
    public ArrayList<String> getContentOfDir(Request body) {
        Path path = Paths.get(body.getPath() + "/" + body.getName());
        doesDirectoryExist(path);
        ArrayList<String> nameArray = new ArrayList<>();
        File f = new File(path.toUri());
        File[] files = f.listFiles();
        if (files != null) {
            Arrays.sort(files, File::compareTo);
            for (File file : files) {
                nameArray.add(file.getName());
            }
        }

        //Stream<File> stream = Arrays.stream(files);
        //stream.forEach(str -> str.getName());
        //return new ArrayList<String>(Arrays.asList());
        return nameArray;
    }

}
