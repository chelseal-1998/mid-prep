package ryanchelseapartoneapi.tests.accounts;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import ryanchelseapartoneapi.tests.AccountsBase;

public class GetAllAccounts extends AccountsBase {

    @Test
    public void viewAllAccounts(){
        getAllAccounts().
                then().
                assertThat().
                statusCode(HttpStatus.SC_OK);

    }
}