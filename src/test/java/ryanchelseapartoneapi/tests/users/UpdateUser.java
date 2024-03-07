package ryanchelseapartoneapi.tests.users;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import ryanchelseapartoneapi.tests.UserBase;

import static org.hamcrest.Matchers.is;
import static ryanchelseapartoneapi.common.TestData.UPDATED_COMPANY_NAME;

public class UpdateUser extends UserBase {

    @Test
    public void updateCurrentUser(){
        updateUser(UPDATED_COMPANY_NAME).
                then().
                assertThat().
                statusCode(HttpStatus.SC_OK).
                body("company", is(UPDATED_COMPANY_NAME));
    }
}