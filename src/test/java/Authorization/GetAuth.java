package Authorization;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;


public class GetAuth extends postAuth {
String tt = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOjEsImlhdCI6MTcxNjg0NDQ1NCwiZXhwIjoxNzE4NTcyNDU0fQ.xMVpDpCbpNwsgd0Bywpy95JQQQ9EJCouJs-GQyapTAg";

    @Test
    public void reciveAuth(){
        given()
                .baseUri("https://api.escuelajs.co")
                //.auth().oauth2("Bearer " + token)
                .header("Authorization", "Bearer " + tt)
        .when()
                .get("/api/v1/auth/profile")
        .then()
                .assertThat()
                .body("id" , equalTo(1))
                .body("name" , equalTo("Jhon"))
                .body("role" , equalTo("customer"))
                .body("creationAt" , startsWith("2024"))
                .body("updatedAt" , startsWith("2024"))
                .log().status();
    }
    /*
    @Test
    public void SecondreciveAuth(){
        given()
                .baseUri("https://api.escuelajs.co")
                //.auth().oauth2("Bearer " + token)
                .header("Authorization", "Bearer " + tokken)
                .when()
                .get("/api/v1/auth/profile")
                .then().log().status();
        System.out.println(token);
        System.out.println(tokken);
    }
    */
}
