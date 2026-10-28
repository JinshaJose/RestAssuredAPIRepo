package apitests;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class NegativeTest {
	@Test
	public void negativeGet() {
		given()
		.when()
		.get("https://dummyjson.com/users/999999")//Send a request using an invalid user ID.
		.then()
		.log().all()
		.statusCode(404)// 2. Observe and validate the actual error status code returned.
		.body("message", equalTo("User with id '999999' not found"))//3. Validate the error message or relevant response body field.
		.contentType("application/json; charset=utf-8")
		.time(lessThan(3000l))//4. Validate response Content-Type and response time.
		
		;
		//5. Do not assume the status code or error structure; inspect the actual response first.
	}

}
