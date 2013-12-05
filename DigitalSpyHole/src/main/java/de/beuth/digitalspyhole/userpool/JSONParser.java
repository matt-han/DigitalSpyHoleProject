package de.beuth.digitalspyhole.userpool;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by KingLui on 20.11.13.
 */
public class JSONParser  {

    static InputStream is = null;
    static JSONObject jObj = null;
    static String json = "";

    String mUrl;
    List <NameValuePair> mParams;
    Context mContext;

    public JSONParser(String url, List <NameValuePair> params, Context context) {
        mUrl = url;
        mParams = params;
        mContext = context;
        new innerJSONParser().execute(url);
    }


    public JSONObject getJSONFromUrl(){
        Log.i("JSON3", jObj.toString());
      return jObj;
    }

    public class innerJSONParser extends AsyncTask <String, Void, JSONObject>
    {

        @Override
        protected JSONObject doInBackground(String... params) {

            // Making HTTP request
            try {
                // defaultHttpClient
                DefaultHttpClient httpClient = new DefaultHttpClient();
                HttpPost httpPost = new HttpPost(mUrl);
                httpPost.setEntity(new UrlEncodedFormEntity(mParams));

                publishProgress();

                HttpResponse httpResponse = httpClient.execute(httpPost);
                HttpEntity httpEntity = httpResponse.getEntity();
                is = httpEntity.getContent();

            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
                StringBuilder sb = new StringBuilder();
                String line = null;
                while ((line = reader.readLine()) != null) {
                    sb.append(line + "\n");
                }
                is.close();
                json = sb.toString();

                Log.i("JSON1", json);
            } catch (Exception e) {
                Log.e("Buffer Error", "Error converting result " + e.toString());
            }

            // try parse the string to a JSON object
            try {
                jObj =  new JSONObject(json);
               return jObj;

               /* Iterator keys = jObj.keys();
                Map<String, String> map = new HashMap<String, String>();
                while (keys.hasNext()) {
                    String key = (String) keys.next();
                    map.put(key, jObj.getString(key));
                }
                System.out.println(map);// this map will contain your json stuff*/
            } catch (JSONException e) {
                Log.e("JSON Parser", "Error parsing data " + e.toString());
            }

            // return JSON String
            return null;
        }

        @Override
        protected void onPostExecute(JSONObject jsonObject) {
            super.onPostExecute(jsonObject);
            Log.i("JSON2", jsonObject.toString());
            jObj = jsonObject;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
            try {
                this.wait(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
