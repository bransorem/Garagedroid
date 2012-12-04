package com.scorgan.garagedroid;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.app.Activity;
import android.view.Menu;
import android.widget.Button;

public class MainActivity extends Activity {
	
	protected Button led;
	protected Button status;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		final String url = "http://www.example.com:PORT";
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		led = (Button) findViewById(R.id.scorganLED);
		status = (Button) findViewById(R.id.scorganSTATUS);
        led.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				new HttpTask().execute(url);
			}
        });
        status.setOnClickListener(new OnClickListener(){
        	
        	@Override
        	public void onClick(View v) {
        		new HttpTask().execute(url, "status");
        	}
        });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
}
