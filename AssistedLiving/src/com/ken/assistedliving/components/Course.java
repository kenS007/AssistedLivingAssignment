package com.ken.assistedliving.components;
import java.util.ArrayList;


public class Course {
	
	
	ArrayList<Ingredient> ingredientList=new ArrayList<Ingredient>();
	
	private String name;
	
	
	private Double Coursecost;
	
	//private String[] MealType;
	
	private int id;
	
	ArrayList<Restriction> restrictions=new ArrayList<Restriction>();
	
	
	
	private void setCourseCost(){
		
	}
	
	
	public void addRestriction(String mealType,int slot){
		Restriction res=new Restriction();
		
		//add stuff for error checking
		
		res.setRestriction(mealType, slot);
		restrictions.add(res);
	}
	
	public ArrayList<Restriction> getRestrictions(){
		return restrictions;
	}
	
	
	public void setName(String name){
		this.name=name;
		 
		
	}
	public String getName(){
		return name;
	}
	
	public double getTotalCost(){
		double total=0;
		
		for(Ingredient ingredient:ingredientList){
			total=total+ingredient.getCost();
		}
		
		//System.out.println(name+" "+"Total Course: "+total);
		
		return total;
	}
	
	public Boolean ingredientExists(String ingredient){
		for(Ingredient ing :ingredientList){
			if(ing.getName().equals(ingredient)){//the ingredient is alredy in the list
					return true;
				}
			
		}
		
		return false;
			
	}
	public int getCourseIngredientIndex(String ingName){
		for(int i=0;i<ingredientList.size();i++){
			if(ingredientList.get(i).name.equals(ingName)){
				return i;
			}
		}
		
		
		
		return -1;
	}
	
	
	public void addIngredient(Ingredient in){
		this.ingredientList.add(in);
	}
	public void addIngredient(Ingredient ing,double numUnit){
		Ingredient in=ing;
		in.addNumUnitBy(numUnit);
		this.ingredientList.add(in);
	}
	
	public String toString(){
		return name+" "+ingredientList+" "+restrictions;
	}
	
	public ArrayList<Ingredient> getIngredientlist(){
		return ingredientList;
	}
	
	
	
	
	
	
	


}
