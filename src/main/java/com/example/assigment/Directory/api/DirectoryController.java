package com.example.assigment.Directory.api;

import com.example.assigment.Directory.Data.DirectoryRequest;
import com.example.assigment.Directory.Data.DirectoryResponse;
import com.example.assigment.Directory.service.IDirectoryService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/directory")
public class DirectoryController {


    private IDirectoryService directoryService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public DirectoryResponse createDirectory(@RequestBody DirectoryRequest body){
        return new DirectoryResponse(directoryService.createDirectory(body));
    }

    @DeleteMapping("/delete")
    public DirectoryResponse deleteDirectory(@RequestBody DirectoryRequest body){
        return new DirectoryResponse(directoryService.deleteDirectory(body));
    }



    @Autowired
    public void setDirectoryService(IDirectoryService service){
        this.directoryService = service;
    }

}
