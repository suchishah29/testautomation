package testcase.RestAssuredTesting;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;


@Test
public class waysToCreatePostRequestBody {
int studentid;
String strid;
   //  post request body using hashmap
    public void testPostUsingHashMap() {
        Map<String, Object> data = new HashMap<>();
        data.put("name", "Suchi ss");
        data.put("location", "ahmdabad");
        //data.put("phoneno", "8866738101");

        String courses[] = {"c", "c++"};
        data.put("courses", courses); // Adding the "courses" array to the request body

        studentid= given()
            .contentType("application/json")
            .body(data)
            .when()
            .post("http://localhost:3000/students")
            .jsonPath()
			.getInt("id");
         strid=Integer.toString(studentid);
        given()
        .when()
        .get("http://localhost:3000/students/" + strid)
        .then()
        .statusCode(200) // Check if the record is successfully created and retrievable
        .body("name", equalTo("Suchi ss"))
        .body("courses[0]", equalTo("c"))
        .header("Content-Type", "application/json")
        .log().all();
    }
    
//    // post request body using org.json library
//    public void testPostUsingHashMap() {
//       JsonObject jdata = new JsonObject();
//       jdata.pu("name", "Suchi");
//       
//        studentid= given()
//            .contentType("application/json")
//            .body(data)
//            .when()
//            .post("http://localhost:3000/students")
//            .jsonPath()
//			.getInt("id");
//        
//        given()
//        .when()
//        .get("http://localhost:3000/students/" + studentid)
//        .then()
//        .statusCode(200) // Check if the record is successfully created and retrievable
//        .body("name", equalTo("Suchi"))
//        .body("courses[0]", equalTo("c"))
//        .header("Content-Type", "application/json")
//        .log().all();
//    }
    @Test(priority = 2)
    public void deleteRequest() {
    	given()
    	.when().delete("http://localhost:3000/students"+strid)
    	.then().statusCode(200);
    }
}
