package ryanchelseapartoneapi.tests.accounts.create;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import ryanchelseapartoneapi.tests.accounts.AccountsBase;

public class GetAllAccounts extends AccountsBase {

    @Test
    public void viewAllAccounts(){
        getAllAccounts().
                then().
                assertThat().
                statusCode(HttpStatus.SC_OK);

    }
}