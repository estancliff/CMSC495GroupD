package com.example.cmsc495pacecalculator;

public class TimerClass {
	
	private long startTime;
	public static double finalTime;

	public TimerClass(){
		startTime = System.currentTimeMillis();
		finalTime = 0;
	}
	public String getCurrentTimeStringDisplay(){
		String finalString = "";
		long currentTime = System.currentTimeMillis() - startTime;
		finalTime = currentTime / 1000;
		String tempString = String.valueOf(Double.valueOf(currentTime));
		System.out.println(tempString);
		int seconds = (int) (currentTime / 1000) % 60 ;
		int minutes = (int) ((currentTime / (1000*60)) % 60);
		int hours   = (int) ((currentTime / (1000*60*60)) % 24);
		java.text.DecimalFormat nft = new  
				java.text.DecimalFormat("#00.###");  
				nft.setDecimalSeparatorAlwaysShown(false);  
		finalString = nft.format(Double.valueOf(hours)) + ":" + nft.format(Double.valueOf(minutes)) + ":" + nft.format(Double.valueOf(seconds));
		return finalString;
		
	}
	 
	public long getCurrentTime(){
		return (long) (System.currentTimeMillis() - startTime);
	}
	
}
