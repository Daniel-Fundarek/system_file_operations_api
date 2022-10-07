package com.example.assigment.Directory.Data;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class DirectoryResponse {

    private boolean succeed;
    public DirectoryResponse(boolean succeed) {
        this.succeed = succeed;
    }
}
