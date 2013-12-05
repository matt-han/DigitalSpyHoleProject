package de.beuth.digitalspyhole.userpool;

import android.content.Context;
import android.util.Log;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KingLui on 20.11.13.
 */
public class UserFunctions {

    private static String loginURL = "http://10.0.2.2/android_api/";
    private static String registerURL = "http://10.0.2.2/android_api/";

    private static String login_tag = "login.xml";
    private static String register_tag = "register";
    Context mContext;
    // constructor
    public UserFunctions(Context context){
        mContext =  context;
    }

    /**
     * function make Login Request
     * @param name
     * @param password
     * */
    public JSONObject loginUser(String name, String password){
        // Building Parameters
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("tag", login_tag));
        params.add(new BasicNameValuePair("name", name));
        params.add(new BasicNameValuePair("password", password));

        JSONParser jsonParser = new JSONParser(loginURL, params,mContext);
        JSONObject json = jsonParser.getJSONFromUrl();

        return json;
    }

    /**
     * function make Login Request
     * @param name
     * @param password
     * */
    public JSONObject registerUser(String name,  String password){
        // Building Parameters

        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("tag", register_tag));
        params.add(new BasicNameValuePair("name", name));
        params.add(new BasicNameValuePair("password", password));

        // getting JSON Object
        JSONParser jsonParser = new JSONParser(registerURL, params,mContext);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        JSONObject json = jsonParser.getJSONFromUrl();
        Log.i("JSON4", json.toString());
        // return json
        return json;
    }

    /**
     * Function get Login status
     * */
    public boolean isUserLoggedIn(Context context){
        DatabaseHandler db = new DatabaseHandler(context);
        int count = db.getRowCount();
        if(count > 0){
            // user logged in
            return true;
        }
        return false;
    }

    /**
     * Function to logout user
     * Reset Database
     * */
    public boolean logoutUser(Context context){
        DatabaseHandler db = new DatabaseHandler(context);
        db.resetTables();
        return true;
    }
}
