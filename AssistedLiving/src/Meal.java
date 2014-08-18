


public class Meal {
	
	String mealType;

	Course course;
	
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
	
	

}
