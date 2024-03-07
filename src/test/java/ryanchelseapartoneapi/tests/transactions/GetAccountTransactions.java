package ryanchelseapartoneapi.tests.transactions;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import ryanchelseapartoneapi.tests.AccountsBase;
import ryanchelseapartoneapi.tests.TransactionsBase;

public class GetAccountTransactions extends TransactionsBase {

    @Test
    public void viewAccountTransactions(){
        int id = accountsBase.createANewAccount().
                then().
                assertThat().
                statusCode(HttpStatus.SC_CREATED).
                extract().
                path("id");

       int transactionId = createAccountTransaction(id).
                then().
                assertThat().
                statusCode(HttpStatus.SC_CREATED).extract().path("id");

        getAccountTransactions(id,transactionId).
                then().
                assertThat().
                statusCode(HttpStatus.SC_OK);
    }
}
