package ryanchelseapartoneapi.tests;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import ryanchelseapartoneapi.BaseTest;

import javax.swing.plaf.PanelUI;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static ryanchelseapartoneapi.common.TestData.*;
import org.apache.commons.text.RandomStringGenerator;

public class UserBase extends BaseTest {

    public Response createUser() {
        return given().
                contentType("application/json").
                body(commonObjects.createUserObject(FIRST_NAME,LAST_NAME,EMAIL,PASSWORD,COMPANY)).
                when().log().all().
                post("/users").
                then().
                extract().
                response();
    }

    public Response getCurrentUserDetail() {
        return given().
                header(new Header("Authorization", "Bearer " + getAccessTokens())).
                contentType("application/json").
                when().log().all().
                get("/me").
                then().
                extract().
                response();
    }

    public Response updateUser(String company) {
        return given().
                header(new Header("Authorization", "Bearer " + getAccessTokens())).
                contentType("application/json").
                when().log().all().
                body(commonObjects.updateUserObject(company)).
                put("/me").
                then().
                extract().
                response();
    }
    public ResponseSpecification getUserDetailsExpectedResponse(){
        ResponseSpecBuilder resBuilder = new ResponseSpecBuilder();
        resBuilder.expectStatusCode(HttpStatus.SC_OK).
                expectBody("first_name", notNullValue()).
                expectBody("last_name", notNullValue()).
                expectBody("email", notNullValue()).
                expectBody("company", notNullValue()).
                expectBody("last_login", notNullValue()).
                expectResponseTime(lessThan(ACCEPTABLE_RESPONSE_TIME));
        return resBuilder.build();
    }
}
