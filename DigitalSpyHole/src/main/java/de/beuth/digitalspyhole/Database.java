package de.beuth.digitalspyhole;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;

import org.omg.CORBA.NameValuePair;

import java.lang.InterruptedException;
import java.util.ArrayList;

public class Database extends ListActivity {

    InputStream is;
    ArrayList<String> results = new ArrayList<String>();
    JSONObject json_data;
    Boolean dataComplete = false;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getData();

        while (!this.dataComplete) // es soll solange gewartet werden bis die ArrayList ganz gefüllt ist und die Abfrage beendet wurde
        {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        this.fillList();
    }

    public void getData() {

        Thread t = new Thread() {

            private String result = "";

            public void run() {
                ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();

                try {
                    HttpClient httpclient = new DefaultHttpClient();
                    HttpPost httppost = new HttpPost("http://http://spyhole.no-ip.biz/data.php");
                    httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                    HttpResponse response = httpclient.execute(httppost);
                    HttpEntity entity = response.getEntity();
                    is = entity.getContent();
                } catch (Exception e) {
                    Log.e("log_tag", "Fehler bei der http Verbindung " + e.toString());
                }

                try {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
                    StringBuilder sb = new StringBuilder();
                    String line = null;
                    while ((line = reader.readLine()) != null) {
                        sb.append(line + "n");
                    }
                    is.close();
                    result = sb.toString();
                } catch (Exception e) {
                    Log.e("log_tag", "Error converting result " + e.toString());
                }

                try {
                    JSONArray jArray = new JSONArray(result);
                    for (int i = 0; i < jArray.length(); i++) {
                        json_data = jArray.getJSONObject(i);
                        results.add((String) json_data.get("id") + " " + json_data.get("name"));

                    }

                    dataComplete = true;
                } catch (JSONException e) {
                    Log.e("log_tag", "Error parsing data " + e.toString());
                }
            }


        };

        t.start();

    }


    public void fillList() {
        this.setListAdapter(new ArrayAdapter<String>(this, android.R.layout.activtiy_database, results));
    }

}
