package de.beuth.digitalspyhole;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
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
import android.widget.Button;

public class OverView extends Activity implements View.OnClickListener {

    private Button control;
    private Button database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        control = (Button)findViewById(R.id.menu_control);
        database = (Button)findViewById(R.id.menu_database);
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.menu_control:
                startActivity(new Intent(this, Control.class));
                break;
            case R.id.menu_database:
                startActivity(new Intent(this, Database.class));
                break;
            default:
                break;
        }
    }
}
