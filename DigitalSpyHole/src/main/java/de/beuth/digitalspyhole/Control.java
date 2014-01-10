package de.beuth.digitalspyhole;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.net.Uri;
import android.webkit.WebSettings;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.VideoView;
import android.webkit.WebView;


public class Control extends Activity implements View.OnClickListener {


    private Button open;
    private ProgressDialog pDialog;

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //refer to the id's
        open = (Button)findViewById(R.id.open_door);
        //videoView = (VideoView)findViewById(R.id.videoView1);
        webView = (WebView) findViewById(R.id.webview);

        //connect to the listener
        open.setOnClickListener(this);

        // setup webview
        // javascript allows to play videos
        webView.getSettings().setJavaScriptEnabled(true);
        //webView.setAlwaysDrawnWithCacheEnabled(true);
        webView.setClickable(false);

        // Create a progressbar
        pDialog = new ProgressDialog(Control.this);
        // Set progressbar title
        pDialog.setTitle(" loading DigitalSpy");
        // Set progressbar message
        pDialog.setMessage("Buffering...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        // Show progressbar
        pDialog.show();

        // load and show the website
        //webView.loadUrl("http://rack.2.mshcdn.com/media/ZgkyMDEyLzEwLzE5LzExXzMzXzMzXzI5X2ZpbGUKcAl0aHVtYgkxMjAweDk2MDA-/b214a804");
        webView.loadUrl("http://192.168.1.100:1900/javascript_simple.html");

        pDialog.hide();

    }

    @Override
    public void onClick(View v) {
        /**
         * target:  send a intent to a special class and get an ack when the connection is finished.
         * result:  when the connection is finished the videoView shows the stream of the web server.
         */
        switch(v.getId()){
            case R.id.open_door:
                startActivity(new Intent(this, OpenDoor.class));
                break;
            default:
                break;
        }

    }

}
