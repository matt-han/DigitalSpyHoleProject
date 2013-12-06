package de.beuth.digitalspyhole;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import de.beuth.digitalspyhole.userpool.*;
import de.beuth.digitalspyhole.registration.*;
public class OverView extends Activity implements View.OnClickListener {

    Button control;
    Button database;
    UserFunctions userFunctions;
    Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        control = (Button)findViewById(R.id.menu_control);
        database = (Button)findViewById(R.id.menu_database);
        btnLogout = (Button) findViewById(R.id.btnLogout);

        // Check login status in database
        userFunctions = new UserFunctions(getApplicationContext());
        if(userFunctions.isUserLoggedIn(getApplicationContext())){
            // user already logged in show databoard
            setContentView(R.layout.activity_menu);

            btnLogout.setOnClickListener(this);
            control.setOnClickListener(this);
            database.setOnClickListener(this);

        }else{
            // user is not logged in show login screen
            Intent login = new Intent(getApplicationContext(), Login.class);
            login.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(login);
            // Closing dashboard screen
            finish();
        }

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.menu_control:
                startActivity(new Intent(getApplicationContext(), Control.class));
                break;
            case R.id.menu_database:
                startActivity(new Intent(getApplicationContext(), Database.class));
                break;
            case R.id.btnLogout:
                userFunctions.logoutUser(getApplicationContext());
                Intent login = new Intent(getApplicationContext(), Login.class);
                login.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(login);
                // Closing dashboard screen
                finish();
            default:
                break;
        }
    }
}
