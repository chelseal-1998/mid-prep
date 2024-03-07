package ryanchelseapartoneapi.tests.accounts;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import ryanchelseapartoneapi.tests.AccountsBase;

public class GetAccountDetails extends AccountsBase {

    @Test
    public void viewAccountDetails(){
        int id = createANewAccount().
                then().
                assertThat().
                statusCode(HttpStatus.SC_CREATED).
                extract().
                path("id");

        getAccountDetails(id).
                then().
                assertThat().
                statusCode(HttpStatus.SC_OK).
                spec(getAccountDetailsExpectedResponse());
    }
}