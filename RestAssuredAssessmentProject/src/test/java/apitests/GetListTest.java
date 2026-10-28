package apitests;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetListTest {
	@Test
	public void getList()
	{
		given()
		.when()
		.get("https://dummyjson.com/users")
		.then()
		.statusCode(200)//1. Validate the status code is 200.
		.contentType("application/json")// 2. Validate the response Content-Type is JSON. 
		.log().all()
		.time(lessThan(3000l))//5. Validate the response time is less than 3000 milliseconds.
		.body("users", notNullValue())
		.body("total", notNullValue())//3. Validate that the response contains a users array and a total field.
		.header("Content-Type", notNullValue())// 4. Validate that the Content-Type header exists. 
		;
		// 
	}

}
