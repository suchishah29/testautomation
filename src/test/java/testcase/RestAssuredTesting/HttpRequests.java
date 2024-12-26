package testcase.RestAssuredTesting;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

import net.bytebuddy.build.Plugin.Factory.UsingReflection.Priority;

public class HttpRequests {
	int id;

	@Test(priority = 1)
	void getUSer() {

		given()
		.when().get("https://reqres.in/api/users?page=2").
		then().statusCode(200)
		.body("page", equalTo(2)).log()
				.all();
//		String url = "https://reqres.in/api/users?page=2";
//		String get = "";
	}

	@Test(priority = 2)
	void createUser() {
		HashMap hm = new HashMap<String, String>();
		hm.put("name", "suchi");
		hm.put("job", "Automation engineer");
		id = given().contentType("application/json")
				.body(hm)
				.when().post("https://reqres.in/api/users").jsonPath()
				.getInt("id");
//		.then().statusCode(201)
//		.log().all();

	}

	@Test(priority = 3,dependsOnMethods = {"createUser"})
	void updateUser() {
		HashMap hm = new HashMap<String, String>();
		hm.put("name", "suchi vishal");
		hm.put("job", "Team leadAutomation engineer");
		given().contentType("application/json").body(hm)
				.when().put("https://reqres.in/api/users/"+id)
		.then().statusCode(200)
		.log().all();

	}
	
//	@Test(priority = 4,dependsOnMethods = {"createUser"})
//	void deleteUser() {
//		given()
//	    .when().delete("https://reqres.in/api/users/"+id)
//		.then().statusCode(204)
//		.log().all();
//
//	}

}