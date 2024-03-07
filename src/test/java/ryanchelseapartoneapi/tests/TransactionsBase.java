package ryanchelseapartoneapi.tests;

import io.restassured.http.Header;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import ryanchelseapartoneapi.BaseTest;

import static io.restassured.RestAssured.given;

public class TransactionsBase extends BaseTest {

    public Response getAccountTransactions(int id, int transactionId) {
        return given().
                header(new Header("Authorization", "Bearer " + getAccessTokens())).
                contentType("application/json").
                when().log().all().
                get("/accounts/" + id + "/transactions/" + transactionId).
                then().
                extract().
                response();
    }

    public Response createAccountTransaction(int id) {
        return given().
                header("Authorization", "Bearer " + getAccessTokens()).
                contentType("application/json").
                when().log().all().
                body(createAccountTransactionDetails()).
                post("/accounts/" + id + "/transactions").
                then().
                extract().
                response();
    }

    public JSONObject createAccountTransactionDetails() {
        JSONObject updatedDetails = new JSONObject();
        updatedDetails.put("amount", 100);
        updatedDetails.put("note", "Salary");
        updatedDetails.put("counterparty_iban", "NL91ABNA0417164300");
        updatedDetails.put("counterparty_name", "Susan White");
        return updatedDetails;
    }
}
