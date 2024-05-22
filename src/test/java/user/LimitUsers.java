package user;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class LimitUsers {
    @Test
    public void checkFirstLimitationUser(){
        given()
                .baseUri("https://fakestoreapi.com")
                .param("limit" , 5)
        .when()
                .get("/users")
        .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .body("[0].id" , equalTo(1))
                .body("[0].address.geolocation.lat" , equalTo("-37.3159"))
                .body("[0].address.geolocation.long" , equalTo("81.1496"))
                .body("[0].address.city" , equalTo("kilcoole"))
                .body("[0].address.number" , equalTo(7682))
                .body("[0].username" , equalTo("johnd"))
                .body("[0].password" , equalTo("m38rmF$"))
                .body("[0].name.firstname" , equalTo("john"))
                .body("[0].name.lastname" , equalTo("doe"));
    }
    @Test
    public void checkLastLimitationUser(){
        given()
                .baseUri("https://fakestoreapi.com")
                .param("limit" , 5)
        .when()
                .get("/users")
        .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .body("[4].id" , equalTo(5))
                .body("[4].address.geolocation.lat" , equalTo("40.3467"))
                .body("[4].address.geolocation.long" , equalTo("-40.1310"))
                .body("[4].address.city" , equalTo("san Antonio"))
                .body("[4].address.number" , equalTo(245))
                .body("[4].username" , equalTo("derek"))
                .body("[4].password" , equalTo("jklg*_56"))
                .body("[4].name.firstname" , equalTo("derek"))
                .body("[4].name.lastname" , equalTo("powell"));
    }
}
