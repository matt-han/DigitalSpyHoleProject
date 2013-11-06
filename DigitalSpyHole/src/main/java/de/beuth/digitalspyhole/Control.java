package de.beuth.digitalspyhole;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.VideoView;

public class Control extends Activity implements View.OnClickListener {

    private Button connect;
    private Button open;
    private ProgressBar status;
    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        connect = (Button)findViewById(R.id.connect_door);
        open = (Button)findViewById(R.id.open_door);
        status = (ProgressBar)findViewById(R.id.status);
        videoView = (VideoView)findViewById(R.id.videoView1);

        connect.setOnClickListener(this);
        open.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        /**
         * target:  send a intent to a special class and get an ack when the connection is finished.
         * result:  when the connection is finished the videoView shows the stream of the web server.
         */
        switch(v.getId()){
            case R.id.connect_door:
                startActivity(new Intent(this, Webserver.class));
                break;
            case R.id.open_door:
                startActivity(new Intent(this, OpenDoor.class));
                break;
            default:
                break;
        }

    }

}
