package ryanchelseapartoneapi.tests.accounts;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;
import org.json.simple.JSONObject;
import ryanchelseapartoneapi.BaseTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.notNullValue;
import static ryanchelseapartoneapi.common.TestData.ACCEPTABLE_RESPONSE_TIME;

public class AccountsBase extends BaseTest {

    public Response getAllAccounts(){
        return given().
                header(new Header("Authorization", "Bearer " + getAccessTokens())).
                contentType("application/json").
                when().
                get("/accounts").
                then().
                extract().
                response();
    }

    public Response createANewAccount(){
        return given().
                header("Authorization", "Bearer " + getAccessTokens()).
                contentType("application/json").
                when().log().all().
                body(createNewAccountDetailsObject("accountName")).
                post("/accounts").
                then().
                extract().
                response();
    }

    public JSONObject createNewAccountDetailsObject(String accountName){
        JSONObject updatedDetails = new JSONObject();
        updatedDetails.put("account_name", accountName);
        updatedDetails.put("balance", 1000);
        return updatedDetails;
    }

    public ResponseSpecification getAccountDetailsExpectedResponse(){
        ResponseSpecBuilder resBuilder = new ResponseSpecBuilder().
                expectBody("id", notNullValue()).
                expectBody("account_name", notNullValue()).
                expectBody("balance", notNullValue()).
                expectBody("currency", notNullValue()).
                expectBody("iban", notNullValue()).
                expectBody("created_at", notNullValue()).
                expectBody("last_activity", notNullValue()).
                expectResponseTime(lessThan(ACCEPTABLE_RESPONSE_TIME));
        return resBuilder.build();
    }

    public Response getAccountDetails(int id){
        return given().
                header(new Header("Authorization", "Bearer " + getAccessTokens())).
                contentType("application/json").
                when().log().all().
                get("/accounts/" + id).
                then().
                extract().
                response();
    }

    public Response deleteAnAccount(int id){
        return given().
                header(new Header("Authorization", "Bearer " + getAccessTokens())).
                contentType("application/json").
                when().log().all().
                delete("/accounts/" + id).
                then().
                extract().
                response();
    }
}
