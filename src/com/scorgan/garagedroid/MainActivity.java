package com.scorgan.garagedroid;

import java.util.concurrent.ExecutionException;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.app.Activity;
import android.view.Menu;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
    
    protected Button door;
    protected Button status;
    protected TextView responseText;
    protected String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        url = getString(R.string.address) + ":" + getString(R.string.port);
        
        Log.d("scorgan", url);
        
        door = (Button) findViewById(R.id.scorganDOOR);
        status = (Button) findViewById(R.id.scorganSTATUS);
        responseText = (TextView) findViewById(R.id.response);
        
        door.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v) {
                action();
            }
        });
        status.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v) {
                action("status");
            }
        });
    }
    
    private void action(String... values) {
    	String resp = "Error";
    	
    	try {
    		resp = (values.length >= 1)
    			  ? new HttpTask().execute(url, values[0]).get()
    			  : new HttpTask().execute(url).get();
        } catch (ExecutionException e) {
            Log.e("scorgan", e.toString());
        } catch (InterruptedException e) {
            Log.e("scorgan", e.toString());
        }
    	responseText.setText(resp);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
