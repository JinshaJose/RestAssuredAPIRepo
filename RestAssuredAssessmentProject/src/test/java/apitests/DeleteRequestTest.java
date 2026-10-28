package apitests;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class DeleteRequestTest {
	@Test
	public void deletePost(){
		given()
		.when()
		.delete(" https://dummyjson.com/users/1")
		.then()
		.statusCode(200)// Validate the status code is 200.
		.log().all()
		.body("id",equalTo(1))//Validate the response contains the deleted user's ID. 
		.body("isDeleted", equalTo(true))//3. If the response includes isDeleted, validate that it is true. 
		.contentType("application/json")//4. Validate the response Content-Type and print the response body.
		;
	}

}
