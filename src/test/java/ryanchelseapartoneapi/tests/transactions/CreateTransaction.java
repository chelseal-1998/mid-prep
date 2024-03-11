package ryanchelseapartoneapi.tests.transactions;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import ryanchelseapartoneapi.tests.TransactionsBase;

public class CreateTransaction extends TransactionsBase {

    @Test()
    public void createTransaction(){
        int id = accountsBase.createANewAccount().
                then().
                assertThat().
                statusCode(HttpStatus.SC_CREATED).
                extract().
                path("id");

        createAccountTransaction(id).
                then().
                assertThat().
                statusCode(HttpStatus.SC_CREATED);
    }

}
