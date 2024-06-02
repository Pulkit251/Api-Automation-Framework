package api.test;

import api.endpoints.userEndPoints;
import api.payloads.User;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserTests {
    Faker faker;
    User payload;
    userEndPoints ep;
    public Logger logger;

    @BeforeClass
    public void setup(){
        faker = new Faker();
        payload = new User();
        ep = new userEndPoints();

        payload.setId(faker.idNumber().hashCode());
        payload.setEmail(faker.internet().emailAddress());
        payload.setFirstName(faker.name().firstName());
        payload.setLastName(faker.name().lastName());
        payload.setPhone(faker.phoneNumber().cellPhone());
        payload.setUsername(faker.name().username());
        payload.setPassword(faker.internet().password());
//        System.out.println(payload.getId());
        logger = LogManager.getLogger(this.getClass());
    }


    @Test(priority = 1)
    public void createUserTest(){
        logger.info("Posting a user");
        Response response = userEndPoints.createUser(payload);
        String email = response.jsonPath().getString("message");
        System.out.println(email);
        response.then().log().all();
    }

    @Test(priority = 3)
    public void getUserTest(){
        Response response = userEndPoints.getUser(this.payload.getUsername());
        response.then().log().all();
    }

    @Test
    public void updateUserTest(){
        payload.setFirstName(faker.name().firstName());
        payload.setLastName(faker.name().lastName());

        Response response = userEndPoints.updateUser(payload,this.payload.getUsername());

        response.then().log().all();

        System.out.println("---------------------------------------");
        Response res = userEndPoints.getUser(this.payload.getUsername());
        res.then().log().body();
    }

    @Test
    public void deleteUserTest(){
        Response res = userEndPoints.deleteUser(this.payload.getUsername());
        res.then().log().all();
    }
}
