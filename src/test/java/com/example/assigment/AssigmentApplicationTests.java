package com.example.assigment;

import com.example.assigment.Data.TestRequest;
import com.example.assigment.Data.TestResponse;
import com.example.assigment.Directory.api.DirectoryController;
import io.restassured.response.ResponseBody;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.File;

import static groovy.json.JsonOutput.toJson;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


//@SpringBootTest
@RunWith(SpringRunner.class)
@WebMvcTest(DirectoryController.class)
class AssigmentApplicationTests {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private DirectoryController directoryController;
	@Test
	public void createDirectoryTest() throws Exception{
		String path = new File("").getAbsolutePath();
		path = path.replace("\\","/");
		TestRequest request = new TestRequest("aTest",path);
		mvc.perform(post("/directory").contentType(MediaType.APPLICATION_JSON)
				.content(toJson(request)))
				.andExpect(status()
						.isCreated());
	}

	@Test
	public void deleteDirectoryTest() throws Exception{
		String path = new File("").getAbsolutePath();
		path = path.replace("\\","/");
		TestRequest request = new TestRequest("aTest",path);
		mvc.perform(post("/directory").contentType(MediaType.APPLICATION_JSON)
				.content(toJson(request)));
		mvc.perform(delete("/directory").contentType(MediaType.APPLICATION_JSON)
						.content(toJson(request)))
				.andExpect(status()
						.isOk());
	}

	@Test
	public void getContentOfDirectoryTest() throws Exception{
		String path = new File("").getAbsolutePath();
		path = path.replace("\\","/");
		TestRequest request = new TestRequest(".idea",path);
		mvc.perform(post("/directory/content").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
						.content(toJson(request)))
				.andExpect(result -> content().contentType(MediaType.APPLICATION_JSON));
		/*MvcResult result = mvc.perform(post("/directory/content").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
				.content(toJson(request))).andReturn();
		MockHttpServletResponse response = result.getResponse();
		String body = response.getContentAsString();
		System.out.println(response.getContentAsString());*/
	/*	RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("directory/content")
				.content(toJson(request))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);*/

	//	MvcResult result = mvc.perform(requestBuilder).andReturn();

		//MockHttpServletResponse response = result.getResponse();

	}

	/*@Test
	public void createFileTest() throws Exception{
		String path = new File("").getAbsolutePath();
		path = path.replace("\\","/");
		TestRequest request = new TestRequest("aTest.txt",path);
		mvc.perform(post("/file/create").contentType(MediaType.APPLICATION_JSON)
						.content(toJson(request)))
						.andExpect(status()
						.isCreated());
	}
*/

/*
	@Test
	void testCreateDirectory() throws Exception{
		RestAssured.baseURI = "localhost:8080";
		RequestSpecification request = RestAssured.given();
		JSONObject requestParams = new JSONObject();
		requestParams.put("name", "test");
		String path = new File("").getAbsolutePath();
		System.out.println(path);
		requestParams.put("path", path);
		//request.header("Content-Type", "application/json"); // Add the Json to the body of the request
		request.body(requestParams.toString());
		Response response = request.post("/file");
		ResponseBody body = response.getBody();
		System.out.println(response.getStatusLine());
		System.out.println(body.asString());
	}*/
	/*
	TestResponse createDirectory(String name, String path) throws Exception{
		TestRequest request = new TestRequest();
		request.setName(name);
		request.setPath(path);
		MvcResult mvcResult = mockMvc.perform(post("/product")
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON)
						.content(objectToString(product))
				).andExpect(statusMatcher)
				.andDo(mvcResult1 -> {
					TestProductResponse productToControl = stringToObject(mvcResult1, TestProductResponse.class);
					assert Objects.equals(product.getName(), productToControl.getName());
					assert Objects.equals(product.getDescription(), productToControl.getDescription());
					assert Objects.equals(product.getUnit(), productToControl.getUnit());
					assert Objects.equals(product.getAmount(), productToControl.getAmount());
				})
				.andReturn();
		return stringToObject(mvcResult, TestProductResponse.class);
		return null;
	}



	@Test
	void contextLoads() {

		RestAssured.baseURI ="https://demoqa.com/Account/v1";
		RequestSpecification request = RestAssured.given();
		JSONObject requestParams = new JSONObject();
		requestParams.put("userName", "test_rest");
		requestParams.put("password", "Testrest@123");
		request.body(requestParams.toJSONString());
		Response response = request.put("/User");
		ResponseBody body = response.getBody();
		System.out.println(response.getStatusLine());
		System.out.println(body.asString());
	}*/

}
