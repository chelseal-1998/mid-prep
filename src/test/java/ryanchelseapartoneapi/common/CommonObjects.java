package ryanchelseapartoneapi.common;

import lombok.Data;
import org.apache.http.client.utils.DateUtils;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;

import java.time.LocalDateTime;
import java.util.Random;

public class CommonObjects {

    public JSONObject createUserObject(String firstName, String lastName, String email, String password, String company) {
        JSONObject userObject = new JSONObject();
        userObject.put("first_name", firstName);
        userObject.put("last_name", lastName);
        userObject.put("email", email);
        userObject.put("password", password);
        userObject.put("company", company);
        return userObject;
    }

    public JSONObject updateUserObject(String company) {
        JSONObject updatedDetails = new JSONObject();
        updatedDetails.put("company", company);
        return updatedDetails;
    }

    @DataProvider(name = "user-details")
    public Object [][] userDetailsData(){
        String email = "emai@mail.com";
        return new Object[][]{
                {"first_name", "last_name" , email, "password" , "company"},
        };
    }
}
