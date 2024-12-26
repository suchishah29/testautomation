package testcase;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class MyApiTest {
	@Test
	public void testGet() {
		RestAssured.get("http://my-api.com/resource/123").then().assertThat().statusCode(200).and()
				.contentType(ContentType.JSON).and().body("id", equalTo(123));
	}
	@Test
	void httpGet() {
		RestAssured.get("\"https://reqres.in/api/users?page=2")
				.then().statusCode(200)
				.body("page", equalTo(2)).log()
				.all();
	}
}
