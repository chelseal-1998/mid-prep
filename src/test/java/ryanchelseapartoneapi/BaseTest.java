package ryanchelseapartoneapi;

import io.restassured.RestAssured;
import ryanchelseapartoneapi.tests.UserBase;
import ryanchelseapartoneapi.utils.CustomTestData;
import org.testng.annotations.BeforeMethod;
import ryanchelseapartoneapi.common.CommonObjects;
import ryanchelseapartoneapi.tests.AccountsBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public abstract class BaseTest {

    public static final String PROPERTIES_FILE = "rocket.properties";
    public static CommonObjects commonObjects;
    private final Properties properties = new Properties();
    public static CustomTestData customTestData;
    public static AccountsBase accountsBase;
    public static UserBase userBase;

    @BeforeMethod(alwaysRun = true)
    public void setUpApi() throws IOException {
        setUpTestDataFileSimilarToAProperties();
        customTestData = new CustomTestData(getProperties());
        setUpEnvironment();
        commonObjects = new CommonObjects();
        accountsBase = new AccountsBase();
        userBase = new UserBase();
    }

    public void setUpEnvironment() {
        RestAssured.baseURI = customTestData.getApiUrl();
        RestAssured.basePath = "/";
    }

    public void setUpTestDataFileSimilarToAProperties() {
        try {
            File file = new File(Paths.get(PROPERTIES_FILE).toAbsolutePath().toString());
            FileInputStream fir = new FileInputStream(file);
            properties.load(fir);
            fir.close();
        } catch (Exception e) {
            System.out.println(e + "Unable to read file");
        }
    }

    public Properties getProperties() {
        return properties;
    }

    public String getAccessTokens() {
        return given().
                contentType("application/x-www-form-urlencoded").
                when().
                body("username=" + customTestData.getAuthorizedUsername() + "&password=" + customTestData.getAuthorizedPassword()).
                post("/token").
                then().
                extract().
                jsonPath().
                get("access_token");
    }
}