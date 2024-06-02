package api.test;

import api.endpoints.userEndPoints;
import api.payloads.User;
import api.utilities.DataProvider;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DataDrivenTests {
    @Test(priority = 1, dataProvider = "Data",dataProviderClass = DataProvider.class)
    public void postTestUsers(String userName,String fname,String lname,String email,String pw,String ph){
        User payload = new User();
        Faker faker = new Faker();

        payload.setId(faker.idNumber().hashCode());
        payload.setUsername(userName);
        payload.setFirstName(fname);
        payload.setEmail(lname);
        payload.setEmail(email);
        payload.setPassword(pw);
        payload.setPhone(ph);

        Response res = userEndPoints.createUser(payload);
        Assert.assertEquals(res.getStatusCode(),200);
    }

//    @Test()
//    public void deleteUsers(String username){
//
//    }
}
