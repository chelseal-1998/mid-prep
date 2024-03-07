package ryanchelseapartoneapi.common;

import org.json.simple.JSONObject;

public class CommonObjects {

    public JSONObject createUserObject(String firstName, String lastName, String email, String password, String company) {
        JSONObject userObject = new JSONObject();
        userObject.put("first_name", firstName);
        userObject.put("last_name", lastName);
        userObject.put("email", email);
        userObject.put("password", password);
        userObject.put("company", company);
        return userObject;
    }

    public JSONObject getUserAccessTokenObject(String username, String password){
        JSONObject userObject = new JSONObject();
        userObject.put("username", username);
        userObject.put("password", password);
        return userObject;
    }

    public JSONObject updateUserObject(String company){
        JSONObject updatedDetails = new JSONObject();
        updatedDetails.put("company", company);
        return updatedDetails;
    }
}
