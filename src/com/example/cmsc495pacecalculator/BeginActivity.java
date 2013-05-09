package com.example.cmsc495pacecalculator;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

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
public boolean usingTime = true;
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
	    
 Button button1 = (Button) findViewById(R.id.button1);
	    
 final EditText distOne = (EditText) findViewById(R.id.editText1);
 final EditText timePace = (EditText) findViewById(R.id.editText2);
 final EditText distTwo = (EditText) findViewById(R.id.editText3);
 final EditText resultTime = (EditText) findViewById(R.id.editText4);
 final EditText resultPace = (EditText) findViewById(R.id.editText5);
	    
	    button1.setOnClickListener(new View.OnClickListener() {
	    	
	    	
	        public void onClick(View v) {
	        	String time, pace, knownDistance, unDistance;
	        	knownDistance = distOne.getText().toString(); 
	        	unDistance = distTwo.getText().toString();
	        	if(usingTime){
	        		
	        		time = timePace.getText().toString();
	        		
	        		String[] results = runCalcTime(time, knownDistance, unDistance);
	        		resultTime.setText(results[0]);
	        		resultPace.setText(results[1]);
	        	}
	        	else{
	        		pace = timePace.getText().toString();
	        		
	        		
	        		String[] results = runCalcPace(pace, knownDistance, unDistance);
	        		resultTime.setText(results[0]);
	        		resultPace.setText(results[1]);
	        	}
	        	
	        	
	            
	            
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
	                texts.setText("Pace in min/mile | 'MM:SS'");
	                usingTime = false;
	            }
	            break;
	        case R.id.radioButton1:
	            if (checked){
	            	 TextView text = (TextView) findViewById(R.id.textView2);
                text.setText("Known Time");
                TextView texts = (TextView) findViewById(R.id.textView6);
                texts.setText("Time in 'MM:SS' form");
                usingTime = true;
	            }
	            break;
	    }
	}
static String[] runCalcTime(String time, String knownDistance, String unDistance){
	double seconds = timeToSeconds(time);
	double knownDist = Double.valueOf(knownDistance);
	double unDist = Double.valueOf(unDistance);
	double FinalTime = seconds * Math.pow((unDist / knownDist) ,1.05);
	
	String[] results = new String[2];
	results[0] = finalTimeResults(FinalTime);
			
	results[1] = finalPaceResults(FinalTime, unDist);
	return results;
}

static String[] runCalcPace(String pace, String knownDistance, String unDistance){
	double seconds = paceToSeconds(pace, knownDistance);
	double knownDist = Double.valueOf(knownDistance);
	double unDist = Double.valueOf(unDistance);
	double FinalTime = seconds * Math.pow((unDist / knownDist) ,1.05);
	String[] results = new String[2];
	results[0] = finalTimeResults(FinalTime);
	results[1] = finalPaceResults(FinalTime, unDist);
	return results;
	
}

static double timeToSeconds(String time){
	double seconds = 0;
	Scanner scan = new Scanner(time);
	scan.useDelimiter(":");
	ArrayList<Double> TimeArray = new ArrayList<Double>();
	double hours, minutes, finalSeconds;
	while(scan.hasNext())
		TimeArray.add(Double.valueOf(scan.next()));
	if(TimeArray.size() == 3){
		hours = TimeArray.get(0);
		minutes = TimeArray.get(1);
		seconds = TimeArray.get(2);
		finalSeconds = (hours * 60 * 60) + (minutes * 60) + seconds;
		return finalSeconds;
	}
	if(TimeArray.size() == 2){
		hours = 0;
		minutes = TimeArray.get(0);
		seconds = TimeArray.get(1);
		finalSeconds = (hours * 60 * 60) + (minutes * 60) + seconds;
		return finalSeconds;
	}
	if(TimeArray.size() == 1){
		hours = 0;
		minutes = 0;
		seconds = TimeArray.get(0);
		finalSeconds = (hours * 60 * 60) + (minutes * 60) + seconds;
		return finalSeconds;
	}
	return -1;
}
static double paceToSeconds(String pace, String Distance){
	double seconds = 0;
	double timePerMile = timeToSeconds(pace);
	seconds = timePerMile * Double.valueOf(Distance);
	return seconds;
}

static String finalTimeResults(double currentTime){
	currentTime = currentTime * 1000;
	int seconds = (int) (currentTime / 1000) % 60 ;
	int minutes = (int) ((currentTime / (1000*60)) % 60);
	int hours   = (int) ((currentTime / (1000*60*60)) % 24);
	java.text.DecimalFormat nft = new  
			java.text.DecimalFormat("#00.###");  
			nft.setDecimalSeparatorAlwaysShown(false);  
	String finalString = nft.format(Double.valueOf(hours)) + ":" + nft.format(Double.valueOf(minutes)) + ":" + nft.format(Double.valueOf(seconds));
	return finalString;
}
static String finalPaceResults(double time, double dist){
	double currentTime = time / dist;
	currentTime = currentTime * 1000;
	int seconds = (int) (currentTime / 1000) % 60 ;
	int minutes = (int) ((currentTime / (1000*60)) % 60);
	int hours   = (int) ((currentTime / (1000*60*60)) % 24);
	java.text.DecimalFormat nft = new  
			java.text.DecimalFormat("#00.###");  
			nft.setDecimalSeparatorAlwaysShown(false);  
	String finalString = nft.format(Double.valueOf(hours)) + ":" + nft.format(Double.valueOf(minutes)) + ":" + nft.format(Double.valueOf(seconds));
	return finalString;
}







}
