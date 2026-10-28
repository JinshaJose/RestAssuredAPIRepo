package apitests;
import org.testng.annotations.Test;

import user.User;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PostRequestTest {
	@Test
	public void createUser() {
	User user = new User("Arun","Kumar",25,"arun@example.com");
	given()
	.baseUri("https://dummyjson.com/")
	.body(user)
	.headers("Content-Type","application/json")
	.when()
	.post("/users/add")
	.then()
	.statusCode(201)// 1. Validate the expected creation status code based on the actual API response (DummyJSON commonly returns 201).
	.body("firstName", equalTo("Arun"))//2. Validate firstName is Arun and lastName is Kumar.
	.body("lastName", equalTo("Kumar"))
	.body("age", equalTo(25))//3. Validate age is 25.
	.contentType("application/json")//4. Validate the response Content-Type and at least one relevant response header.
	.header("Connection", "keep-alive")
	.log().all()//5. Print the response body.
;	
	
	}
	
	
	
	
	//Request body: { "firstName": "Arun", "lastName": "Kumar", "age": 25, "email": "arun@example.com" } 
	

}
