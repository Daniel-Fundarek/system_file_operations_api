package com.example.assigment.Data;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
@Data
@AllArgsConstructor
public class DirectoryContentResponse {
    ArrayList<String> content;
}
