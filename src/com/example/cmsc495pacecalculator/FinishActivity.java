package com.example.cmsc495pacecalculator;

import java.util.Date;

import com.example.cmsc495pacecalculator.R;
import com.example.cmsc495pacecalculator.R.layout;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class FinishActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_finish);
		
 Button button = (Button) findViewById(R.id.button1);
	    
	    
	    
	    button.setOnClickListener(new View.OnClickListener() {
	    	
	    	
	        public void onClick(View v) {
	        	
	        	
	        
	        	Intent myIntent = new Intent(FinishActivity.this, BeginActivity.class);
	        	//myIntent.putExtra("key", value); //Optional parameters
	        	FinishActivity.this.startActivity(myIntent);
	            
	        }
	        
	        
	    });
		
		
	}
}