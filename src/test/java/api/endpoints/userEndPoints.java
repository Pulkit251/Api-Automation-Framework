package api.endpoints;

import api.payloads.User;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class userEndPoints {
    @Test
    public static Response createUser(User payload){
        Response response = given()
                .contentType("application/json")
                .accept("application/json")
                .body(payload)
                .when()
                .post(routes.createUser);

        return response;
    }

    @Test
    public static Response getUser(String userName){
        Response response = given()
                .pathParam("username",userName)
                .when()
                .get(routes.getUser);

        return response;
    }

    @Test
    public static Response updateUser(User Payload, String userName){
        Response response = given()
                .contentType("application/json")
                .accept("application/json")
                .body(Payload)
                .pathParam("username",userName)
                .when()
                .put(routes.updateUser);

        return response;
    }

    @Test
    public static Response deleteUser(String userName){
        Response res = given()
                .pathParam("username",userName)
                .when()
                .delete(routes.deleteUser);

        return res;
    }
}
