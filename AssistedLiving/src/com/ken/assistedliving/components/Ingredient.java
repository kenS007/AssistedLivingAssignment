package com.ken.assistedliving.components;

public class Ingredient {
	/**
	 * name of ingredient
	 */
	String name;
	/**
	 * cost of ingredient
	 */
	double cost;
	/**
	 * number of units
	 */
	double numOfUnits;
	
	private int id;
	
	
	public Ingredient(){
		
	}
	public Ingredient(String name,double cost){
		this.name=name;
		this.cost=cost;
	}
	
	public void setName(String name){
		this.name =name;
	}
	
	public String getName(){
		return name;
	}
	
	public void setCost(double cost){
		this.cost=cost;
	}
	public double getCost(){
		return cost;
	}
	
	public String toString(){
		return name+", "+cost;
	}
	
	public void addNumUnitBy(double num){
		numOfUnits=numOfUnits+num;
	}
	public double getUnits(){
		return numOfUnits;
	}


	
	
	

}
