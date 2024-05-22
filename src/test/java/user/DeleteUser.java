package user;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class DeleteUser {

    @Test
    public void VerifyDeletingUser(){
        given()
                .baseUri("https://fakestoreapi.com")
        .when()
                .delete("/users/6")
        .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .body("id" , equalTo(6))
                .body("address.geolocation.lat" , equalTo("20.1677"))
                .body("address.geolocation.long" , equalTo("-10.6789"))
                .body("address.city" , equalTo("el paso"))
                .body("address.number" , equalTo(124))
                .body("username" , equalTo("david_r"))
                .body("password" , equalTo("3478*#54"))
                .body("name.firstname" , equalTo("david"))
                .body("name.lastname" , equalTo("russell"));;
    }
}
