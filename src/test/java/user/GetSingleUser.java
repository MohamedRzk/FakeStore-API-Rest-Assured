package user;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetSingleUser {

    @Test
    public void checkSingleUser(){
        given()
                .baseUri("https://fakestoreapi.com")
        .when()
                .get("/users/1")
        .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .body("id" , equalTo(1))
                .body("address.geolocation.lat" , equalTo("-37.3159"))
                .body("address.geolocation.long" , equalTo("81.1496"))
                .body("address.city" , equalTo("kilcoole"))
                .body("address.number" , equalTo(7682))
                .body("username" , equalTo("johnd"))
                .body("password" , equalTo("m38rmF$"))
                .body("name.firstname" , equalTo("john"))
                .body("name.lastname" , equalTo("doe"));
    }
}
