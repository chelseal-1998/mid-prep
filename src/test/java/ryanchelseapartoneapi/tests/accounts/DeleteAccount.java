package ryanchelseapartoneapi.tests.accounts;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import ryanchelseapartoneapi.tests.AccountsBase;

import static org.hamcrest.CoreMatchers.is;

public class DeleteAccount extends AccountsBase {

    @Test
    public void deleteAccount(){
        int id = createANewAccount().
                then().
                assertThat().
                statusCode(HttpStatus.SC_CREATED).
                extract().
                path("id");

        deleteAnAccount(id).
                then().
                assertThat().
                statusCode(HttpStatus.SC_NO_CONTENT);

        getAccountDetails(id).
                then().
                assertThat().
                statusCode(HttpStatus.SC_NOT_FOUND).
                body("detail", is("Account not found"));
    }
}