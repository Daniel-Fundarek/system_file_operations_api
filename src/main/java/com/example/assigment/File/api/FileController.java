package com.example.assigment.File.api;


import com.example.assigment.Data.*;
import com.example.assigment.File.service.IFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/file")
public class FileController {
    private IFileService fileService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Response createFile(@RequestBody Request body) throws IOException {
        return new Response(fileService.createFile(body));
    }

    @DeleteMapping("")
    public Response deleteFile(@RequestBody Request body){
        return new Response(fileService.deleteFile(body));
    }

    @PostMapping("/move")
    public Response moveFile(@RequestBody MoveFileRequest body) throws IOException {
        return new Response(fileService.moveFile(body));
    }

    @PostMapping("/copy")
    @ResponseStatus(HttpStatus.CREATED)
    public Response copyFile(@RequestBody MoveFileRequest body) throws IOException {
        return new Response(fileService.copyFile(body));
    }
    @PostMapping("/content")
    public FileContentResponse copyFile(@RequestBody Request body) throws IOException {
        return new FileContentResponse(fileService.getFileContent(body));
    }
    @PostMapping("/pattern")
    public FilePatternResponse copyFile(@RequestBody PatternRequest body) throws IOException {
        return new FilePatternResponse(fileService.searchForPattern(body));
    }

    @Autowired
    public void setFileService(IFileService service){
        this.fileService = service;
    }



}
