package com.ken.assistedliving.components;





public class Meal {
	
	String mealType;

	public Course course;
	
	int order;
	
	
	
	public void setMealType(String mealType){
		this.mealType=mealType;
	}
	public String getMealType(){
		return mealType;
	}
	
	public void addCourse(Course course){
		this.course=course;
	}
	public void setOrder(int order){
		this.order=order;
	}
	public int getOrder(){
		return order;
	}
	
	public String toString(){
		return mealType+": "+course.toString();
	}
	
	

}
