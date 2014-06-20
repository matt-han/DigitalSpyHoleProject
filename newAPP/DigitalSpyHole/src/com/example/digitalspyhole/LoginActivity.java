package com.example.digitalspyhole;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends Activity {
	private EditText  username=null;
	private EditText  password=null;
	private Button login=null;
	private Button register=null;
	private ProgressDialog dialog =null;
	
	private AlertDialog.Builder alertbox = null;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_login);
        
        username = (EditText)findViewById(R.id.benutzername);
        password = (EditText)findViewById(R.id.passwort);       
        login = (Button)findViewById(R.id.login_button); 
        register = (Button)findViewById(R.id.register_button);
        
        alertbox = new AlertDialog.Builder(this);
		// prepare the dialog box
        dialog = new ProgressDialog(this);	 
        
        login.setOnClickListener(new View.OnClickListener() 
        {	
    		@Override
    		public void onClick(View v) {
    			if(username.getText().toString().equals("admin") && password.getText().toString().equals("password")){
            
    	            // make the progress bar cancelable
    	            dialog.setCancelable(true);         
    	            // set a message text
    	            dialog.setMessage("Loading..."); 	             
    	            // show it
    	            dialog.show();
    				Intent in = new Intent(LoginActivity.this,Control.class);
    				startActivity(in);
    			}
    			else{
    				alertbox.setMessage("This is the alertbox!");
    				username.setText("");
    				password.setText("");
    			}
    				
    		}
    	});
        
        register.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent in = new Intent(LoginActivity.this,Register.class);
				startActivity(in);			
			}
		});
        
    }
	
}