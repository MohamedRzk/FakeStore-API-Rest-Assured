package login;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import java.io.*;

public class UserLogIn {
    File body = new File ("src/test/data/logIn.json");

    @Test
    public void firstTestCase() {
        given()
                .baseUri("https://fakestoreapi.com")
                .body(body)
                .header("Content-Type" , "application/json")
        .when()
                .post("/auth/login")
        .then()
                .assertThat()
                .body("token" , containsString("eyJhbGciOiJIUzI1NiIsInR"));

    }
    @Test
    public void secondTestCase() {
        given()
                .baseUri("https://fakestoreapi.com")
                .body(body)
                .header("Content-Type" , "application/json")
                .when()
                .post("/auth/login")
                .then()
                .assertThat().statusCode(200)
                .body("token" , startsWith("eyJhbGciOiJIUzI1NiIsInR"));

    }
}