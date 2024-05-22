package user;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class SortUsers {
    @Test
    public void checkFirstUserAfterSorting(){
        given()
                .baseUri("https://fakestoreapi.com")
                .param("sort" , "desc")
        .when()
                .get("/users")
        .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .body("[0].id" , equalTo(10))
                .body("[0].address.geolocation.lat" , equalTo("30.24788"))
                .body("[0].address.geolocation.long" , equalTo("-20.545419"))
                .body("[0].address.city" , equalTo("fort wayne"))
                .body("[0].address.number" , equalTo(526))
                .body("[0].username" , equalTo("jimmie_k"))
                .body("[0].password" , equalTo("klein*#%*"))
                .body("[0].name.firstname" , equalTo("jimmie"))
                .body("[0].name.lastname" , equalTo("klein"));
    }
    @Test
    public void checkLastUserAfterSorting(){
        given()
                .baseUri("https://fakestoreapi.com")
                .param("sort" , "desc")
        .when()
                .get("/users")
        .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .body("[9].id" , equalTo(1))
                .body("[9].address.geolocation.lat" , equalTo("-37.3159"))
                .body("[9].address.geolocation.long" , equalTo("81.1496"))
                .body("[9].address.city" , equalTo("kilcoole"))
                .body("[9].address.number" , equalTo(7682))
                .body("[9].username" , equalTo("johnd"))
                .body("[9].password" , equalTo("m38rmF$"))
                .body("[9].name.firstname" , equalTo("john"))
                .body("[9].name.lastname" , equalTo("doe"));
    }
}
