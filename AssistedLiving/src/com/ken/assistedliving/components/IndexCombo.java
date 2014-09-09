package com.ken.assistedliving.components;
import java.lang.Object;
//import java.util.Objects;
public class IndexCombo { //this class is used to record the index of the course from the course arraylist in GuiHelper

	int slot1=0;
	int slot2=0;
	int slot3=0;
	//String type;
	
	public void setBreakfastIndex(int slot1,int slot2){
		this.slot1=slot1;
		this.slot2=slot2;
	//	this.type="Breakfast";
	}
	public void setLunchIndex(int slot1,int slot2,int slot3){
		this.slot1=slot1;
		this.slot2=slot2;
		this.slot3=slot3;
		//this.type="lunch";
		
	}
	public void setDinnerIndex(int slot1,int slot2,int slot3){
		this.slot1=slot1;
		this.slot2=slot2;
		this.slot3=slot3;
	//	this.type="dinner";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + slot1;
		result = prime * result + slot2;
		result = prime * result + slot3;
		return result;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IndexCombo other = (IndexCombo) obj;
		if (slot1 != other.slot1)
			return false;
		if (slot2 != other.slot2)
			return false;
		if (slot3 != other.slot3)
			return false;
		return true;
	}
	
	
	
	
}
