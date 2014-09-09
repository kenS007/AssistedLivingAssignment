package com.ken.assistedliving.components;

import java.util.ArrayList;

public class Week {
	private ArrayList<Day> day=new ArrayList<Day>();
	
	public void addDay(Day day){
		this.day.add(day);
	}
	public ArrayList<Day> getDays(){
		return this.day;
	}
	
	public Day getDay(int dayIndex){
		
		return this.day.get(dayIndex);
	}
	
	private void setTotalCost(){
		
	}
	
	
	
	
	

}
