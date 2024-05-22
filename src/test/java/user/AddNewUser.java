package user;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.io.*;

public class AddNewUser {
File user = new File("src/test/data/newUser.json");

    @Test
    public void VerifyAddingNewUser(){
        given()
                .baseUri("https://fakestoreapi.com")
                .body(user)
        .when()
                .post("/users")
        .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .body("id" , equalTo(11));
    }
}