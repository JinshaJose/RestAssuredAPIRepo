package apitests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

import org.testng.annotations.Test;

import user.UserPut;



public class PutRequestTest {
	
	@Test
	public void updateUser() {
	UserPut userput = new UserPut("Rahul","Menon",30);
	given()
	.baseUri("https://dummyjson.com/")
	.body(userput)
	.headers("Content-Type","application/json")
	.when()
	.put("/users/1")
	.then()
	.statusCode(200)
	.body("firstName", equalTo("Rahul"))
	.body("age", equalTo(30))
	.header("Content-Type", "keep-alive")
	.log().all()
	.time(lessThan(3000l))
;	

}
}

//Request body: { "firstName": "Rahul", "lastName": "Menon", "age": 30 }
//Tasks: 1. Validate the status code is 200. 
//2. Validate the response contains firstName Rahul. 
//3. Validate the response contains age 30. 
//4. Validate the Content-Type response header. 
//5. Validate response time and print the response body.