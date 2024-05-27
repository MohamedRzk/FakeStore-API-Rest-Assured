package Authorization;

import static io.restassured.RestAssured.*;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.*;
public class postAuth {
    public static String token;
    public static String tokken;
    File login = new File("src/test/data/loginToken.json");
    @Test
    public void AddAuth(){
        Response res = given()
                .baseUri("https://api.escuelajs.co/api/v1")
                .body(login)
                .header("Content-Type" , "application/json")
        .when()
                .post("/auth/login")
        .then()
                .extract().response();

        token = JsonPath.from(res.asString()).getString("access_token");
        System.out.println(token);
    }
    @Test
    public void SecondWayAddAuth(){
         tokken = given()
                .baseUri("https://api.escuelajs.co/api/v1")
                .body(login)
                .header("Content-Type" , "application/json")
                .when()
                .post("/auth/login")
                .then()
                .extract().path("access_token").toString();
        System.out.println(tokken);
    }
}
