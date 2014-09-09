package com.ken.assistedliving.components;

import java.util.ArrayList;

public class Day {
	
	private ArrayList<Course> breakfast=new ArrayList<Course>();
	private ArrayList<Course> lunch=new ArrayList<Course>();
	private ArrayList<Course> dinner=new ArrayList<Course>();
	
	private double totalcost;
	
	public Day(){
		
	}
	
	public double getTotalCost(){
		double  total=0;
		for(Course c:breakfast){
			total=total+c.getTotalCost();
		}
		for(Course c:lunch){
			total=total+c.getTotalCost();
		}
		for(Course c:dinner){
			total=total+c.getTotalCost();
		}
		return total;
	}
	
	
	public ArrayList<Course> getBreakfastList() {
		return breakfast;
	}

	public void setBreakfast(ArrayList<Course> breakfast) {
		this.breakfast = breakfast;
	}
	public void addBreakfast(Course course){
		breakfast.add(course);
	}

	public ArrayList<Course> getLunchList() {
		return lunch;
	}

	public void setLunch(ArrayList<Course> lunch) {
		this.lunch = lunch;
	}
	public void addLunch(Course course){
		lunch.add(course);
	}

	public ArrayList<Course> getDinnerList() {
		return dinner;
	}

	public void setDinner(ArrayList<Course> dinner) {
		this.dinner = dinner;
	}
	public void addDinner(Course course){
		dinner.add(course);
	}

	

	
	

}
