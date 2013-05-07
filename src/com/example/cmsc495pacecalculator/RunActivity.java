package com.example.cmsc495pacecalculator;


import java.util.Date;

import com.example.cmsc495pacecalculator.R;
import com.example.cmsc495pacecalculator.R.id;
import com.example.cmsc495pacecalculator.R.layout;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class RunActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_run);
		
 Button button = (Button) findViewById(R.id.button2);
	    
	    
	    
	    button.setOnClickListener(new View.OnClickListener() {
	    	
	    	
	        public void onClick(View v) {
	        	
	        	
	        	Intent myIntent = new Intent(RunActivity.this, FinishActivity.class);
	        	//myIntent.putExtra("key", value); //Optional parameters
	        	RunActivity.this.startActivity(myIntent);
	            
	            
	            
	        }
	        
	        
	    });
	    
		
		
		
	}
	
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.main, menu);
//		return true;
//	}
	
}