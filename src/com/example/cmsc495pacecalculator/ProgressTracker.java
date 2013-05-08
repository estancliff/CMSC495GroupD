package com.example.cmsc495pacecalculator;

import java.util.HashMap;

public class ProgressTracker {

private HashMap<Integer, Long> lapsComplete; 
	public ProgressTracker(){
		lapsComplete = new HashMap<Integer, Long>();
	}
	public void addNewLap(long time){
		lapsComplete.put(lapsComplete.size()+ 1, time);
	}
	public String getStats(){
		String stats= "";
		
		for(int x = 0; x < lapsComplete.size(); x++){
			stats = stats + "Lap #" + (x + 1) + ":  ";
			String finalString;
			long currentTime = lapsComplete.get(x+1);
			//String tempString = String.valueOf(Double.valueOf(currentTime));
			//System.out.println(tempString);
			int seconds = (int) (currentTime / 1000) % 60 ;
			int minutes = (int) ((currentTime / (1000*60)) % 60);
			int hours   = (int) ((currentTime / (1000*60*60)) % 24);
			java.text.DecimalFormat nft = new  
					java.text.DecimalFormat("#00.###");  
					nft.setDecimalSeparatorAlwaysShown(false);  
			finalString = nft.format(Double.valueOf(hours)) + ":" + nft.format(Double.valueOf(minutes)) + ":" + nft.format(Double.valueOf(seconds));
			stats = stats + finalString + "\n";
			
			
		}
		return stats;
	}
	public int getLapsRan(){
		return lapsComplete.size();
	}
	public long getLastTime(){
		return lapsComplete.get(lapsComplete.size());
	}
}
