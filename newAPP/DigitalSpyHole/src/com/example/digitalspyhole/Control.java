package com.example.digitalspyhole;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.webkit.WebSettings;

public class Control extends Activity{
	
	private WebView webView;
//	private ProgressDialog pDialog;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_webview);	
		
		webView = (WebView) findViewById(R.id.webview);
		webView.setWebViewClient(new WebViewClient(){});
		// setup webview
        // javascript allows to play videos
        webView.getSettings().setJavaScriptEnabled(true);
        //webView.setAlwaysDrawnWithCacheEnabled(true);
        webView.setClickable(false);

        // Create a progressbar
     //   pDialog = new ProgressDialog(Control.this);
        // Set progressbar title
     //   pDialog.setTitle(" loading DigitalSpy");
        // Set progressbar message
     //   pDialog.setMessage("Buffering...");
    //    pDialog.setIndeterminate(false);
    //    pDialog.setCancelable(false);
        // Show progressbar
    //    pDialog.show();

        // load and show the website
       // webView.loadUrl("http://spyhole.no-ip.biz:1900/javascript_simple.html");
        webView.loadUrl("http://192.168.1.100:1900/javascript_simple.html");

  //      pDialog.hide();

	}
}
