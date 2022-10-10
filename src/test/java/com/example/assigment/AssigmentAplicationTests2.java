package com.example.assigment;

import com.example.assigment.Data.TestMoveFileRequest;
import com.example.assigment.Data.TestPatternRequest;
import com.example.assigment.Data.TestRequest;
import com.example.assigment.File.api.FileController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.io.File;

import static groovy.json.JsonOutput.toJson;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


//@SpringBootTest
@RunWith(SpringRunner.class)
@WebMvcTest(FileController.class)
public class AssigmentAplicationTests2 {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private FileController fileController;

    @Test
    public void createFileTest() throws Exception{
        String path = new File("").getAbsolutePath();
        path = path.replace("\\","/");
        TestRequest request = new TestRequest("aTest.txt",path);
        mvc.perform(post("/file").contentType(MediaType.APPLICATION_JSON)
                        .content(toJson(request)))
                .andExpect(status()
                        .isCreated());
    }

    @Test
    public void deleteFileTest() throws Exception{
        String path = new File("").getAbsolutePath();
        path = path.replace("\\","/");
        TestRequest request = new TestRequest("aTest.txt",path);
        mvc.perform(post("/file").contentType(MediaType.APPLICATION_JSON)
                .content(toJson(request)));
        mvc.perform(delete("/file").contentType(MediaType.APPLICATION_JSON)
                        .content(toJson(request)))
                .andExpect(status()
                        .isOk());
    }
    @Test
    public void moveFileTest() throws Exception{
        String path = new File("").getAbsolutePath();
        path = path.replace("\\","/");
        TestRequest request0 = new TestRequest("aTest.txt",path);
        mvc.perform(post("/file").contentType(MediaType.APPLICATION_JSON)
                .content(toJson(request0)));
        TestRequest request = new TestRequest("aTest.txt",path);
        mvc.perform(post("/file/move").contentType(MediaType.APPLICATION_JSON)
                        .content(toJson(request)))
                .andExpect(status()
                        .isOk());
    }

    @Test
    public void copyFileTest() throws Exception{

        String path = new File("").getAbsolutePath();
        path = path.replace("\\","/");
        TestRequest request0 = new TestRequest("aTest.txt",path);
        mvc.perform(post("/file").contentType(MediaType.APPLICATION_JSON)
                .content(toJson(request0)));
        TestMoveFileRequest request = new TestMoveFileRequest();
        request.setSourceName("aTest.txt");
        request.setSourcePath(path);
        request.setTargetName("aTest.txt");
        request.setTargetPath(path + "/test");
        mvc.perform(post("/file/copy").contentType(MediaType.APPLICATION_JSON)
                        .content(toJson(request)))
                .andExpect(status()
                        .isCreated());
    }
    @Test
    public void getFileContent() throws Exception{
        String path = new File("").getAbsolutePath();
        path = path.replace("\\","/");
        TestRequest request0 = new TestRequest("aTest.txt",path);
        mvc.perform(post("/file").contentType(MediaType.APPLICATION_JSON)
                .content(toJson(request0)));
        TestRequest request = new TestPatternRequest("aTest.txt",path,"d");
        mvc.perform(post("/file/content").contentType(MediaType.APPLICATION_JSON)
                        .content(toJson(request)))
                .andExpect(status()
                        .isOk());
    }

}
