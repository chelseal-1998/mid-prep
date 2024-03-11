package ryanchelseapartoneapi.tests.accounts.create;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import ryanchelseapartoneapi.tests.accounts.AccountsBase;

public class CreateANewAccount extends AccountsBase {

    @Test
    public void createNewAccount(){
        createANewAccount().
                then().
                assertThat().
                statusCode(HttpStatus.SC_CREATED).
                spec(getAccountDetailsExpectedResponse());
    }
}
