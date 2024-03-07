package ryanchelseapartoneapi.tests.users;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import ryanchelseapartoneapi.tests.UserBase;

public class GetUser extends UserBase {

    @Test
    public void getCurrentUser(){
        getCurrentUserDetail().
                then().
                assertThat().
                statusCode(HttpStatus.SC_OK).
                spec(getUserDetailsExpectedResponse());
    }
}