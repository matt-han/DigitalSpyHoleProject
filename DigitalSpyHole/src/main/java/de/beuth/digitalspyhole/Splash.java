package de.beuth.digitalspyhole;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import de.beuth.digitalspyhole.registration.Login;

public class Splash extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread logotimer = new Thread(){
            public void run(){
                try{
                    sleep(5000);
                    Intent intent = new Intent(Splash.this,Login.class);
                    //Intent menuIntent = new Intent("de.beuth.digitalspyhole.MENU");
                    startActivity(intent);
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
                finally {
                    finish();
                }
            }
        };

        logotimer.start();

    }


    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_splash, container, false);
            return rootView;
        }
    }

}
