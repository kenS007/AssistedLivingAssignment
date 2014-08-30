package com.ken.assistedliving.components.hashtables;

import java.util.Hashtable;

import com.ken.assistedliving.components.Ingredient;

public class IngredientTable {
	
	Hashtable<Integer, Ingredient> ingredientHT=new Hashtable<Integer,Ingredient>();
	private int keyCount=0;
	
	public void addToHT(Ingredient ingredient){
		keyCount++;
		ingredientHT.put(keyCount,ingredient);
		
	}
	
	public int getID(String ingredientName){
		int id=0;
		//add
		
		
		return id;
	}
	public Ingredient getIngredient(int id){
		
		
		return ingredientHT.get(id);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
