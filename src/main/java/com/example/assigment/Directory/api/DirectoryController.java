package com.example.assigment.Directory.api;

import com.example.assigment.Data.DirectoryContentResponse;
import com.example.assigment.Data.Request;
import com.example.assigment.Data.Response;
import com.example.assigment.Directory.service.IDirectoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/directory")

public class DirectoryController {


    private IDirectoryService directoryService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Response createDirectory(@RequestBody Request body) throws IOException {
        return new Response(directoryService.createDirectory(body));
    }

    @DeleteMapping("")
    public Response deleteDirectory(@RequestBody Request body) throws IOException {
        return new Response(directoryService.deleteDirectory(body));
    }

    @PostMapping("/content")
    public DirectoryContentResponse getDirectoryContent(@RequestBody Request body){
        return new DirectoryContentResponse(directoryService.getContentOfDir(body));
    }

    @Autowired
    public void setDirectoryService(IDirectoryService service){
        this.directoryService = service;
    }

}
