package com.example.digitalspyhole;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import android.app.Activity;
import android.os.Bundle;

public class SocketClient extends Activity{
	
	Socket client;
	PrintWriter out=null;
	BufferedReader in=null;
	
	public void onCreate(Bundle savedInstanceState) {
		try{
			client = new Socket("http://spyhole.no-ip.biz:1900", 4321);
			out = new PrintWriter(client.getOutputStream(),true);
			in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			
		} catch(UnknownHostException e) {
			System.out.println("Unknown host: http://spyhole.no-ip.biz:1900");

		} catch(IOException e1) {
			System.out.println("No I/O");
		}
	}

}
