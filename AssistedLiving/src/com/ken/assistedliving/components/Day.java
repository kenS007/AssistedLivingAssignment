package com.ken.assistedliving.components;

import java.util.ArrayList;

public class Day {
	
	private ArrayList<Meal> breakfast;
	private ArrayList<Meal> lunch;
	private ArrayList<Meal> dinner;
	
	public Day(){
		
	}
	
	
	
	
	public ArrayList<Meal> getBreakfastList() {
		return breakfast;
	}

	public void setBreakfast(ArrayList<Meal> breakfast) {
		this.breakfast = breakfast;
	}

	public ArrayList<Meal> getLunchList() {
		return lunch;
	}

	public void setLunch(ArrayList<Meal> lunch) {
		this.lunch = lunch;
	}

	public ArrayList<Meal> getDinnerList() {
		return dinner;
	}

	public void setDinner(ArrayList<Meal> dinner) {
		this.dinner = dinner;
	}

	

	
	

}
