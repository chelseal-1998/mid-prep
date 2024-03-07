package ryanchelseapartoneapi.tests.accounts;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import ryanchelseapartoneapi.tests.AccountsBase;

public class CreateANewAccount extends AccountsBase {

    @Test
    public void createNewAccount(){
        createANewAccount().
                then().log().all().
                assertThat().
                statusCode(HttpStatus.SC_CREATED).
                spec(getAccountDetailsExpectedResponse());
    }
}
