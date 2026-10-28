package apitests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

import org.testng.annotations.Test;

import user.UserPatch;


public class PatchRequestTest {
	
	@Test
	public void updateUser() {
	UserPatch userpatch = new UserPatch(35);
	given()
	.baseUri("https://dummyjson.com/")
	.body(userpatch)
	.headers("Content-Type","application/json")
	.when()
	.patch("/users/1")
	.then()
	.statusCode(200)// 1. Validate the status code is 200.
	.body("age", equalTo(35))// 2. Validate the response age is 35.
	.header("Connection", "keep-alive")// 4. Validate relevant response headers and print the response body.
	.log().all()
	.body("id", equalTo(1))// 3. Validate the response contains the user ID. 
	.time(lessThan(3000l))
;	

}
}

//Request body: { "age": 35 } 
