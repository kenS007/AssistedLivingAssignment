package com.ken.assistedliving.components;

import java.util.ArrayList;

public class GuiHelper {
	
	    ArrayList<Meal> mealList=new ArrayList<Meal>();
	private LoadFile load=new LoadFile();
	
	public void loadMeals(){
		mealList=load.loadEverything();
		System.out.println(mealList.toString());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GuiHelper h =new GuiHelper();
		h.loadMeals();
		
	}

}
