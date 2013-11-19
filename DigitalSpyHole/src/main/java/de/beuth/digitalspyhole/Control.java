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
import android.widget.Button;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.VideoView;

public class Control extends Activity implements View.OnClickListener {


    private Button open;
    private ProgressDialog pDialog;
    private VideoView videoView;

    //URL to motion server
    private String videoUrl = "http://192.168.1.23:8081/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //refer to the id's
        open = (Button)findViewById(R.id.open_door);
        videoView = (VideoView)findViewById(R.id.videoView1);

        //connect to the listener
        open.setOnClickListener(this);

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

        try {
            // Start the MediaController
            MediaController mediacontroller = new MediaController(
                    Control.this);
            mediacontroller.setAnchorView(videoView);
            // Get the URL from String VideoURL
            Uri video = Uri.parse(videoUrl);
            videoView.setMediaController(mediacontroller);
            videoView.setVideoURI(video);

        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }

        videoView.requestFocus();
        videoView.setOnPreparedListener(new OnPreparedListener() {
            // Close the progress bar and play the video
            public void onPrepared(MediaPlayer mp) {
                pDialog.dismiss();
                videoView.start();
            }
        });
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
