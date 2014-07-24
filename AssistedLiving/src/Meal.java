import java.util.ArrayList;


public class Meal {
	
	String mealType;

	ArrayList<Course> courseList=new ArrayList<Course>();
	
	
	
	public void setMealType(String mealType){
		this.mealType=mealType;
	}
	public String getMealType(){
		return mealType;
	}
	
	public void addCourse(ArrayList<Course> courseList){
		//add stuff
	}
	public void addCourse(Course course){
		courseList.add(course);
	}
	
	

}
