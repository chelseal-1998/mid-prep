package ryanchelseapartoneapi.tests.users;

import jdk.jfr.Description;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import ryanchelseapartoneapi.tests.UserBase;

import static ryanchelseapartoneapi.common.TestData.*;

public class CreateUser extends UserBase {


    @Description("As a user, I should be able to create a new user.")
    @Test
    public void createUserSuccessfully() {
        createUser().
                then().log().all().
                assertThat().
                statusCode(HttpStatus.SC_CREATED).
                spec(getUserDetailsExpectedResponse());
    }
}