package user;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetAllUsers {

    @Test
    public void checkFirstUser(){
        given()
                .baseUri("https://fakestoreapi.com")
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
    public void checkSecondUser(){
        given()
                .baseUri("https://fakestoreapi.com")
        .when()
                .get("/users")
        .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .body("[1].id" , equalTo(2))
                .body("[1].address.geolocation.lat" , equalTo("-37.3159"))
                .body("[1].address.geolocation.long" , equalTo("81.1496"))
                .body("[1].address.city" , equalTo("kilcoole"))
                .body("[1].address.number" , equalTo(7267))
                .body("[1].username" , equalTo("mor_2314"))
                .body("[1].password" , equalTo("83r5^_"))
                .body("[1].name.firstname" , equalTo("david"))
                .body("[1].name.lastname" , equalTo("morrison"));
    }
    @Test
    public void checkLastUser(){
        given()
                .baseUri("https://fakestoreapi.com")
        .when()
                .get("/users")
        .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .body("[9].id" , equalTo(10))
                .body("[9].address.geolocation.lat" , equalTo("30.24788"))
                .body("[9].address.geolocation.long" , equalTo("-20.545419"))
                .body("[9].address.city" , equalTo("fort wayne"))
                .body("[9].address.number" , equalTo(526))
                .body("[9].username" , equalTo("jimmie_k"))
                .body("[9].password" , equalTo("klein*#%*"))
                .body("[9].name.firstname" , equalTo("jimmie"))
                .body("[9].name.lastname" , equalTo("klein"));
    }
}
