package ryanchelseapartoneapi.utils;

import lombok.Getter;
import lombok.Setter;

import java.util.Properties;

@Getter
@Setter
public class CustomTestData {

    public final String apiUrl;
    public final String authorizedUsername;
    public final String authorizedPassword;



    public CustomTestData(Properties properties){
        apiUrl = properties.getProperty("api.test.url");
        authorizedUsername = properties.getProperty("username");
        authorizedPassword= properties.getProperty("password");
    }
}