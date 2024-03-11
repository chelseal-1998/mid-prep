package ryanchelseapartoneapi.tests.users;

import jdk.jfr.Description;
import org.apache.http.HttpStatus;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ryanchelseapartoneapi.common.CommonObjects;
import ryanchelseapartoneapi.tests.UserBase;

import static ryanchelseapartoneapi.common.TestData.*;

public class CreateUser extends UserBase {


    @Description("As a user, I should be able to create a new user.")
    @Test(dataProvider = "user-details", dataProviderClass = CommonObjects.class)
    public void createUserSuccessfully(String firstName, String lastName, String email, String password, String company) {
        createUser(commonObjects.createUserObject(firstName,lastName,email,password,company)).
                then().log().all().
                assertThat().
                statusCode(HttpStatus.SC_CREATED).
                spec(getUserDetailsExpectedResponse(HttpStatus.SC_CREATED));
    }
}