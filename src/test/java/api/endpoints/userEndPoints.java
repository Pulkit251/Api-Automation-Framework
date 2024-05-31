package api.endpoints;

import api.payloads.User;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class userEndPoints {
    @Test
    public Response createUser(User payload){
        Response response = given()
                .contentType("application/json")
                .accept("application/json")
                .body(payload)
                .when()
                .post(routes.createUser);

        return response;
    }

    @Test
    public Response getUser(String userName){
        Response response = given()
                .pathParam("username",userName)
                .when()
                .get(routes.getUser);

        return response;
    }

    @Test
    public Response updateUser(User Payload, String userName){
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
    public void deleteUser(String userName){
        given()
                .pathParam("username",userName)
                .when()
                .delete(routes.deleteUser);
    }
}
