package com.example.cmsc495pacecalculator;

import android.app.Activity;

public class TimeKeeper implements Runnable {
public static TimerClass timer = new TimerClass();
public static boolean kill = false;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
    	kill = false;
    	timer = new TimerClass();
    	Thread sleepThread = new Thread();
    	while(true){
       RunActivity.TimerText.post(new Runnable() {
    	   
    	   public void run(){
    		   	RunActivity.TimerText.setText(timer.getCurrentTimeStringDisplay());
    	   }
       });
       try {
		sleepThread.sleep(40);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       if (kill) break;
    	}
    	RunActivity.continues = true;
	}

}
