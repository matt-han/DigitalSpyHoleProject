package com.example.digitalspyhole;

import java.sql.Connection;
import java.sql.SQLException;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Register extends Activity {
	private EditText username=null;
	private EditText vorname=null;
	private EditText nachname=null;
	private EditText email=null;
	private EditText password=null;
	private EditText password2=null;
	
	private Button save=null;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_register);	
		
		save = (Button)findViewById(R.id.speichern_button);
		
		username = (EditText)findViewById(R.id.username);
		vorname = (EditText)findViewById(R.id.vorname);
		nachname = (EditText)findViewById(R.id.nachname);
		email = (EditText)findViewById(R.id.email);
		password = (EditText)findViewById(R.id.passwort_reg);
		password2 = (EditText)findViewById(R.id.passwort_reg2);
		
		Connection conn = null;
		try{
			conn = DBConnector.connect(); 
		} catch(SQLException e2){
			e2.printStackTrace();
		}
		String sql = null;
		try{
			/*
			sql = "INSERT INTO 'db_spyhole'.'tb_user' ('ID', 'name', 'firstname', 'email', 'user', 'password', 'activated') "
					+ "VALUES (NULL, "+username.getText()+", "+vorname.getText()+","+nachname.getText()+","+email.getText()+","+password.getText()+","+password2.getText()+",NULL)";
			*/
			sql = "INSERT INTO 'db_spyhole'.tb_user ('ID', 'name', 'firstname', 'email', 'user', 'password', 'activated')"
					+ "VALUES (null,'"
					+ username.getText() + "', '"
					+ vorname.getText() + "', '"
					+ nachname.getText() + "', '"
					+ email.getText() + "', '"
					+ password.getText() + "', '"
					+ password2.getText() + "', '"
					+ "'null)"; 
		} catch (Exception e)
		{
			e.printStackTrace();
			System.out.println("Error on Building Data");
			System.out.println("Error");
		}
	}

}
