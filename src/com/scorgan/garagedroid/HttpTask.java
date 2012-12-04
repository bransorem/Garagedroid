package com.scorgan.garagedroid;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;

import android.os.AsyncTask;
import android.util.Log;

public class HttpTask extends AsyncTask<String,String,String> {

	private static boolean toggled = false;

	@Override
	protected String doInBackground(String... args) {
		// TODO Auto-generated method stub
		HttpClient scorgan = new DefaultHttpClient();
    	
		HttpGet get = new HttpGet(args[0]);

		if (args.length == 1) {
			if (!toggled) {
				toggled = true;
				get.addHeader(new BasicHeader("CUSTOM", "on"));
				
				Log.d("scorgan", "on");
			}
			else {
				toggled = false;
				get.addHeader(new BasicHeader("CUSTOM", "off"));
	
				Log.d("scorgan", "off");
			}
		}
		else {
			get.addHeader(new BasicHeader("CUSTOM", "status"));
			Log.d("scorgan", "status");
		}
		
		try {
			HttpResponse response = scorgan.execute(get);
			// TODO: show response to user
		}
		catch (Exception err) {
			Log.e("scorgan", err.toString());
		}
		return null;
	}
	
	@Override
	protected void onPostExecute(String resp){
		super.onPostExecute(resp);
	}

}
