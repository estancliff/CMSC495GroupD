package com.example.cmsc495pacecalculator;
import java.util.Date;

import com.example.cmsc495pacecalculator.R;
import com.example.cmsc495pacecalculator.R.id;
import com.example.cmsc495pacecalculator.R.layout;
import com.example.cmsc495pacecalculator.R.menu;

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

public class BeginActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_begin);
		
		
		RadioButton rg1 = (RadioButton) findViewById(R.id.radioButton1);
		rg1.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v){
				
				onRadioButtonClicked(v);
		}
		});
		RadioButton rg2 = (RadioButton) findViewById(R.id.radioButton2);
		rg2.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v){
				
				onRadioButtonClicked(v);
		}
		});
		
	   Button button = (Button) findViewById(R.id.button2);
	    
	    
	    
	    button.setOnClickListener(new View.OnClickListener() {
	    	
	    	
	        public void onClick(View v) {
	        	
	        	
	        	Intent myIntent = new Intent(BeginActivity.this, RunActivity.class);
	        	//myIntent.putExtra("key", value); //Optional parameters
	        	BeginActivity.this.startActivity(myIntent);
	            
	            
	            
	        }
	        
	        
	    });
	    
	    
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.begin, menu);
		return true;
	}
	public void onRadioButtonClicked(View view) {
	    // Is the button now checked?
	    boolean checked = ((RadioButton) view).isChecked();
	    
	    // Check which radio button was clicked
	    switch(view.getId()) {
	        case R.id.radioButton2:
	            if (checked){
	                TextView text = (TextView) findViewById(R.id.textView2);
	                text.setText("Known Pace");
	                TextView texts = (TextView) findViewById(R.id.textView6);
	                texts.setText("Pace in MPH");
	            }
	            break;
	        case R.id.radioButton1:
	            if (checked){
	            	 TextView text = (TextView) findViewById(R.id.textView2);
                text.setText("Known Time");
                TextView texts = (TextView) findViewById(R.id.textView6);
                texts.setText("Time in 'MM:SS' form");
	            }
	            break;
	    }
	}

}
