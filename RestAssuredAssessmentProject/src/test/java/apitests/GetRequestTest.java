package apitests;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetRequestTest {
	@Test
	public void getTodo(){
		given()
		.when()
		.get("https://dummyjson.com/users/1")
		.then()
		.statusCode(200) // Validate that the status code is 200.
		.body("id", notNullValue())// Validate that the response contains the user's ID.
		.body("firstName", notNullValue())//Validate that firstName and email are not null.
		.body("email", notNullValue())//Validate that firstName and email are not null.
		.contentType("application/json")//content type json
		.time(lessThan(3000l))// Validate that the response time is less than 3000 milliseconds.
		.log().all();//Print the complete response body.
		
		
	}
	
    }



