package user;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.io.*;

public class EditUser {
 File Euser = new File("src/test/data/editUser.json");

    @Test
    public void VerifyEditingUser(){
        given()
                .baseUri("https://fakestoreapi.com/users/2")
                .body(Euser)
        .when()
                .patch()
        .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .body("username" , equalTo("walid"))
                .body("password" , equalTo("25asd5#"))
        ;
    }
}
