package ryanchelseapartoneapi.tests.accounts.create;

import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ryanchelseapartoneapi.tests.accounts.AccountsBase;

import static org.hamcrest.CoreMatchers.is;

public class DeleteAccount extends AccountsBase {

    int id;

    @BeforeMethod
    public void create(){
        id = createANewAccount().
                then().
                assertThat().
                statusCode(HttpStatus.SC_CREATED).
                extract().
                path("id");
    }

    @Test
    public void deleteAccount(){
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