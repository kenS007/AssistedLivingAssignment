package com.ken.assistedliving.components;

public class Restriction { //restriction for the course
	
	String mealType="";
	int slot=0;
	
	

	public void setRestriction(String mealType,int slot){
		setMealType(mealType);
		setSlot(slot);
	}
	
	
	public void setMealType(String mealType){
		this.mealType=mealType;
	}
	
	public String getMealType(){
		return mealType;
	}
	public void setSlot(int slot){
		this.slot=slot;
	}
	public int getSlot(){
		return slot;
	}

	public String toString(){
		return mealType+", "+slot;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
