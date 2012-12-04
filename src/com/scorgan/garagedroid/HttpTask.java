package com.scorgan.garagedroid;

import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;

import android.os.AsyncTask;
import android.util.Log;

public class HttpTask extends AsyncTask<String,String,String> {

	@Override
	protected String doInBackground(String... args) {
		HttpClient scorgan = new DefaultHttpClient();
		HttpGet get = new HttpGet(args[0]);

		// You can send a custom string from MainActivity to act on here
		if (args.length <= 2) {
			get.addHeader(new BasicHeader("CUSTOM", "toggle"));
			Log.d("scorgan", "toggle");
		}
		else {
			get.addHeader(new BasicHeader("CUSTOM", "status"));
			Log.d("scorgan", "status");
		}
		
		try {
			HttpResponse response = scorgan.execute(get);
			InputStream value = response.getEntity().getContent();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(value));
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = br.readLine()) != null) { sb.append(line); }
			
			br.close();
			
			return sb.toString();
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
